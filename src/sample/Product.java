package sample;

import javafx.scene.control.ComboBox;

public class Product{

    private String name;
    private double price;
    private int quantity;
    private String size;
    private ComboBox size1;

    public Product(){
        this.name ="";
        this.price = 0;
        this.quantity = 0;
        this.size = "";
    }

    public Product(String name, double price, int quantity, String size){
        this.name = name;
        this.price=price;
        this.quantity=quantity;
        this.size=size;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}

