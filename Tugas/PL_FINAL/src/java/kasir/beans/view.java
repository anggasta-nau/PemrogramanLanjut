/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kasir.models.daftarModel;
import kasir.models.daftarTransaksi;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * 
 */
@Named("dataview")
@RequestScoped
public class view implements Serializable{
    private int id_trans;
    private int no_trans;
    private String nama_pel;
    private int id_produk;
    private String barang;
    private int view;
    private int qty;
    private int total;
    private int bayar;
    private int kembalian;
    private int id_transaksi;
    private int idnow;
    private List<daftarModel>list;
    private daftarModel d;
    ArrayList<daftarModel>modList;
    
public view()throws IOException
{
    this.list=allView();
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

    public daftarModel getD() {
        return d;
    }

    public int getIdnow() {
        return idnow;
    }

    public void setIdnow(int idnow) {
        this.idnow = idnow;
    }
    
    

    public List<daftarModel> getList() {
        return list;
    }
  
    public void doView() throws IOException{
        view=idnow;
    }
    public List<daftarModel>allView()throws IOException
    {
        modList = new ArrayList();
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigTransaksi.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<daftarModel> arrmodel = sqlSession.selectList("Transaksi.getAll");
        sqlSession.commit();
        sqlSession.close();
         for(daftarModel d : arrmodel)
        {
            daftarModel models = new daftarModel();
            models.setId_trans(d.getId_trans());
            models.setNo_trans(d.getNo_trans());
            models.setNama_pel(d.getNama_pel());
            models.setId_produk(d.getId_produk());
            models.setBarang(d.getBarang());
            models.setQty(d.getQty());
            models.setTotal(d.getTotal());
            models.setBayar(d.getBayar());
            models.setKembalian(d.getKembalian());
            modList.add(d);
        }
         return modList;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    
}
