package model;

import Helper.Db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class adminModel {
    private String sql;
    public Connection conn = Db.getconection();
    public int checkAdmin(String nama, String pass) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM bio_pembeli WHERE nama_pembeli='admin' AND password='admin'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(nama.equals(rs.getString("nama_pembeli")) && pass.equals(rs.getString("password"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt(1);
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
}
