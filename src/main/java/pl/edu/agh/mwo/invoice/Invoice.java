package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private HashMap<Product, Integer> products = new HashMap<>();

    public Invoice() {};

    public void addProduct(Product product) {
        products.put(product, 0);
    }

    public void addProduct(Product product, Integer quantity) {
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
        return null;
    }

    public BigDecimal getTotal() {
        return null;
    }
}
