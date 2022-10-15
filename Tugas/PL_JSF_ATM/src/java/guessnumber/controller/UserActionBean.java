/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guessnumber.controller;

import guessnumber.services.ATMService;
import guessnumber.services.IATMService;
import java.io.Console;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Anggasta
 */
@ManagedBean(name = "userActionBean")
@RequestScoped
public class UserActionBean {
    private IATMService _atmService;
    private int jumlahTarik;
    private int jumlahSetor;

    public UserActionBean() {
        _atmService = new ATMService();
    }
    
    public int getSaldo() {
        return _atmService.getSaldo();
    }

    public IATMService getAtmService() {
        return _atmService;
    }

    public void setAtmService(IATMService _atmService) {
        this._atmService = _atmService;
    }

    public int getJumlahTarik() {
        return jumlahTarik;
    }

    public void setJumlahTarik(int jumlahTarik) {
        if(
                jumlahTarik%50000==0 
                && jumlahTarik<_atmService.getSaldo() 
                && (_atmService.getSaldo()-jumlahTarik)>=100000
          )
            {
             this.jumlahTarik = jumlahTarik;
            }
        else{
             this.jumlahTarik = 0;
            }
    }

    public int getJumlahSetor() {
        return jumlahSetor;
    }

    public void setJumlahSetor(int jumlahSetor) {
        if(jumlahSetor%50000==0){
        this.jumlahSetor = jumlahSetor;
        } else {
            this.jumlahSetor =0;
        }
    }
    
    
    
    public void tarikSaldo(){
            _atmService.tarikTunai(_atmService.getSaldo()-getJumlahTarik());  
    }
    
    public void setorSaldo(){
        _atmService.setorTunai(_atmService.getSaldo()+getJumlahSetor());
    }
}
