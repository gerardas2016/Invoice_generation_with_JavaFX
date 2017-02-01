
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.beans.Client;
import java.sql.Statement;
import model.beans.Item;
import model.beans.Seller;


/**
 *
 * @author Gepardas
 */
public class DataBaseImport {
    
    public void DriverImport() throws ClassNotFoundException{
        try {
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //JDBCdriverLoaded = true; // drivers needed to be loaded only once
            System.out.println("Ucanaccess Database drivers are loaded!");
        } catch (ClassNotFoundException ex) {
            System.err.println("(e)Class[AppDatabase] | Module[loadDrivers]: " + ex);
        }
    
    
    }
    
    public ObservableList<Client> GetClientData(){
    ObservableList<Client> clientList = FXCollections.observableArrayList();
    
//try {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            //JDBCdriverLoaded = true; // drivers needed to be loaded only once
//            System.out.println("Ucanaccess Database drivers are loaded!");
//        } catch (ClassNotFoundException ex) {
//            System.err.println("(e)Class[AppDatabase] | Module[loadDrivers]: " + ex);
//        }
        
        // connecting to the database
        try (Connection conn = DriverManager.getConnection(
                "jdbc:ucanaccess://C://Users//Gepardas//Documents//NetBeansProjects//Account//Invoice.accdb ;showschema=true",
                "Username",
                "Password")) {

            // SQL query to get all records from source DB
          
            String sqlString = "select * from Client";
           
            Statement s =  conn.createStatement();
            s.execute(sqlString);
            
          
            //SQL result set 
            ResultSet rs = s.getResultSet();

            //Looping via SQL record set
            while ((rs != null) && (rs.next())) {
            Client client = new Client();
            client.setID(rs.getLong("ID"));
            client.setName(rs.getString("Name"));
            client.setCode(rs.getLong("Code"));
            client.setAdress(rs.getString("Adress"));
            client.setCountry(rs.getString("Country"));
            client.setCity(rs.getString("City"));
            client.setPhone(rs.getString("Phone"));
            client.setEmail(rs.getString("Email"));
            
              
                clientList.add(client);
            }

        } catch (SQLException ex) {
            System.err.println("(e)Class[GBDAO] | Module[getAll]: " + ex);
        }

return clientList;

}
     public ObservableList<Item> GetItemsData() {
    ObservableList<Item> itemList = FXCollections.observableArrayList();
    
        // connecting to the database
        try (Connection conn = DriverManager.getConnection(
                "jdbc:ucanaccess://C://Users//Gepardas//Documents//NetBeansProjects//Account//Invoice.accdb ;showschema=true",
                "Username",
                "Password")) {

            // SQL query to get all records from source DB
          
            String sqlString = "select * from Item";
         
            Statement s =  conn.createStatement();
            s.execute(sqlString);
            
          
            //SQL result set 
            ResultSet rs = s.getResultSet();

            //Looping via SQL record set
            while ((rs != null) && (rs.next())) {
            Item item = new Item();
            item.setID(rs.getLong("ID"));
            item.setName(rs.getString("Name"));
            item.setSize(rs.getString("Size"));
            item.setColor(rs.getString("Color"));
            item.setDescription(rs.getString("Description"));
            item.setPrice(rs.getDouble("Price"));
            
                
              
                itemList.add(item);
            }

        } catch (SQLException ex) {
            System.err.println("(e)Class[GBDAO] | Module[getAll]: " + ex);
        }
       
       
        
        
return itemList;
    
    
}
     public ObservableList<Seller> GetSellerData(){
    ObservableList<Seller> sellerList = FXCollections.observableArrayList();
    

        try (Connection conn = DriverManager.getConnection(
                "jdbc:ucanaccess://C://Users//Gepardas//Documents//NetBeansProjects//Account//Invoice.accdb ;showschema=true",
                "Username",
                "Password")) {

            // SQL query to get all records from source DB
          
            String sqlString = "select * from Seller";
           
            Statement s =  conn.createStatement();
            s.execute(sqlString);
            
          
            //SQL result set 
            ResultSet rs = s.getResultSet();

            //Looping via SQL record set
            while ((rs != null) && (rs.next())) {
            Seller seller = new Seller();
            seller.setID(rs.getLong("ID"));
            seller.setName(rs.getString("Name"));
            seller.setCode(rs.getLong("Code"));
            seller.setAdress(rs.getString("Adress"));
            seller.setCountry(rs.getString("Country"));
            seller.setCity(rs.getString("City"));
            seller.setPhone(rs.getString("Phone"));
            seller.setEmail(rs.getString("Email"));
            
              
                sellerList.add(seller);
            }

        } catch (SQLException ex) {
            System.err.println("(e)Class[GBDAO] | Module[getAll]: " + ex);
        }
         
//         for (Seller seller : sellerList) {
//             System.out.println(seller.toString());
//             
//         }
return sellerList;

}
     
     
     
}
