package pl.edu.agh.mwo.invoice.product;

import pl.edu.agh.mwo.invoice.InvoiceUtil;

import java.math.BigDecimal;
import java.util.Date;

public class FuelCanister extends ExciseProduct {
    public FuelCanister(String name, BigDecimal price) {
        super(name, price, new BigDecimal("5.56"));
    }
}
