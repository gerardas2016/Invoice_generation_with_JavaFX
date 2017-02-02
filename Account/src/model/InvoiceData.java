/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import account.view.GenerateInvoiceController;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.beans.Client;
import model.beans.Invoice;
import model.beans.Item;
import model.beans.Seller;
import model.beans.Total_Items;

/**
 *
 * @author Gepardas
 */
public class InvoiceData {

    String sellerName;
    Long sellerCode;
    String sellerAdress;
    String sellerCity;
    String sellerCountry;
    String sellerPhone;
    

    String buyerName;
    String buyerCode;
    String buyerAdress;
    String buyerCity;
    String buyerCountry;
    String buyerPhone;
    
    Long InvoiceId;

    private int vat = 21;

    DataBaseImport database;
    Seller seller;
    Client client;
    Invoice invoice;
    Total_Items totalItems;
    GenerateInvoiceController contoler;
    private ObservableList<Total_Items> itemsList;

    public InvoiceData() {
        itemsList = FXCollections.observableArrayList();

    }

    public LocalDate getLocalDate() {

        LocalDate today = LocalDate.now();

        return today;
    }
    
    
    public void setInvoiceNumber(){
    database= new DataBaseImport();
    this.InvoiceId= database.GetInvoiceData().getId();
    }
    
    public int getInvoiceNumber(){
    setInvoiceNumber();
        int invoiceNum=0;
        if (InvoiceId==null){
      //  int i=   Integer.parseInt(InvoiceId);
        invoiceNum= 1;
        
        }
        else{
          invoiceNum= (int) (this.InvoiceId+1);
        }
        
      
    
    
    return invoiceNum;
    }
    

    public String getBuyerInfo2() {

        return "Company name: " + buyerName + "\n"
                + "Buyer Code: " + buyerCode + "\n"
                + "Adress: " + buyerAdress + "\n"
                + "City: " + buyerCity + "\n"
                + "Country: " + buyerCountry + "\n"
                + "Phone: " + buyerPhone;
    }

    public void setBuyerInfo2(String name, String code, String adress, String city, String country, String phone) {
        this.buyerName = name;
        this.buyerCode = code;
        this.buyerAdress = adress;
        this.buyerCity = city;
        this.buyerCountry = country;
        this.buyerPhone = phone;
    }

    public void setSellername() {
        database = new DataBaseImport();
 
        this.sellerName = database.GetSellerData().getName();
        this.sellerCode = database.GetSellerData().getCode();
        this.sellerAdress = database.GetSellerData().getAdress();
        this.sellerCity = database.GetSellerData().getCity();
        this.sellerCountry = database.GetSellerData().getCountry();
        this.sellerPhone = database.GetSellerData().getPhone();
       
    }

    public String getSellername() {
    setSellername();
    
       
        return "Company name: " + sellerName + "\n"
                + "Seller Code: " + sellerCode + "\n"
                + "Adress: " + sellerAdress + "\n"
                + "City: " + sellerCity + "\n"
                + "Country: " + sellerCountry + "\n"
                + "Phone: " + sellerPhone;

    }

    public ObservableList<Total_Items> getItemsList() {
        return itemsList;
    }

    public void addTotalItemObject(Total_Items item) {
        this.itemsList.add(item);
    }

    public void setList(ObservableList<Total_Items> items) {
        this.itemsList = items;

    }

    public double getTotalPrice() {
        double totalPrice = 0;

        for (Total_Items total_Items : itemsList) {
            totalPrice = totalPrice + total_Items.getTotal();

        }

        return totalPrice;
    }

    public int getVat() {
        return vat;
    }

    public double getVatsum() {
        double vatSum = getTotalPrice() * vat / 100;

        return vatSum;
    }

    public double getTotalIncVat() {

        double totalIncVat = getTotalPrice() + getVatsum();

        return totalIncVat;
    }

}
