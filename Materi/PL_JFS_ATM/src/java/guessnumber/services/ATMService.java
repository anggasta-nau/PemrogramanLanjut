/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guessnumber.services;

import guessnumber.model.Saldo;

/**
 *
 * @author Anggasta
 */
public class ATMService implements IATMService {
    
    private Saldo _saldo;

    public ATMService() {
        _saldo = Saldo.getInstance();
    }
    
    @Override
    public int getSaldo() {
        return _saldo.getAmount();
    }
    
}
