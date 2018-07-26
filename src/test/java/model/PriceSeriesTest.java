package model;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by jdbaker on 7/25/18.
 */
public class PriceSeriesTest {

    @Test
    public void given_valid_price_then_price_series_count_increased() {
        final PriceSeries priceSeries = new PriceSeries();
        final long initialCount = priceSeries.stream().count();
        final DailyPrice price = mock(DailyPrice.class);
        priceSeries.add(price);

        assertEquals(initialCount+1, priceSeries.stream().count());
    }

    @Test(expected = NullPointerException.class)
    public void given_null_price_then_exception() {
        final PriceSeries priceSeries = new PriceSeries();
        priceSeries.add(null);
    }
}