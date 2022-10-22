package controller;

import allObject.allObjectModel;
import entity.transaksiEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class transaksiController implements controllerInterface{

    @Override
    public ArrayList<transaksiEntity> getData() {
        return allObjectModel.transaksimodel.getData();
    }
    
    public DefaultTableModel dataTransaksi(){
        DefaultTableModel dataTrans = new DefaultTableModel();
        Object[] kolom = {"ID TRANSAKSI", "NAMA PEMBELI","TGL", "STATUS", "TOTAL"};
        dataTrans.setColumnIdentifiers(kolom);
        int size = getData().size();
        for (int i = 0; i < size; i++){
            Object[] data = new Object[5];
            data[0] = allObjectModel.transaksimodel.getData().get(i).getId();
            data[1] = allObjectModel.transaksimodel.getData().get(i).getNama_pembeli();
            data[2] = allObjectModel.transaksimodel.getData().get(i).getTgl();
            String x = allObjectModel.transaksimodel.getData().get(i).getStatus();
            int y = Integer.parseInt(x);
            if (y == 1){
                data[3] = "Sudah Dibayar";
            }
            else 
                data[3] = "Belum Dibayar";
            data[4] = allObjectModel.transaksimodel.getData().get(i).getHarga();
            dataTrans.addRow(data);
        }
        return dataTrans;
    }
    
    public int transaksi(int id_pembeli, int total){
        return allObjectModel.transaksimodel.transaksi(id_pembeli, total);
    }
    
    public void detail_transaksi(int id_transaksi, int id_barang){
        allObjectModel.transaksimodel.detail_transaksi(id_transaksi, id_barang);
    }
    
    public void sBayar(int id){
        allObjectModel.transaksimodel.sudahBayar(id);
    }
    
    public void bBayar(int id){
        allObjectModel.transaksimodel.belumBayar(id);
    }
}
