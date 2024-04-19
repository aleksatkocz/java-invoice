package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.Product;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;
import java.util.HashSet;

public class InvoicePrinter {

    public Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public String header() {
        return "Numer faktury: " + invoice.getNumber() + System.lineSeparator();
    }

    private String footer() {
        return "Liczba pozycji: " + invoice.countProducts();
    }

    public String print() {
        HashSet<String> printedProducts = new HashSet<>();

        String invoicePrint = header();
        Collection<Product> products = invoice.getProducts();

        for (Product product: products) {
            String name = product.getName();

            if (printedProducts.contains(name)) {
                continue;
            }
            long count = products.stream().filter(product1 ->
                    product1.getName().equals(name)).count();

            BigDecimal taxPrice = product.getPriceWithTax();
            BigDecimal totalPrice = product.getPriceWithTax().multiply(new BigDecimal(count));

            invoicePrint += "Produkt: " + name
                    + " Ilosc: " + count
                    + " Cena jdn.: " + taxPrice
                    + " PLN Cena calkowita: " + totalPrice + " PLN"
                    + System.lineSeparator();
            printedProducts.add(name);
        }
        invoicePrint += footer();
        return invoicePrint;
    }
}
