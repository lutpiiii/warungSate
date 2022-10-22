package controller;

import allObject.allObjectModel;
import entity.pembeliEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class pembeliController implements controllerInterface{

    @Override
    public ArrayList<pembeliEntity> getData() {
        return allObjectModel.pembelimodel.getData();
    }
    
    public void insertPembeli (int id, String nama, String pass, String notelp, String alamat){
        allObjectModel.pembelimodel.getInsert(new pembeliEntity(0, nama, pass, notelp, alamat));
    }
    
    public int checkPembeli(String nama, String pass){
         return allObjectModel.pembelimodel.checkPembeli(nama, pass);
    }

    public void deletePembeli (int id){
        allObjectModel.pembelimodel.getdelete(id);
    }

    public void updatePembeli (int id, String nama, String pass, String notelp, String alamat){
        allObjectModel.pembelimodel.getupdate(id, nama, pass, notelp, alamat);
    }

    public String getNama(int id){
        return allObjectModel.pembelimodel.getNama(id);
    }

    public ArrayList<pembeliEntity> getDataById(int id){
        return allObjectModel.pembelimodel.getDataByID(id);
    }
   
    public void deletPembeli(int idpembeli){
        allObjectModel.pembelimodel.deletePembeli(idpembeli);
    }
    
    public DefaultTableModel dataUser(){
        DefaultTableModel daftarUser = new DefaultTableModel();
        Object[] kolom = {"ID", "NAMA", "PASSWORD", "NOTELP", "ALAMAT"};
        daftarUser.setColumnIdentifiers(kolom);
        int size = getData().size();
        for(int i = 0; i < size; i++){
            Object[] data = new Object[5];
            data[0] = allObjectModel.pembelimodel.getData().get(i).getId();
            data[1] = allObjectModel.pembelimodel.getData().get(i).getNama();
            data[2] = allObjectModel.pembelimodel.getData().get(i).getPass();
            data[3] = allObjectModel.pembelimodel.getData().get(i).getNotelp();
            data[4] = allObjectModel.pembelimodel.getData().get(i).getAlamat();
            daftarUser.addRow(data);
        }
       return daftarUser;
    }
   
//    public static void main(String[] args) {
//        pembeliController p = new pembeliController();
//        System.out.println("nama : " + p.getNama(2));
//    }
}
