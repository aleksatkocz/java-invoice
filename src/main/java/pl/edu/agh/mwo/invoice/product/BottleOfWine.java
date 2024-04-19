package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.util.Date;

public class BottleOfWine extends ExciseProduct {
    public BottleOfWine(String name, BigDecimal price) {
        super(name, price, new BigDecimal("5.56"));
    }
}
