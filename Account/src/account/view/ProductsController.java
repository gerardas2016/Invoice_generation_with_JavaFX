
package account.view;

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
    
 // Add item txt fields
    @FXML
    private TextField txtFieldItemName;
    @FXML
    private TextField txtFieldItemSize;
    @FXML
    private TextField txtFieldItemColor;
    @FXML
    private TextField txtFieldItemDescription;
    @FXML
    private TextField txtFieldItemPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateTableView();
    }

    private void updateTableView() {
//Insert into table values from Object Client which imports from Database import
        tblItem.getItems().clear();
        tblItem.getItems().addAll(new DataBaseImport().GetItemsData());
        tblItem.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

    @FXML
    private void onClickAddItem(ActionEvent event) {
        DataBaseInjection dataBaseInjection= new DataBaseInjection(txtFieldItemName.getText(),
                txtFieldItemSize.getText(),
                txtFieldItemColor.getText(),
                txtFieldItemDescription.getText(),
                txtFieldItemPrice.getText());
        
        dataBaseInjection.addItem();
        updateTableView();
        clearItemTxtFields();
        
    }
    private void clearItemTxtFields(){
    txtFieldItemName.clear();
    txtFieldItemSize.clear();
    txtFieldItemColor.clear();
    txtFieldItemDescription.clear();
    txtFieldItemSize.clear();
    
    }
}
