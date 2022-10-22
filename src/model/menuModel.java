package model;

import Helper.Db;
import entity.menuEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class menuModel extends modelAbstract {
    protected static ArrayList<menuEntity> menuentity = new ArrayList<menuEntity>();
    private String sql;
    public Connection conn = Db.getconection();
    
    @Override
    public ArrayList<menuEntity> getData() {
        ArrayList<menuEntity> arraylistMenu = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT barang.id_barang, barang.jnsbrg_id, jnsbrg.nama_jnsbrg, barang.nama_barang, barang.harga_barang "
                    + "FROM jnsbrg JOIN barang ON barang.jnsbrg_id = jnsbrg.id_jnsbrg";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                int id, harga;
                String nama, namajns;
                id = rs.getInt("id_barang");
//                idjns = rs.getInt("jnsbrg_id");
                namajns = rs.getString("nama_jnsbrg");
                nama = rs.getString("nama_barang");
                harga = rs.getInt("harga_barang");
                
                arraylistMenu.add(new menuEntity(id, namajns, nama, harga));
            }
        }catch(SQLException e){
            System.out.println(e); 
        }
        return arraylistMenu;
    }
    
    public void getInsert(menuEntity menuentity){
        try{
            sql = "INSERT INTO barang (id_barang, jnsbrg_id, nama_barang, harga_barang) values (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, menuentity.getId());
            stat.setInt(2, menuentity.getIdjns());
            stat.setString(3, menuentity.getNama());
            stat.setInt(4, menuentity.getHarga());
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void updateBarang(int id, int jns, String nama, int harga){
        try{
            sql = "UPDATE barang set jnsbrg_id = ?, nama_barang = ?, harga_barang = ? WHERE id_barang = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, jns);
            stat.setString(2, nama);
            stat.setInt(3, harga);
            stat.setInt(4, id);
            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("GAGAL RUBAH NAMA!!!");
            e.printStackTrace();
        }
    }    
    
//    public void updateNamaBarang(String nama, int id){
//        try{
//            sql = "UPDATE barang set nama_barang = ? WHERE id_barang = ?";
//            PreparedStatement stat = conn.prepareStatement(sql);
//            stat.setString(1, nama);
//            stat.setInt(2, id);
//            stat.executeUpdate();
//        }catch (SQLException e){
//            System.out.println("GAGAL RUBAH NAMA!!!");
//            e.printStackTrace();
//        }
//    }
//    
//    public void updateHargaBarang(int harga, int id){
//        try{
//            sql = "UPDATE barang set harga_barang = ? WHERE id_barang = ?";
//            PreparedStatement stat = conn.prepareStatement(sql);
//            stat.setInt(1, harga);
//            stat.setInt(2, id);
//            stat.executeUpdate();
//        }catch (SQLException e){
//            System.out.println("GAGAL RUBAH NAMA!!!");
//            e.printStackTrace();
//        }
//    }
    
    public void getDelete(int idbrg){
        try{
            sql = "DELETE FROM barang WHERE id_barang = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, idbrg);
            stat.executeUpdate();
        }catch (SQLException e) {
            System.out.println("GAGAL Hapus DATA!!!");
        }
    }
    
//    public void showdata(){
//        for(menuEntity menuent : getData()){
//            System.out.println("id : " + menuent.getId());
//            System.out.println("Jenis Barang : " + menuent.getNamajns());
//            System.out.println("nama :" + menuent.getNama());
//            System.out.println("harga : " + menuent.getHarga());
//            System.out.println("");
//        }
//    }
    
    
    
//    public static void main(String[] args) {
//        menuModel menu = new menuModel();
//        menu.updateBarang(10, 2, "JJJJJ", 99999);
//    }
}
