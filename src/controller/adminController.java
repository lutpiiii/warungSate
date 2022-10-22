package controller;

import allObject.allObjectModel;

public class adminController {
    public int checkAdmin(String nama, String pass){
        return allObjectModel.adminmodel.checkAdmin(nama, pass);
    }
}
