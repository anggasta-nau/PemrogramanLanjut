/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.AtmModel;
import atm.mvc.Tampilan;
import java.util.Scanner;

/**
 *
 * @author Anggasta
 */
public class AtmView {
    Scanner myObj = new Scanner(System.in);
    Tampilan object = Tampilan.getInstance();

    
    public int mainMenu(){
        object.displayPesanBaris("Program ATM - MVC, DAO, Singleton");
        object.displayPesan("\nMenu : \n1. Cek Saldo \n2. Tarik Tunai\n3. Setor Tunai\n4. Keluar\n\nMasukkan Pilihan : ");
        return myObj.nextInt();
    }
    
    public void cekSaldo(AtmModel model){
        object.displayPesan("Sisa saldo : Rp.");
        object.displaySaldo(model.getSaldo());
    }
    
    public void tarikTunai(AtmModel model){
        int jumlah;
        object.displayPesan("Masukkan jumlah saldo tarik (kelipatan 50000) : Rp.");
        jumlah = myObj.nextInt();
        
        if(model.cekBatasSaldo()){
            object.displayPesanBaris("Saldo Anda Mencapai Limi \n Kembali ke menu utama");
        } else if((model.getSaldo()-jumlah)< model.limitSaldo()){
            object.displayPesanBaris("Jumlah Penarikan melebihi limit penarikan");
        } else if((model.getSaldo()> jumlah) && (model.cekTransaksi(jumlah) == 1)){
            model.tarikSaldo(jumlah);
            object.displayPesan("Anda Mengambil Uang Sejumlah : Rp.");
            object.displaySaldo(jumlah);
        } else{
            object.displayPesanBaris("Penarikan harus kelipatan 50000");
        }
    }
    
    public void setorTunai(AtmModel model){
        int jumlah;
        object.displayPesan("Masukkan jumlah setoran (kelipatan 50000): Rp.");
        jumlah = myObj.nextInt();
        if(model.cekTransaksi(jumlah)==1){
            model.tambahSaldo(jumlah);
            object.displayPesan("Berhasil menambahkan saldo sebesar Rp.");
            object.displaySaldo(jumlah);
        } else{
            object.displayPesanBaris("Inputan harus kelipatan 50000");
        }
        
    }
}