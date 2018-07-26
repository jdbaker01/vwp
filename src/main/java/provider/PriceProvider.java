package provider;

import model.PriceSeries;

public interface PriceProvider {

    public PriceSeries get(final String symbol);

}
