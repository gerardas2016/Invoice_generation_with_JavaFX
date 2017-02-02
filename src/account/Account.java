package account;

import account.view.HomeViewController;
//import account.view.LeftMenuController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DataBaseImport;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Gepardas
 */
public class Account extends Application {

    private Stage stage;
    private BorderPane mainLayout;

    @Override
    public void start(Stage stage) throws IOException {
// Enable basic log4 configuration | for debugging
        BasicConfigurator.configure();
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);

        this.stage = stage;
        this.stage.setTitle("Account App");
        showMainConsoleLayout();
        showGenerateInvoice();

        //Loads database on start
        try {
            DataBaseDownload();
            // showMainItems();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showMainConsoleLayout() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Account.class.getResource("view/HomeView.fxml"));

        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);

        HomeViewController controller = loader.getController();
        controller.setVariables(mainLayout);

        stage.setScene(scene);
        stage.show();
    }

//    private void showMainItems() throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Account.class.getResource("view/HomeView.fxml"));
//
//        
//       BorderPane mainItems = (BorderPane) loader.load();  
//              
//              //give to controler variambles 'main layout'
//       HomeViewController controller = loader.getController();
//       controller.setVariables(mainLayout);
//       
//        mainLayout.setTop(mainItems);
//        
//          FXMLLoader loader1 = new FXMLLoader();
//        loader.setLocation(Account.class.getResource("view/GenerateInvoice.fxml"));
//
//        
//       BorderPane mainItems1 = (BorderPane) loader.load();  
//              
//              //give to controler variambles 'main layout'
////       HomeViewController controller = loader.getController();
////       controller.setVariables(mainLayout);
//       
//        mainLayout.setCenter(mainItems1);
//
//    }
//    
    private void showGenerateInvoice() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Account.class.getResource("view/GenerateInvoice.fxml"));

        BorderPane mainItems = (BorderPane) loader.load();

        //give to controler variambles 'main layout'
//       HomeViewController controller = loader.getController();
//       controller.setVariables(mainLayout);
        mainLayout.setCenter(mainItems);

    }

    public void DataBaseDownload() throws ClassNotFoundException {
        DataBaseImport download = new DataBaseImport();
        download.DriverImport();
        download.GetClientData();
        download.GetItemsData();
        download.GetSellerData();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
