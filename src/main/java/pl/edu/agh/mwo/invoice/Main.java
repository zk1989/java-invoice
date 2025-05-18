package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;

import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct;

public class Main {
    public static void main(String[] args) {

        Invoice invoice1 = new Invoice();
        
        invoice1.addProduct(new TaxFreeProduct("Bread", new BigDecimal("5.50")), 2);
        invoice1.addProduct(new DairyProduct("Milk", new BigDecimal("3.20")), 3);
        invoice1.addProduct(new OtherProduct("Wine", new BigDecimal("25.99")), 1);
        
        invoice1.printInvoice();
    
    }
}
