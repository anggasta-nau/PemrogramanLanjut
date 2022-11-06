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
@Named("data")
@RequestScoped
public class dataBean implements Serializable{
    private int id_produk;
    private int harga;
    private String nama;
    private String ket;
    private boolean sts;
    private List<model>list;
    private model mdl;
    ArrayList<model>modelList;

    public dataBean()throws IOException
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
        List<model> arrmodel = sqlSession.selectList("Kasir.true");
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
    
     public void doCreate() throws IOException
    {
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        model md = new model (id_produk,nama,harga,ket,sts=true);
        sqlSession.insert("Kasir.insert",md);
        sqlSession.commit();
        sqlSession.close();
    }
     
      public void doUpdate() throws IOException
    {
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        model mdd = (model) sqlSession.selectOne("Kasir.getById",id_produk);
        mdd.setNama(this.nama);
        mdd.setHarga(this.harga);
        mdd.setKet(this.ket);
        sqlSession.update("Kasir.update",mdd);
        sqlSession.commit();
        sqlSession.close();
    }
      
    public void delete(int id_produk) throws IOException
    {
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("Kasir.delete",id_produk);
        sqlSession.commit();
        sqlSession.close();
    } 
     public void doSts() throws IOException
    {
        Reader reader = Resources.getResourceAsReader("kasir/config/ConfigMyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        model mdds = (model) sqlSession.selectOne("Kasir.getById",id_produk);
        mdds.setSts(this.sts);
        sqlSession.update("Kasir.sts",mdds);
        sqlSession.commit();
        sqlSession.close();
    }
}
