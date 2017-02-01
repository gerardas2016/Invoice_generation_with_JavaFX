/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import account.view.GenerateInvoiceController;
import java.io.IOException;
import model.InvoiceData;
import model.beans.Invoice;
import model.pdfGenerator.PdfFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gepardas
 */
public class MyTest {
    
    public MyTest() {
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
     public void hello() throws IOException {
     
         PdfFactory factory = new PdfFactory();
         factory.GenetarePdf();
 }
        @Test
     public void GeneratePdf() throws IOException {
     
         PdfFactory factory = new PdfFactory();
         factory.GenetarePdf();
     
     }
     
//     @Test
//     public void name() throws IOException {
//     
//         InvoiceData data= new InvoiceData();
//         System.out.println(data.getClient());
//     
//     }
     
      @Test
     public void TestInvoice() throws IOException {
     
         Invoice invoice=new Invoice();
          System.out.println(invoice.getBuyerGetAlldata());
     
     }
      @Test
     public void TestInvoice2() throws IOException {
     
         // System.out.println(GenerateInvoiceController.getBueyr);
     
     }
     
     
     
     
}
