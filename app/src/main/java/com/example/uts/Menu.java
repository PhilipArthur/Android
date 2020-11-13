package com.example.uts;

import java.io.Serializable;

public class Menu implements Serializable {

    private Integer foto;
    private String menuName;
    private String menuPrice;


    public Menu(Integer foto, String menuName, String menuPrice) {
        this.foto = foto;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }
}
