package provider.barchart;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import model.PriceSeries;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;
import provider.PriceProvider;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class BarChartPriceProvider {
    private final String apiKey = "69f13a34a5a66633fd8199bd27059226";

    private final AsyncHttpClient asyncHttpClient;

    public BarChartPriceProvider() {
        asyncHttpClient = asyncHttpClient();
    }

    public PriceSeries get(String symbol) {
        WebRequestBuilder builder = new WebRequestBuilder();
        final String query = builder.withApiKey(apiKey).withSymbol(symbol).withStartDate("201301010000").build();

        Future<Response> whenResponse = asyncHttpClient.prepareGet(query).execute();
        try {
            String results = whenResponse.get().getResponseBody();
            JsonElement element = new JsonParser().parse(results);
            JsonArray prices = element.getAsJsonObject().getAsJsonArray("results");
            PriceSeries priceSeries = new PriceSeries();
            Gson gson = new Gson();
            for (Iterator<JsonElement> it = prices.iterator(); it.hasNext(); ) {
                JsonElement price = it.next();
                DailyBar dailyBar = gson.fromJson(price, DailyBar.class);
                priceSeries.add(dailyBar);
            }

            return priceSeries;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected final class WebRequestBuilder {
        private String symbol;
        private String startDate;
        private String apiKey;

        public WebRequestBuilder() {

        }

        public WebRequestBuilder withSymbol(final String symbol) {
            this.symbol = symbol;
            return this;
        }

        public WebRequestBuilder withStartDate(final String startDate) {
            this.startDate = startDate;
            return this;
        }

        public WebRequestBuilder withApiKey(final String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public String build() {
            return String.format("https://marketdata.websol.barchart.com/getHistory.json?apikey=%s&symbol=%s&type=daily&startDate=%s&splits=0&dividends=0",
                    this.apiKey, this.symbol, this.startDate);
        }
    }

}
