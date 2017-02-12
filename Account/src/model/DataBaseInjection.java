
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gepardas
 */


public class DataBaseInjection {
    
    private static final String DB_PATH = System.getProperty("user.dir") + "/Invoice.accdb";
//New Customer injection
    private String name;
    private Long code;
    private String adress;
    private String city;
    private String country;
    private String phone;
    private String email;
    
//New Item injection
    private String itemName;
    private String itemSize;
    private String itemColor;
    private String itemDescription;
    private double itemPrice;

    public DataBaseInjection(String name, String code, String adress, String city, String country, String phone, String email) {
        this.name = name;
        this.code = Long.parseLong(code);
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public DataBaseInjection(String itemName, String itemSize, String itemColor, String itemDescription, String itemPrice) {
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.itemColor = itemColor;
        this.itemDescription = itemDescription;
        this.itemPrice = Double.parseDouble(itemPrice);
    }
    
    
    
     public void addClient( ){
     
  
 // connecting to the database
         try (Connection conn = DriverManager.getConnection(
                "jdbc:ucanaccess://" + DB_PATH + ";showschema=true",
                "Username",
                "Password")) {
            String sqlString = "INSERT INTO Client (Name, Code, Adress, Country, City, Phone, Email)" 
//            
                   + " VALUES (?,?,?,?,?,?,?)";
                

            PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
 
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, code);
            preparedStatement.setString(3, adress);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, country);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, email);
            
            
           // execute insert SQL stetement
            int affectedRows = preparedStatement.executeUpdate();   
            
            
     System.out.println(code);
    
    } catch (SQLException ex) {
            System.err.println("(e)Class[KKLOrdersDAO] | Module[insertOrder]: " + ex);
        }
           
 
    }
    
    public void addItem( ){
     
  
 // connecting to the database
         try (Connection conn = DriverManager.getConnection(
                "jdbc:ucanaccess://" + DB_PATH + ";showschema=true",
                "Username",
                "Password")) {
            
String sqlString = "INSERT INTO Item (Name, Size, Color, Description, Price)" 
                   + " VALUES (?,?,?,?,?)";
                 


            PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
 
            preparedStatement.setString(1, itemName);
            preparedStatement.setString(2, itemSize);
            preparedStatement.setString(3, itemColor);
            preparedStatement.setString(4, itemDescription);
            preparedStatement.setDouble(5, itemPrice);
           
            
     // execute insert SQL stetement
            int affectedRows = preparedStatement.executeUpdate();   
            
            
   
    
    } catch (SQLException ex) {
            System.err.println("(e)Class[KKLOrdersDAO] | Module[insertOrder]: " + ex);
        }
   
    }
}
