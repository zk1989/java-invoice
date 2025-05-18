package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.mwo.invoice.product.DairyProduct;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.TaxFreeProduct;

public class InvoicePrintTest {
    private Invoice invoice;

    @Before
    public void setUp() {
        invoice = new Invoice();
    }

    @Test
    public void testPrintInvoiceWithProductsDoesNotThrowException() {
        try {
            invoice.addProduct(new TaxFreeProduct("Bulka", new BigDecimal("5.59")), 2);
            invoice.addProduct(new DairyProduct("Bagieta", new BigDecimal("9.99")), 3);
            invoice.printInvoice();
            Assert.assertEquals(new BigDecimal("20.67"), invoice.getSubtotal());
        } catch (Exception e) {
            Assert.fail("printInvoice() threw an exception for an invoice with products: " + e.getMessage());
        }
    }
}
