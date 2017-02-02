/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DataBaseImport;
import model.beans.Item;

/**
 * FXML Controller class
 *
 * @author Gepardas
 */
public class ProductsController implements Initializable {
    Item item = new Item();
    @FXML
    private TableView<Item> tblItem;
    @FXML
    private TableColumn<Item, Long> colID;
    @FXML
    private TableColumn<Item, String> colName;
    @FXML
    private TableColumn<Item, String> colSize;
    @FXML
    private TableColumn<Item, String> colColor;
    @FXML
    private TableColumn<Item, String> colDescription;
    @FXML
    private TableColumn<Item, Double> colPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       updateTableView();
    }    
    
    private void updateTableView( )  {
//Insert into table values from Object Client which imports from Database import
        tblItem.getItems().clear();
        tblItem.getItems().addAll(new DataBaseImport().GetItemsData());

          colID.setCellValueFactory((TableColumn.CellDataFeatures<Item, Long> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getID());
        });

        colName.setCellValueFactory((TableColumn.CellDataFeatures<Item, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getName());
        });
        
        colSize.setCellValueFactory((TableColumn.CellDataFeatures<Item, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getSize());
        });
        
        colColor.setCellValueFactory((TableColumn.CellDataFeatures<Item, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getColor());
        });
        colDescription.setCellValueFactory((TableColumn.CellDataFeatures<Item, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getDescription());
        });
        colPrice.setCellValueFactory((TableColumn.CellDataFeatures<Item, Double> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getPrice());
        });
       
        


    }
}
