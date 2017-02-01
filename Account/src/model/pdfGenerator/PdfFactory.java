package model.pdfGenerator;

/**
 *
 * @author Gepardas
 */
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DataBaseImport;
import model.InvoiceData;
import model.beans.Invoice;
import model.beans.Seller;
import model.beans.Total_Items;

public class PdfFactory {

    String invoice = "INVOICE";
    String knock = "COMPANY NAME";
    String knock2 = "SHORT DESCRIPTION";
    String invoiceDate = "Invoice Date: ";
    String invoiceNumber = "Invoice number: ";
    String sellerInfo = "Seler: ";
    String buyerInfo = "Buyer: ";
    float selOrderSpaceWidth = 20;
    float invoiceContactSpaceWidth = 15;

    InvoiceData buyerData;
    InvoiceData itemsData;

    public void setBuyerData(InvoiceData data) {
        this.buyerData = data;
    }
    
    public void setItemsData(InvoiceData data) {
        this.itemsData = data;
    }
    

    //destination Dest to temp file
    public static final String DEST = System.getProperty("java.io.tmpdir") + "invoicetest.pdf";
    // "C:/Users/Gepardas/Desktop/pdfExamples/Invoice.pdf";

    public PdfFactory() {
    }

    
    
//    public PdfFactory(InvoiceData data2) {
//        this.data = data2;
//       
//        //ObservableList<Total_Items> listOfData = data.getItemsList();
//    }

    public void GenetarePdf() throws IOException {
        // System.out.println(DEST);
        File file2 = new File(DEST);
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PageSize ps = PageSize.A4;
        PdfPage page = pdf.addNewPage(ps);

        document.add(createHeader());
        document.add(createBody());
        document.add(createBuyerSeller());
        document.add(createTableItemsList());

        document.close();

        //Opens file after executing
        Runtime.getRuntime().exec(new String[]{"rundll32", "url.dll,FileProtocolHandler", file2.getAbsolutePath()});

    }

    public Cell createHeader() throws IOException {

//        ArrayList <Items> itemsList = items.getArrayList();
//Invoice Text
        Cell cellInvoice = new Cell().setBorder(Border.NO_BORDER);
        cellInvoice.setWidthPercent(100);
        cellInvoice.setTextAlignment(TextAlignment.RIGHT);
        cellInvoice.setFontSize(20);
        cellInvoice.add(invoice);

        return cellInvoice;
    }

    public Table createBody() throws IOException {
        //Body (Knock Knock, invoice number and date

        PdfFont tableFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table table = new Table(new float[]{10, 5, 5});// 
        table.setWidthPercent(100);

        //First row = Knock knoc, date
        table.addCell(new Cell().add(knock)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.CENTER)
                .setFontSize(20)
                .setFontColor(Color.BLACK));
        table.addCell(new Cell().add(invoiceDate).setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.BOTTOM));
        table.addCell(new Cell().add("Dont forget input date").setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.LEFT).setVerticalAlignment(VerticalAlignment.BOTTOM));

//Second row Hand made+ invoice number
        table.addCell(new Cell().add(knock2)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.CENTER)
                .setFontSize(8)
                .setFontColor(Color.LIGHT_GRAY));
        table.addCell(new Cell().add(invoiceNumber).setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.TOP));
        table.addCell(new Cell().add("Dont forget to import invoice DB").setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.LEFT));

        //Space width invoive nr ard seller- buer contact
        table.addCell(new Cell().add("")
                .setBorder(Border.NO_BORDER).
                setHeight(invoiceContactSpaceWidth));

        return table;
    }

    public Table createBuyerSeller() throws IOException {

        PdfFont tableSel = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        Table tableSeller = new Table(new float[]{2, 5, 2, 5});// 
        tableSeller.setWidthPercent(100);

        //Seller
        tableSeller.addCell(new Cell().add(sellerInfo)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8));
//        tableSeller.addCell(new Cell().add(data.getBuyerInfo2())
//                .setBorder(Border.NO_BORDER).
//                setFontSize(10));

        //Buyer
        tableSeller.addCell(new Cell().add(buyerInfo)
                .setBorder(Border.NO_BORDER).
                setTextAlignment(TextAlignment.RIGHT)
                .setFontSize(8));
        tableSeller.addCell(new Cell().add(buyerData.getBuyerInfo2())
                .setBorder(Border.NO_BORDER).
                setFontSize(10));
        // Space width
        tableSeller.addCell(new Cell().add("")
                .setBorder(Border.NO_BORDER).
                setHeight(selOrderSpaceWidth));

        return tableSeller;

    }
    
    
    public Table createTableItemsList() throws IOException{
        
    PdfFont tableOrderFont = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
    Table tableOrder = new Table( new float[]{1,2, 10, 6, 3});// 
    tableOrder.setWidthPercent(100);
    
    

       
    tableOrder.addHeaderCell(new Cell().add("ID").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Qty").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Description").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Unit Price (GBP)").setBackgroundColor(Color.LIGHT_GRAY));
    tableOrder.addHeaderCell(new Cell().add("Total Price").setBackgroundColor(Color.LIGHT_GRAY));
    
      ObservableList<Total_Items> itemList= itemsData.getItemsList();
    int i=1;
        for (Total_Items x : itemList) {
            
    tableOrder.addCell(new Cell().add(i+" ").setBackgroundColor(Color.WHITE));
    tableOrder.addCell(new Cell().add(x.getQuantity()+" "));
    tableOrder.addCell(new Cell().add(x.getName()+" "+" "+x.getSize()+" "+x.getColor()+" "+x.getDescription()));
    tableOrder.addCell(new Cell().add(x.getPrice()+""));
    tableOrder.addCell(new Cell().add(x.getTotal()+""));
            
            i++;
            
        }
     

    
    return tableOrder;
    }
    
    

}
