package pl.edu.agh.mwo.invoice;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class InvoiceUtilTest {

    @Test
    public void testNumberIncrement(){
        int initialValue = InvoiceUtil.getInvoiceCount();
        InvoiceUtil.incrementInvoiceCount();
        int endValue = InvoiceUtil.getInvoiceCount();
        int delta = endValue - initialValue;

        Assert.assertThat(1, Matchers.comparesEqualTo(delta));
    }

}
