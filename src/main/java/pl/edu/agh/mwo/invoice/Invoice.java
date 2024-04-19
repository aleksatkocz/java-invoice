package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Integer number;
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal total;
    private Collection<Product> products;

    public Invoice() {
        this.subtotal = new BigDecimal(0);
        this.tax = new BigDecimal(0);
        this.total = new BigDecimal(0);
        this.products = new ArrayList<Product>();
        this.number = InvoiceUtil.getInvoiceCount();
        InvoiceUtil.incrementInvoiceCount();
    }

    public Integer countProducts() {
        return products.size();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        products.add(product);

        BigDecimal newSubtotal = getSubtotal().add(product.getPrice());
        setSubtotal(newSubtotal);

        BigDecimal newTotal = getTotal().add(product.getPriceWithTax());
        setTotal(newTotal);

        BigDecimal newTax = getTax().add(product.getTaxPercent().multiply(product.getPrice()));
        setTax(newTax);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < quantity; i++) {
            addProduct(product);
        }
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public Integer getNumber() {
        return number;
    }
}
