/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import account.view.GenerateInvoiceController;
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

    String buyerName;
    String buyerCode;
    String buyerAdress;
    String buyerCity;
    String buyerCountry;
    String buyerPhone;

    Seller seller;
    Client client;
    Invoice invoice;
    Total_Items totalItems;
    GenerateInvoiceController contoler;
    private ObservableList<Total_Items> itemsList;

    public InvoiceData() {
        itemsList = FXCollections.observableArrayList();
    }

    public String getBuyerInfo2() {

        return buyerName + "\n" + buyerCode + "\n" + buyerAdress + "\n" + buyerCity + "\n" + buyerCountry + "\n" + buyerPhone;
    }

    public void setBuyerInfo2(String name, String code, String adress, String city, String country, String phone) {
        this.buyerName = name;
        this.buyerCode = code;
        this.buyerAdress = adress;
        this.buyerCity = city;
        this.buyerCountry = country;
        this.buyerPhone = phone;
    }

    public ObservableList<Total_Items> getItemsList() {
        return itemsList;
    }

    public void addTotalItemObject(Total_Items item) {
        this.itemsList.add(item);
    }

    public void setList(ObservableList<Total_Items> items) {
        this.itemsList=items;
    }
    

}
