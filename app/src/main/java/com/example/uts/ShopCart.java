package com.example.uts;

public class ShopCart {
    private Integer menuFoto;
    private String menuName;
    private Integer menuPrice;
    private Integer quantity;

    public ShopCart(Integer menuFoto, String menuName, Integer menuPrice, Integer quantity) {
        this.menuFoto = menuFoto;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.quantity = quantity;
    }

    public Integer getMenuFoto() {
        return menuFoto;
    }

    public void setMenuFoto(Integer menuFoto) {
        this.menuFoto = menuFoto;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
