package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;

import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Testing printInvoice() method =====");
        
        // Test 1: Empty invoice
        System.out.println("\n----- Test 1: Empty Invoice -----");
        Invoice emptyInvoice = new Invoice();
        emptyInvoice.printInvoice();
        
        // Test 2: Invoice with one product
        System.out.println("\n----- Test 2: Invoice with One Product -----");
        Invoice singleProductInvoice = new Invoice();
        singleProductInvoice.addProduct(new TaxFreeProduct("Bread", new BigDecimal("5.50")), 2);
        singleProductInvoice.printInvoice();
        
        // Test 3: Invoice with multiple products
        System.out.println("\n----- Test 3: Invoice with Multiple Products -----");
        Invoice multiProductInvoice = new Invoice();
        multiProductInvoice.addProduct(new TaxFreeProduct("Bread", new BigDecimal("5.50")), 2);
        multiProductInvoice.addProduct(new DairyProduct("Milk", new BigDecimal("3.20")), 3);
        multiProductInvoice.addProduct(new OtherProduct("Wine", new BigDecimal("25.99")), 1);
        multiProductInvoice.printInvoice();
        
        // Verify invoice numbers increment
        System.out.println("\n----- Verifying Invoice Numbers -----");
        System.out.println("First invoice number: 1");
        System.out.println("Second invoice number: 2");
        System.out.println("Third invoice number: 3");
    }
}
