/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kasir.models.daftarModel;
import kasir.models.daftarTransaksi;
import kasir.models.model;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 *
 * 
 */
@Named("trans")
@SessionScoped
public class transaksiBean implements Serializable{
    private int id_trans;
    private int id_now;
    private int no_trans;
    private String nama_pel;
    private String barang;
    private String nama;
    private int total;
    private int qty;
    private int bayar;
    private int kembalian;
    private int id_produk;
    private String notif;
    private int id_transaksi;
    private String namapel;
    private int totalharga;
    private int id;
    private List<daftarTransaksi>list;
    private daftarTransaksi dts;
    ArrayList<daftarTransaksi>transList;


public transaksiBean()throws IOException{}
 public daftarTransaksi getDts() {
        return dts;
    }

    public List<daftarTransaksi> getList() {
        return list;
    }
        public void doTransaksi(int id_produk)throws IOException{
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        model product = (model) sqlSession.selectOne("Kasir.getById",id_produk);
        id_now=product.getId_produk();
        total = qty * product.getHarga();
        barang = product.getNama();
        sqlSession.commit();
        sqlSession.close();
    }
        
     public void doTransaksio()throws IOException{
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
 
        model product = (model) sqlSession.selectOne("Kasir.getById",id_now);
        total = qty * product.getHarga();
        barang = product.getNama();
        sqlSession.commit();
        sqlSession.close();
    }
    
    
    
    public void Kembalian() throws IOException{
        if(bayar>=total){ 
        notif="transaksi berhasil";
        kembalian = bayar - total;  
        CTransaksi();
        CDTransaksi();
        }
        else
        {
        kembalian = bayar - total;
        notif="transaksi gagal";   
        }
    }
    
    public void CTransaksi()throws IOException{
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigTransaksi.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        daftarModel dm  = new daftarModel(no_trans ,nama_pel,id_now,barang,qty,total, bayar, kembalian);
        sqlSession.insert("Transaksi.insert",dm);
        sqlSession.commit();
        sqlSession.close();
        
    }
    public void CDTransaksi()throws IOException{
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigDaftar.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        daftarTransaksi dt  = new daftarTransaksi(id_transaksi=no_trans ,namapel=nama_pel,totalharga=total);
        sqlSession.insert("Daftar.insert",dt);
        sqlSession.commit();
        sqlSession.close();
        
    }
    
    public void doDelete(int id_produk) throws IOException
    {
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigTransaksi.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("Transaksi.delete",id_produk);
        sqlSession.commit();
        sqlSession.close();
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_now() {
        return id_now;
    }

    public void setId_now(int id_now) {
        this.id_now = id_now;
    }
    
   
    
    
    }

    
    
    
