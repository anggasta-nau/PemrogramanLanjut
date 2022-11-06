/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir.models;

/**
 *
 * 
 */
public class model {
    private int id_produk;
    private String nama;
    private int harga;
    private String ket;
    private boolean sts;
    private String nama_barang;
    
    
    public model(int id_produk,String nama,int harga,String ket,boolean sts)
    {
        this.nama=nama;
        this.harga=harga;
        this.ket=ket;
        this.sts=sts;
        this.id_produk=id_produk;
    }
    
    public model()
    {
        
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public boolean getSts() {
        return sts;
    }

    public void setSts(boolean sts) {
        this.sts = sts;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

}


    
    
    
  
