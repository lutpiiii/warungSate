package entity;
/**
 *
 * @author IAM-LUTFI
 */
public class pembeliEntity extends entityAbstract{
    protected String nama, pass, alamat, notelp;
    
    public pembeliEntity(){}

    public pembeliEntity(int id, String nama, String pass, String notelp, String alamat) {
        super(id);
        this.nama = nama;
        this.pass = pass;
        this.notelp = notelp;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNo_hp(String notelp) {
        this.notelp = notelp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
