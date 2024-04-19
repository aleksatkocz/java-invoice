package pl.edu.agh.mwo.invoice;

import java.util.Date;

public class InvoiceUtil {
    private static Integer invoiceCount = 1;

    public static Integer getInvoiceCount() {
        return invoiceCount;
    }

    public static void incrementInvoiceCount() {
        invoiceCount++;
    }
}
