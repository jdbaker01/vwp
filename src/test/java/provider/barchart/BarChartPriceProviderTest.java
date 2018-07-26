package provider.barchart;

import model.PriceSeries;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class BarChartPriceProviderTest {

    @Test
    public void given_valid_symbol_then_return_price_series() {
        BarChartPriceProvider priceProvider = new BarChartPriceProvider();
        PriceSeries priceSeries = priceProvider.get("SPY");

        assertTrue(priceSeries.stream().count() > 0);

    }

}