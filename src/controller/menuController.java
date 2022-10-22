package controller;

import allObject.allObjectModel;
import entity.menuEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class menuController implements controllerInterface{

    @Override
    public ArrayList<menuEntity> getData() {
        return allObjectModel.menumodel.getData();
    }
    
    public void insertBarang(int id, int idjns, String nama, int harga){
        allObjectModel.menumodel.getInsert(new menuEntity(id, idjns, nama, harga));
    }

    public void updateBarang(int id, int idjns, String nama, int harga){
        allObjectModel.menumodel.updateBarang(id, idjns, nama, harga);
    }
    
    public void deleteBarang(int idbrg){
        allObjectModel.menumodel.getDelete(idbrg);
    }
    
    public DefaultTableModel daftarMenu(){
        DefaultTableModel daftarMenu = new DefaultTableModel();
        Object[] kolom = {"ID", "Nama Menu","Harga Menu"};
        daftarMenu.setColumnIdentifiers(kolom);
        int size = getData().size();
        for(int i = 0; i < size; i++){
            Object[] data = new Object[5];
            data[0] = allObjectModel.menumodel.getData().get(i).getId();
            data[1] = allObjectModel.menumodel.getData().get(i).getNama();
            data[2] = allObjectModel.menumodel.getData().get(i).getHarga();
            daftarMenu.addRow(data);
        }
        return daftarMenu;
    }
}