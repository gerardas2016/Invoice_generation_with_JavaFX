package account.view;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.DataBaseImport;
import model.InvoiceData;
import model.beans.BuyerInfo;
import model.beans.Client;
import model.beans.Invoice;
import model.beans.Item;
import model.beans.Seller;
import model.beans.Total_Items;
import model.pdfGenerator.PdfFactory;

/**
 * FXML Controller class
 *
 * @author Gepardas
 */
public class GenerateInvoiceController implements Initializable {

    Invoice invoice;
    InvoiceData dataList;

//Buyer
    @FXML
    private TextField searchCode;

    @FXML
    private TextField fieldCode;
    @FXML
    private TextField fieldAdress;
    @FXML
    private TextField fieldCity;
    @FXML
    private TextField fieldCountry;

    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldPhone;
    @FXML
    private TextField fieldEmail;

    @FXML
    private Text lblInfo;

    // public static String getBueyr;
    //Table Product List 
    Item item = new Item();

    @FXML
    private TableView<Item> tblItem;
//    @FXML
//    private TableColumn<Item, Long> colID;
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

//Products text fields
    @FXML
    private TextField txtFieldItemName;
    @FXML
    private TextField txtFieldItemSize;
    @FXML
    private TextField txtFieldItemColor;
    @FXML
    private TextField txtFieldItemDestripcion;
    @FXML
    private TextField txtFieldItemPrice;
    @FXML
    private TextField txtFieldItemQuantity;

    //Table products selected
    @FXML
    private TableView<Total_Items> tblItemsForInvoice;
    @FXML
    private TableColumn<Total_Items, String> colInputName;
    @FXML
    private TableColumn<Total_Items, String> colInputSize;
    @FXML
    private TableColumn<Total_Items, String> colInputColor;
    @FXML
    private TableColumn<Total_Items, String> colInputDestripcion;
    @FXML
    private TableColumn<Total_Items, Double> colInputPrice;
    @FXML
    private TableColumn<Total_Items, Integer> colInputQuantity;
    @FXML
    private TableColumn<Total_Items, Double> colInputTotal;

