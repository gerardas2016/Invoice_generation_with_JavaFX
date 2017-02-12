/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;

import model.beans.Client;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.DataBaseImport;
import model.DataBaseInjection;

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
    
    //Text Fields for new Client input
    @FXML
    private TextField txtFieldClientName;
    @FXML
    private TextField txtFieldClientCode;
    @FXML
    private TextField txtFieldClientAdress;
    @FXML
    private TextField txtFieldClientCountry;
    @FXML
    private TextField txtFieldClientCity;
    @FXML
    private TextField txtFieldClientEmail;
    @FXML
    private TextField txtFieldClientPhone;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateTableView();
       
    }

    private void updateTableView() {
//Insert into table values from Object Client which imports from Database import
        tblClient.getItems().clear();
        tblClient.getItems().addAll(new DataBaseImport().GetClientData());
        tblClient.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

    @FXML
    private void onClickAddToClientDatabase(ActionEvent event) {
        
        DataBaseInjection dataBaseInjection= new DataBaseInjection(txtFieldClientName.getText(),
                txtFieldClientCode.getText(),
                txtFieldClientAdress.getText(),
                txtFieldClientCity.getText(),
                txtFieldClientCountry.getText(),
                txtFieldClientPhone.getText(),
                txtFieldClientEmail.getText());
        
        dataBaseInjection.addClient();
       
         updateTableView();
         
         
         
         
         //clearFields();
         
         
    }
    private void clearFields(){
    txtFieldClientName.clear();
    txtFieldClientCode.clear();
    txtFieldClientAdress.clear();
    txtFieldClientCity.clear();
    txtFieldClientCountry.clear();
    txtFieldClientPhone.clear();
    txtFieldClientEmail.clear();
    
    
    
    
    
    
    }
    
}
