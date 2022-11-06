/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir.models;

/**
 *
 *
 */
public class daftarModel {
    private int id_trans;
    private int no_trans;
    private String nama_pel;
    private int total;
    private int qty;
    private int bayar;
    private int kembalian;
    private String barang;
    private int id_produk;

   
    
   public daftarModel(int no_trans,String nama_pel,int id_produk,String barang,int qty,int total,int bayar,int kembalian)
    {
        this.no_trans = no_trans;
        this.nama_pel=nama_pel;
        this.qty=qty;
        this.total=total;
        this.bayar=bayar;
        this.kembalian=kembalian;
        this.id_produk=id_produk;
        this.barang=barang;
    }
    
    public daftarModel()
    {
        
    }

    public int getId_trans() {
        return id_trans;
    }

    public void setId_trans(int id_trans) {
        this.id_trans = id_trans;
    }

    public int getNo_trans() {
        return no_trans;
    }

    public void setNo_trans(int no_trans) {
        this.no_trans = no_trans;
    }

    public String getNama_pel() {
        return nama_pel;
    }

    public void setNama_pel(String nama_pel) {
        this.nama_pel = nama_pel;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

   
    
    
    

}
