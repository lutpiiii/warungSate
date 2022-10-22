package model;

import Helper.Db;
import entity.pembeliEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class pembeliModel extends modelAbstract{
    Date date = new Date();
    protected static ArrayList<pembeliEntity> pembelientity = new ArrayList<pembeliEntity>();
    private String sql;
    public Connection conn = Db.getconection();

    @Override
    public ArrayList<pembeliEntity> getData(){
        ArrayList<pembeliEntity> arraylistPembeli = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT * from bio_pembeli";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id;
                String nama,pass,notelp,alamat;
                id = rs.getInt("id_pembeli");
                nama =rs.getString("nama_pembeli");
                pass = rs.getString("password");
                notelp = rs.getString("notelp_pembeli");
                alamat = rs.getString("alamat_pembeli");
                
                arraylistPembeli.add(new pembeliEntity(id, nama, pass, notelp, alamat));
            }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistPembeli;
    }   
    
    public ArrayList<pembeliEntity> getDataByID(int id){
        ArrayList<pembeliEntity> arraylistPembeli = new ArrayList<>();
        try{
            sql = "SELECT * from bio_pembeli WHERE id_pembeli = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            
            
            while(rs.next()){
                String nama,pass,notelp,alamat;
                id = rs.getInt("id_pembeli");
                nama =rs.getString("nama_pembeli");
                pass = rs.getString("password");
                notelp = rs.getString("notelp_pembeli");
                alamat = rs.getString("alamat_pembeli");
                
                arraylistPembeli.add(new pembeliEntity(id, nama, pass, notelp, alamat));
            }
        }catch(SQLException e){
        System.out.println(e);
        }
        return arraylistPembeli;
    }   
    
    public void getInsert(pembeliEntity pembelientity){
        try{
            sql = "INSERT INTO bio_pembeli (id_pembeli, nama_pembeli, password, notelp_pembeli, alamat_pembeli ) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, pembelientity.getId());
            preparedStatement.setString(2,pembelientity.getNama());
            preparedStatement.setString(3,pembelientity.getPass());
            preparedStatement.setString(4,pembelientity.getNotelp());
            preparedStatement.setString(5,pembelientity.getAlamat());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void getupdate(int id, String nama, String pass, String notelp, String alamat) {
        int row = 0;
        try {
            String sql = "UPDATE bio_pembeli SET nama_pembeli = ?,password = ?, notelp_pembeli = ?, alamat_pembeli = ? WHERE id_pembeli = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setString(2, pass);
            ps.setString(3, notelp);
            ps.setString(4, alamat);
            ps.setInt(5,id);
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getdelete(int id) {
        try {
            sql = "DELETE FROM bio_pembeli WHERE id_pembeli = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.executeUpdate();
        }catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }   
    
    public int checkPembeli(String nama, String pass) { 
     int cek = 0;
     try {
         Statement stat = conn.createStatement();
         sql = "SELECT * FROM bio_pembeli WHERE nama_pembeli='"+nama+"' AND password='"+pass+"'";
         ResultSet rs = stat.executeQuery(sql);
         rs = stat.executeQuery(sql);
         if(rs.next()){
             if(nama.equals(rs.getString("nama_pembeli")) && pass.equals(rs.getString("password"))){
                 System.out.println("berhasil login");
                 cek = rs.getInt("id_pembeli");
             }
         }else{
                 System.out.println("gagal login");
                 cek=0;
             }
     } catch (Exception e) {
         System.out.println(e);
     }
     return cek;
    }
    
    public void deletePembeli(int idpembeli){
        try{
            sql = "DELETE FROM bio_pembeli WHERE id_pembeli = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, idpembeli);
            stat.executeUpdate();
        }catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }    
    }
    
    public void showdata(int id){
        for(pembeliEntity p : getDataByID(id)){
            System.out.println("id : " + p.getId());
            System.out.println("Jenis Barang : " + p.getNama());
            System.out.println("nama :" + p.getPass());
            System.out.println("harga : " + p.getNotelp());
            System.out.println("harga : " + p.getAlamat());
            System.out.println("");
        }
    }
        
        public String getNama(int id){
            try{
                sql = "SELECT nama_pembeli FROM bio_pembeli WHERE id_pembeli = ?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setInt(1, id);

                ResultSet rs = stat.executeQuery();
                if(rs.next()){
                    return rs.getString("nama_pembeli");
                }
            }catch(SQLException e){
                System.out.println(e);
            }
            
            return null;
        }
    
    public static void main(String[] args) {
//        String nama = getNama(1);
        pembeliModel p = new pembeliModel();
        System.out.println("nama : " + p.getNama(2));
//        p.showdata(2);
    }
}
