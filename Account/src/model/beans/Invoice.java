
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    
    
}
