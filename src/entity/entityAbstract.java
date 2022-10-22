package entity;

public abstract class entityAbstract {
    protected int id;
    
    public entityAbstract(){}
    
    public entityAbstract(int id){
    this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
