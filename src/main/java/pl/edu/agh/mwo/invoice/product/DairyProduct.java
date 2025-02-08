package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class DairyProduct extends Product {
    public DairyProduct(String name, BigDecimal price) {
        super(name, price, new BigDecimal("0.08"));
        if (name == null || price == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
    }
}
