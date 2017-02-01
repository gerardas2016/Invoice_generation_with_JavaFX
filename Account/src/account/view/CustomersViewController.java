/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;


import model.beans.Client;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DataBaseImport;

/**
 * FXML Controller class
 *
 * @author Gepardas
 */
public class CustomersViewController implements Initializable {
    
    Client client = new Client();

    @FXML
    private TableView<Client> tblClient;
    @FXML
    private TableColumn<Client, Long> colID;
    @FXML
    private TableColumn<Client, String> colName;
    @FXML
    private TableColumn<Client, Long> colCode;
    @FXML
    private TableColumn<Client, String> colAdress;
    @FXML
    private TableColumn<Client, String> colCity;
    @FXML
    private TableColumn<Client, String> colCountry;
    @FXML
    private TableColumn<Client, String> colPhone;
    @FXML
    private TableColumn<Client, String> colEmail;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateTableView();
    }    
    
    
     private void updateTableView( ) {
//Insert into table values from Object Client which imports from Database import
        tblClient.getItems().clear();
        tblClient.getItems().addAll(new DataBaseImport().GetClientData());

         colID.setCellValueFactory((TableColumn.CellDataFeatures<Client, Long> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getID());
        });

        colName.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getName());
        });
        
        colCode.setCellValueFactory((TableColumn.CellDataFeatures<Client, Long> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getCode());
        });
        
        colAdress.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getAdress());
        });
        colCity.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getCity());
        });
        colCountry.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getCountry());
        });
        colPhone.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getPhone());
        });
        colEmail.setCellValueFactory((TableColumn.CellDataFeatures<Client, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getEmail());
        });
        
        
        

    }
}
