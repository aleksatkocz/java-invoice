package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private String name;

    private BigDecimal price;

    private BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax)
            throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (price == null || price.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return price.multiply(taxPercent).add(price);
    }
}
