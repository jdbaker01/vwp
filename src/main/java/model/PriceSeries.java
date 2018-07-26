package model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by jdbaker on 7/25/18.
 */
public class PriceSeries {

    private final Map<LocalDate, DailyPrice> series;

    public PriceSeries() {
        this.series = new HashMap<>();
    }

    public PriceSeries add(@NonNull DailyPrice dailyPrice) {

        this.series.put(dailyPrice.getTradeDate(), dailyPrice);

        return this;
    }

    public Stream<DailyPrice> stream() {
        return series.values().stream();
    }

}
