/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir.beans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kasir.models.model;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 *
 */
@Named("db")
@RequestScoped
public class viewdb implements Serializable{
    private int id_produk;
    private int harga;
    private String nama;
    private String ket;
    private boolean sts;
    private List<model>list;
    private model mdl;
    ArrayList<model>modelList;

    public viewdb()throws IOException
    {
        this.list = allData();

    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    
    public model getMdl() {
        return mdl;
    }

    public List<model> getList() {
        return list;
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

   

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public boolean isSts() {
        return sts;
    }

    public void setSts(boolean sts) {
        this.sts = sts;
    }

    public List<model>allData()throws IOException
    {
        modelList = new ArrayList();
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<model> arrmodel = sqlSession.selectList("Kasir.getAll");
        sqlSession.commit();
        sqlSession.close();
        for(model mdl : arrmodel)
        {
            model models = new model();
            models.setId_produk(mdl.getId_produk());
            models.setNama(mdl.getNama());
            models.setHarga(mdl.getHarga());
            models.setKet(mdl.getKet());
            models.setSts(mdl.getSts());
            modelList.add(mdl);
        }
        return modelList;
    }
    
    
}
