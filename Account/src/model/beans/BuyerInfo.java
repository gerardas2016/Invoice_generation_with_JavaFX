/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.beans;

/**
 *
 * @author Gepardas
 */
public class BuyerInfo {
    String buyerName;
    String buyerCode;
    String buyerAdress;
    String buyerCity;
    String buyerCountry;
    String buyerPhone;

    public BuyerInfo(String buyerName, String buyerCode, String buyerAdress, String buyerCity, String buyerCountry, String buyerPhone) {
        this.buyerName = buyerName;
        this.buyerCode = buyerCode;
        this.buyerAdress = buyerAdress;
        this.buyerCity = buyerCity;
        this.buyerCountry = buyerCountry;
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerAdress() {
        return buyerAdress;
    }

    public void setBuyerAdress(String buyerAdress) {
        this.buyerAdress = buyerAdress;
    }

    public String getBuyerCity() {
        return buyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }

    public String getBuyerCountry() {
        return buyerCountry;
    }

    public void setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    @Override
    public String toString() {
        return "BuyerInfo{" + "buyerName=" + buyerName + ", buyerCode=" + buyerCode + ", buyerAdress=" + buyerAdress + ", buyerCity=" + buyerCity + ", buyerCountry=" + buyerCountry + ", buyerPhone=" + buyerPhone + '}';
    }
    
}
