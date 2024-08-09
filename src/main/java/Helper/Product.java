/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stutipatel
 */
@XmlRootElement
public class Product{
    private int productID;
    private String productName;
    private String currency;
    private float price;
    private String brand;
    private String category;
    private int stock;
    private boolean availability;
    
   public Product(int productID, String productName, String currency, float price, String brand,  String category, int stock, boolean availability){
        this.productID = productID;
        this.productName = productName;
        this.currency = currency;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.stock = stock;
        this.availability = availability;
    }
    
    public Product(){
        //default constructor
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }
    public int getProductID(){
        return this.productID;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getProductName(){
        return this.productName;
    }
    
    public void setCurrency(String currency){
        this.currency = currency;
    }
    public String getCurrency(){
        return this.currency;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return this.price;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return this.brand;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return this.category;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getStock(){
        return this.stock;
    }
    
    public void setAvailability(boolean availability){
        this.availability = availability;
    }
    public boolean getAvailability(){
        return this.availability;
    }
}