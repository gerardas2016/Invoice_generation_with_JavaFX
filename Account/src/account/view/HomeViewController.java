/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;

import account.Account;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Gepardas
 */
public class HomeViewController implements Initializable {

    BorderPane mainLayout;
    @FXML
    private Button invoiceBtn;
    @FXML
    private Button customersBtn;
    @FXML
    private Button productBtn;
    @FXML
    private Button reportsBtn;
    @FXML
    private Button createInvoiceBtn;

    
    
    public void setVariables(BorderPane mainLayout) {
       this.mainLayout=mainLayout;
          
               
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickCostumersDB(ActionEvent event) throws IOException {

       
        
       FXMLLoader loader= new FXMLLoader();
       loader.setLocation(Account.class.getResource("view/CustomersView.fxml"));
  
       BorderPane mainItems=(BorderPane)loader.load();
       mainLayout.setCenter(mainItems);

 
    }

    @FXML
    private void onClickProducts(ActionEvent event) throws IOException {
       FXMLLoader loader= new FXMLLoader();
       loader.setLocation(Account.class.getResource("view/Products.fxml"));
  
       BorderPane mainItems=(BorderPane)loader.load();
       mainLayout.setCenter(mainItems);
        
        
        
    }

    @FXML
    private void onClickInvoices(ActionEvent event) throws IOException {
        
        FXMLLoader loader= new FXMLLoader();
       loader.setLocation(Account.class.getResource("view/Invoices.fxml"));
  
       BorderPane mainItems=(BorderPane)loader.load();
       mainLayout.setCenter(mainItems);
        
        
        
        
    }

    @FXML
    private void onClickCreateInvoice(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader();
       loader.setLocation(Account.class.getResource("view/GenerateInvoice.fxml"));
       
        BorderPane mainItems = (BorderPane) loader.load();  
              
              
      
       
        mainLayout.setCenter(mainItems);
    }
    
    
    
    
}
