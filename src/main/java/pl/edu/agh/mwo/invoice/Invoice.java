package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private HashMap<Product, Integer> products = new HashMap<>();

    public Invoice() {};

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Wrong!");
        }
        products.put(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity == 0 || quantity < 0) {
            throw new IllegalArgumentException("Wrong!");
        }
        products.put(product, quantity);
    }

    public BigDecimal getSubtotal() {
        if (products == null) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal subtotal = BigDecimal.ZERO;
            for (HashMap.Entry<Product, Integer> entry : products.entrySet()) {
                BigDecimal total = entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue()));
                subtotal = subtotal.add(total);
            } return subtotal;
        }
    }

    public BigDecimal getTax() {
        if (products == null) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal taxsubtotal = BigDecimal.ZERO;
            for (HashMap.Entry<Product, Integer> entry : products.entrySet()) {
                BigDecimal total = entry.getKey().getPrice().multiply(entry.getKey().getTaxPercent());
                taxsubtotal = taxsubtotal.add(total);
            } return taxsubtotal;
        }
    }

    public BigDecimal getTotal() {
        if (products == null) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal total = BigDecimal.ZERO;
            for (HashMap.Entry<Product, Integer> entry : products.entrySet()) {
                BigDecimal subtotal = entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue()));
                BigDecimal tax = subtotal.multiply(entry.getKey().getTaxPercent());
                BigDecimal sum = subtotal.add(tax);
                total = total.add(sum);
            } return total;
        }
    }
}
