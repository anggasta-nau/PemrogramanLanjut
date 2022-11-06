/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir.models;

/**
 *
 *
 */
public class daftarTransaksi {
    private int id;
    private int id_transaksi;
    private String namapel;
    private int totalharga;

public daftarTransaksi(int id_transaksi,String namapel,int totalharga)
{
    this.totalharga=totalharga;
    this.id_transaksi=id_transaksi;
    this.namapel=namapel;
}
public daftarTransaksi()
{
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getNamapel() {
        return namapel;
    }

    public void setNamapel(String namapel) {
        this.namapel = namapel;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }



}