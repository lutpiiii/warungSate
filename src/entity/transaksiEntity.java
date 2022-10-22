package entity;

import java.util.Date;

public class transaksiEntity extends entityAbstract{
    protected String status;
    protected int harga,total, banyak, idpem;
    protected String nama_pembeli,tgl;
    
    public transaksiEntity(){
    }  public transaksiEntity(int id, String tgl, int idpem, int harga, int banyak, int total, String status) {
        super(id);
        this.idpem = idpem;
        this.tgl = tgl;
        this.harga = harga;
        this.banyak = banyak;
        this.total = total;
        this.status = status;
    }
    
    public transaksiEntity(int id, String nama_pembeli, String tgl, int total_harga){
        super(id);
        this.nama_pembeli = nama_pembeli;
        this.tgl = tgl;
        this.harga = total_harga;
        
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public int getIdpem() {
        return idpem;
    }

    public void setIdpem(int idpem) {
        this.idpem = idpem;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
        
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
