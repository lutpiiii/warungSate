package model;

import Helper.Db;
import entity.transaksiEntity;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class transaksiModel extends modelAbstract{
    protected static ArrayList<transaksiEntity> transEnt = new ArrayList<transaksiEntity>();
    private String sql;
    public Connection conn = Db.getconection();
    
    @Override
    public ArrayList<transaksiEntity> getData(){
        ArrayList<transaksiEntity> arraylistTrans = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "SELECT transaksi.id_transaksi,bio_pembeli.nama_pembeli, transaksi.tgl_transaksi, transaksi.status ,transaksi.total FROM transaksi INNER JOIN bio_pembeli "
                    + " ON transaksi.pembeli_id = bio_pembeli.id_pembeli; ";
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                transaksiEntity entity = new transaksiEntity();
                entity.setId(rs.getInt("id_transaksi"));
                entity.setNama_pembeli(rs.getString("nama_pembeli"));
                entity.setTgl(rs.getString("tgl_transaksi"));
                entity.setStatus(rs.getString("status"));
                entity.setHarga(rs.getInt("total"));
                
                arraylistTrans.add(entity);
                
//                arraylistTrans.add(new transaksiEntity(id, tgl, idpem, harga, banyak, total, status));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return arraylistTrans;
    }
    
    public void showdata(){
        for(transaksiEntity p : getData()){
            System.out.println(p.getId()+" "
                    +p.getIdpem()+" "
                    +p.getTgl()+" "
                    +p.getHarga()+" "
                    +p.getBanyak()+" "
                    +p.getTotal()+" "
                    +p.getStatus());
        }
    }
    
    public void showdata2(){
        for(transaksiEntity p : getData()){
            System.out.println("Id: "+p.getId());
            System.out.println("Nama : "+p.getNama_pembeli() );
            System.out.println("Tgl: "+p.getTgl());
            System.out.println("Total: "+p.getHarga());
        }
    }
    
    public int transaksi(int id_pembeli, int total){
        int lastId = 0;
        try{
            sql = "INSERT INTO transaksi(pembeli_id,tgl_transaksi,status,total) VALUES(?,NOW(),0,?)";
            PreparedStatement stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, id_pembeli);
            stat.setInt(2, total);
            stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();
            
            if(rs.next()){
                lastId = rs.getInt(1);
            }else{
                lastId = 0;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
    }
        return lastId;
  }
    
  public void detail_transaksi(int id_transaksi,int id_barang){
      try{
          sql = "INSERT INTO detail_transaksi(transaksi_id,barang_id) VALUES(?,?)";
          PreparedStatement stat = conn.prepareStatement(sql);
          stat.setInt(1, id_transaksi);
          stat.setInt(2, id_barang);
          stat.executeUpdate();
      }catch(SQLException e){
          e.printStackTrace();
      }
  }
  
    public void sudahBayar(int id){
        try {
            sql = "update transaksi SET status = 1 WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void belumBayar(int id){
        try {
            sql = "update transaksi SET status = 1 WHERE id_transaksi =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        transaksiModel model = new transaksiModel();
        model.showdata2();;
    }
    
   
    
}
