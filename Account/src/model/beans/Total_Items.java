/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Gepardas
 */
public class Total_Items {

    
    private Long ID;
    private String Name;
    private String Size;
    private String Color;
    private String Description;
    private double Price;
    private int quantity;
    private double total;
    
    ObservableList<Total_Items> itemsList;

   
    

   

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

   

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotal() {
        return Price*quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    } 

     public ObservableList<Total_Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ObservableList<Total_Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return  Name + " " + Size + " " + Color + " " + Description;
    }
    
    
    
    
}
