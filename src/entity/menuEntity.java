package entity;

public class menuEntity extends entityAbstract {
    protected int harga, idjns;
    protected String nama, namajns;
    
    public menuEntity(){}
    
    public menuEntity(int id, int idjns,  String nama, int harga){
        super(id);
        this.idjns = idjns;
        this.nama = nama;
        this.harga = harga;
    }
    
    public menuEntity(int id, String namajns,  String nama, int harga){
        super(id);
        this.namajns = namajns;
        this.nama = nama;
        this.harga = harga;
    }
    
    

    public String getNamajns() {
        return namajns;
    }

    public void setNamajns(String namajns) {
        this.namajns = namajns;
    }

    public int getIdjns() {
        return idjns;
    }

    public void setIdjns(int idjns) {
        this.idjns = idjns;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
