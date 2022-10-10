/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guessnumber.controller;

import guessnumber.services.ATMService;
import guessnumber.services.IATMService;
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

    public UserActionBean() {
        _atmService = new ATMService();
    }
    
    public int getSaldo() {
        return _atmService.getSaldo();
    }
}
