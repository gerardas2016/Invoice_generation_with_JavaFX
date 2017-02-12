package account.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.DataBaseImport;
import model.InvoiceData;
import model.beans.Client;
import model.beans.Invoice;
import model.beans.Item;
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
    @FXML
    private ComboBox<Client> cbCustomers;

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

        cbCustomers.setItems(list);
        //cbCustomers.setButtonCell(cellFactory.call(null));
        
        cbCustomers.setCellFactory(new Callback<ListView<Client>, ListCell<Client>>() {
            @Override
            public ListCell<Client> call(ListView<Client> param) {
                return new ListCell<Client>() {
                     private final Rectangle rectangle;
                    private final Label lblFaultDescription;
                    private final Label lblFaultsFound;
                    private final Label lblFaultType;
                    private final Separator separator;

                    private HBox box;

                    private GridPane gridPane;

                    {

                        ColumnConstraints column1 = new ColumnConstraints();
                         column1.setMinWidth(20);
                       
                        ColumnConstraints column2 = new ColumnConstraints();
                         column2.hgrowProperty().set(Priority.ALWAYS);
                        separator = new Separator();
                        separator.setOrientation(Orientation.VERTICAL);

                        //  setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangle = new Rectangle(10, 10);
                        lblFaultDescription = new Label();
                        lblFaultType = new Label();
                        lblFaultsFound = new Label();
                        lblFaultType.setPadding(new Insets(0, 0, 0, 5));

                        lblFaultType.getStyleClass().add("label-black");
                        lblFaultDescription.getStyleClass().add("label-black");
                        box = new HBox(lblFaultType);

                        box.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

                        gridPane = new GridPane();
                        gridPane.setStyle(null);
                        // gridPane.setMaxWidth(400);
                        gridPane.getColumnConstraints().addAll(column1, column2);

                        // gridPane.setGridLinesVisible(true);
                        GridPane.setConstraints(lblFaultDescription, 0, 0);
                        GridPane.setHalignment(lblFaultDescription, HPos.LEFT);
                        GridPane.setConstraints(lblFaultsFound, 0, 0);
                        GridPane.setHalignment(lblFaultsFound, HPos.RIGHT);

                        GridPane.setConstraints(separator, 1, 0);
                        GridPane.setHalignment(separator, HPos.LEFT);

                        GridPane.setConstraints(box, 1, 0);
                        GridPane.setHalignment(box, HPos.RIGHT);
                        gridPane.getChildren().addAll(lblFaultDescription, box, separator, lblFaultsFound);

                    }

                    @Override
                    protected void updateItem(Client item, boolean empty) {
                        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.

                        if (item == null || empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                           
                            lblFaultDescription.setText(item.getCode() +"");
                            lblFaultType.setText( item.getName());

                            setGraphic(gridPane);
                        }
                    }

                };

            }
        });
        
        
            cbCustomers.setConverter(new StringConverter<Client>() {

            @Override
            public String toString(Client object) {
                if (object != null) {
                    return object.getName();

                } else {
                    return null;
                }

            }

            @Override
            public Client fromString(String string) {
                return null;
            }
        });
        
            cbCustomers.getSelectionModel().selectFirst(); //select the first element

        for (Client client : list) {
           
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

       

        if (fieldCode.getText().equalsIgnoreCase(searchCode.getText()) && !searchCode.getText().trim().isEmpty()) {
            lblInfo.setText("Record Found");

            lblInfo.setFill(javafx.scene.paint.Color.GREEN);
           

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
        tblItem.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

        if (tblItem.getSelectionModel().getSelectedItem() != null) {

            txtFieldItemName.setText(tblItem.getSelectionModel().getSelectedItem().getName());
            txtFieldItemSize.setText(tblItem.getSelectionModel().getSelectedItem().getSize());
            txtFieldItemColor.setText(tblItem.getSelectionModel().getSelectedItem().getColor());
            txtFieldItemDestripcion.setText(tblItem.getSelectionModel().getSelectedItem().getDescription());
            txtFieldItemPrice.setText("" + tblItem.getSelectionModel().getSelectedItem().getPrice());
        }
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
        tblItemsForInvoice.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Sets to InvoiceData values 
        dataList = new InvoiceData();
        // dataList.addTotalItemObject(totalItem);
        dataList.setList(tblItemsForInvoice.getItems());
        // PdfFactory pdfFactory = new PdfFactory(dataList);

        //Gives values to Total_Items List in bean       
        totalItem.setItemsList(tblItemsForInvoice.getItems());
       

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

    private void ClearProducttxtFields() {
        txtFieldItemName.clear();
        txtFieldItemSize.clear();
        txtFieldItemColor.clear();
        txtFieldItemDestripcion.clear();
        txtFieldItemPrice.clear();
        txtFieldItemQuantity.setText("1");
        
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

        
        PdfFactory pdfFactory = new PdfFactory();
        // pdf klaseje iskviesti metoda kuris suhgeneruotu pdf faila su jau paduotais duomenimis
        pdfFactory.setBuyerData(invoiceD);
        pdfFactory.setItemsData(dataList);
        pdfFactory.GenetarePdf();

        
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
      
        return invoiceData;
    }

    private void TotalPrice() {
        dataList.getItemsList();

    }

    @FXML
    private void onClickDeleteFromShoppingList(ActionEvent event) {
        ObservableList<Total_Items> productSelected, allProducts;

        allProducts = tblItemsForInvoice.getItems();

        productSelected = tblItemsForInvoice.getSelectionModel().getSelectedItems();



        productSelected.forEach(allProducts::remove);

    }
        
        
        
    }