    //   PdfFactory pdfFactory;
    InvoiceData invoiceData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblInfo.setText("");

    }

    @FXML
    private void onClicksearch(ActionEvent event) {
        clearSearcFields();
        lblInfo.setText("");
        // Collection<Client> clientList = new HashSet();

        DataBaseImport data = new DataBaseImport();
        ObservableList<Client> list = FXCollections.observableArrayList();
        list = data.GetClientData();

        //System.out.println("-> | Pries lista: " + clientList.size());
        for (Client client : list) {
            System.out.println("Clients code: " + client.getCode());
            if (client.getCode().toString().equals(searchCode.getText())) {

                fieldName.setText(client.getName());
                fieldCode.setText(client.getCode().toString());
                fieldAdress.setText(client.getAdress());
                fieldCity.setText(client.getCity());
                fieldCountry.setText(client.getCountry());
                fieldPhone.setText(client.getPhone());
                fieldEmail.setText(client.getEmail());

                break;

            } else {
                System.out.println("Not found");

            }

        }

        System.out.println(fieldName.getText());

        if (fieldCode.getText().equalsIgnoreCase(searchCode.getText()) && !searchCode.getText().trim().isEmpty()) {
            lblInfo.setText("Record Found");

            lblInfo.setFill(javafx.scene.paint.Color.GREEN);
            System.out.println("FOUND");

        } else {
            lblInfo.setText("Record NOT Found");
            //lblInfo.setStroke(javafx.scene.paint.Color.RED);
            lblInfo.setFill(javafx.scene.paint.Color.RED);

        }

    }

    private void clearSearcFields() {
        fieldName.clear();
        fieldCode.clear();
        fieldAdress.clear();
        fieldCity.clear();
        fieldCountry.clear();
        fieldPhone.clear();
        fieldEmail.clear();

    }

    private void updateTableView() {
//Insert into table values from Object Client which imports from Database import
        tblItem.getItems().clear();
        tblItem.getItems().addAll(new DataBaseImport().GetItemsData());

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
    private void onClickLoadProducts(ActionEvent event) {

        updateTableView();
    }

    @FXML
    private void onClickProduct(MouseEvent event) {
        
       
        
        txtFieldItemName.setText(tblItem.getSelectionModel().getSelectedItem().getName());
        txtFieldItemSize.setText(tblItem.getSelectionModel().getSelectedItem().getSize());
        txtFieldItemColor.setText(tblItem.getSelectionModel().getSelectedItem().getColor());
        txtFieldItemDestripcion.setText(tblItem.getSelectionModel().getSelectedItem().getDescription());
        txtFieldItemPrice.setText("" + tblItem.getSelectionModel().getSelectedItem().getPrice());
        
  
    }
    
    

    @FXML
    private void onClickAddProduct(ActionEvent event) {
 
        //tblItemsForInvoice.getItems().clear();
        //Item selectedItem=   tblItem.getSelectionModel().getSelectedItem();
        Total_Items totalItem = new Total_Items();
        totalItem.setName(txtFieldItemName.getText());
        totalItem.setSize(txtFieldItemSize.getText());
        totalItem.setColor(txtFieldItemColor.getText());
        totalItem.setPrice(Double.parseDouble(txtFieldItemPrice.getText()));
        totalItem.setQuantity(Integer.parseInt(txtFieldItemQuantity.getText()));
        totalItem.setDescription(txtFieldItemDestripcion.getText());

//Sets table fields
        tblItemsForInvoice.getItems().addAll(totalItem);
        //Sets to InvoiceData values 
        dataList= new InvoiceData();
       // dataList.addTotalItemObject(totalItem);
        dataList.setList(tblItemsForInvoice.getItems());
       // PdfFactory pdfFactory = new PdfFactory(dataList);
        
        //Gives values to Total_Items List in bean       
        totalItem.setItemsList(tblItemsForInvoice.getItems());
        System.out.println(totalItem.getItemsList().size());
//         System.out.println(totalItem.getItemsList().toString());

        colInputName.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getName());
        });
        colInputSize.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getSize());
        });
        colInputColor.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getColor());
        });
        colInputDestripcion.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, String> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getDescription());
        });
        colInputPrice.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, Double> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getPrice());
        });
        colInputQuantity.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, Integer> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getQuantity());
        });
        colInputTotal.setCellValueFactory((TableColumn.CellDataFeatures<Total_Items, Double> param) -> {
            return new ReadOnlyObjectWrapper<>(param.getValue().getTotal());
        });
        
        ClearProducttxtFields();

    }
    
        private void ClearProducttxtFields(){
    txtFieldItemName.clear();
    txtFieldItemSize.clear();
    txtFieldItemColor.clear();
    txtFieldItemDestripcion.clear();
    txtFieldItemPrice.clear();
    txtFieldItemQuantity.clear();
    
    }

    
    

    @FXML
    private void onClickGeneratePdfInvoice(ActionEvent event) throws IOException {

        // Sukurti  K objekta
       //InvoiceData invoiceData = setBuyerInfoToInvoice2();
       InvoiceData invoiceD = new InvoiceData();
      // dataList.set
       // uzpidome objekto K reiksmes
       invoiceD.setBuyerInfo2(fieldName.getText(),
                fieldCode.getText(),
                fieldAdress.getText(),
                fieldCity.getText(),
                fieldCountry.getText(),
                fieldPhone.getText());
       
        //System.out.println(invoiceD.toString());
        // perduoti ji i PDF klase
       // PdfFactory pdfFactory = new PdfFactory(invoiceD);
       
        //PdfFactory pdfFactory = new PdfFactory(invoiceData);
        PdfFactory pdfFactory = new PdfFactory();
        // pdf klaseje iskviesti metoda kuris suhgeneruotu pdf faila su jau paduotais duomenimis
        pdfFactory.setBuyerData(invoiceD);
        pdfFactory.setItemsData(dataList);
        pdfFactory.GenetarePdf();

        //System.out.println(fieldName.getText());
    }

    private InvoiceData setBuyerInfoToInvoice2() {
        invoiceData = new InvoiceData();

        // getBueyr= fieldName.getText()+ fieldCode.getText() + fieldAdress.getText()+fieldCity.getText()+fieldCountry.getText()+ fieldPhone.getText();
        invoiceData.setBuyerInfo2(fieldName.getText(),
                fieldCode.getText(),
                fieldAdress.getText(),
                fieldCity.getText(),
                fieldCountry.getText(),
                fieldPhone.getText());
        // System.out.println(invoiceData.toString());
        return invoiceData;
    }

   
    
    private void TotalPrice(){
    dataList.getItemsList();
    
    }
}
