/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTests;

import account.Account;
import java.net.URISyntaxException;
import javafx.collections.ObservableList;
import model.DataBaseImport;
import model.beans.Client;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author gin
 */
public class jUnitDataBaseImport {

    public jUnitDataBaseImport() {

        // Enable basic log4 configuration | for debugging
        BasicConfigurator.configure();
        org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void dbTest() throws ClassNotFoundException, URISyntaxException {
        DataBaseImport dbImports = new DataBaseImport();
        dbImports.DriverImport();

//        
//           private static final String PATH_VIEW_VMI_VIEW = "views/vmi/VMIView.fxml";
//    
//    private final Image windowIconImage = new Image(getClass().getResource("resources/images/User.png").toString());
        //System.out.println("Account Path: " + Account.class.get);
       
        
             System.out.println("Account Path: " + Account.class.getPackage());
             System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
//                  System.out.println("Account Path: " + Account.class.getResource("resources/Invoice.accdb").getFile());
        // System.out.println("-- : " +Application.class.getResource("/"));
       // File file = new File(Account.class.getResource("resources/Invoice.accdb").toURI());
 


//
        ObservableList<Client> clients = dbImports.GetClientData();
        dbImports.GetItemsData();

        for (Client client : clients) {

            System.out.println("Client Code: " + client.getCode());

        }

    }
}
