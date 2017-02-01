
package model.beans;

import java.util.Date;

/**
 *
 * @author Gepardas
 */
public class Invoice {
    
    private String buyerName;
    private String buyerCode;
    private String buyerAdress;
    private String buyerCity;
    private String buyerCountry;
    private String buyerPhone;
    private String buyerEmail;
    private String buyerGetAlldata;
    
    private Long id;
    private Date date;
    private double totalExcVat;
    private int vat;
    private int total;

   
    
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
     public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }


    public String getBuyerGetAlldata() {
        System.out.println(buyerName+ "\n"+ buyerCode+ "\n"+ buyerAdress+ "\n"+ buyerCity+ "\n"+buyerCountry+"\n"+buyerPhone);
        return buyerName+ "\n"+ buyerCode+ "\n"+ buyerAdress+ "\n"+ buyerCity+ "\n"+buyerCountry+"\n"+buyerPhone;
    }

    public void setBuyerGetAlldata(String buyerGetAlldata) {
        this.buyerGetAlldata = buyerGetAlldata;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalExcVat() {
        return totalExcVat;
    }

    public void setTotalExcVat(double totalExcVat) {
        this.totalExcVat = totalExcVat;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
