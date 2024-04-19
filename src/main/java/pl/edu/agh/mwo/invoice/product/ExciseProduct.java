package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class ExciseProduct extends Product {
    private BigDecimal excisePrice;

    public BigDecimal getExcisePrice() {
        return excisePrice;
    }

    public ExciseProduct(String name, BigDecimal price, BigDecimal excisePrice) {
        super(name, price, new BigDecimal("0.23"));
        this.excisePrice = excisePrice;
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return super.getPriceWithTax().add(excisePrice);
    }
}
