package com.hexbee.usermanagement.dto;

public class OrderItemDTO {
    
    private String name;
    private String price;
    private int quantity;

    public OrderItemDTO() {
        super();
    }

    public OrderItemDTO(String name, String price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItemDTO [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}

