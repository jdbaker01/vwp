package model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by jdbaker on 7/25/18.
 */
public class PriceSeriesTest {

    @Test
    public void given_valid_price_then_price_series_count_increased() {
        /*final PriceSeries priceSeries = new PriceSeries();
        final long initialCount = priceSeries.stream().count();
        final DailyPrice price = new DailyPrice
                                        .builder()
                                        .withOpen(BigDecimal.valueOf(100.00))
                                        .withHigh(BigDecimal.valueOf(100.00))
                                        .withLow(BigDecimal.valueOf(100.00))
                                        .withClose(BigDecimal.valueOf(100.00))
                                        .withTradeDate(LocalDate.now())
                                        .build();
        priceSeries.add(price);
        org.junit.Assert.assertEquals(initialCount+1, priceSeries.stream().count());*/
    }


    @Test(expected = NullPointerException.class)
    public void given_null_price_then_exception() {
        final PriceSeries priceSeries = new PriceSeries();
        priceSeries.add(null);
    }
}