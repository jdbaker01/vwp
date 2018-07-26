package provider.barchart;

import model.DailyPrice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DailyBar implements DailyPrice {

    public String symbol;

    public String timestamp;

    public String tradingDay;

    public BigDecimal open;

    public BigDecimal high;

    public BigDecimal low;

    public BigDecimal close;

    private LocalDate tradeDate;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public BigDecimal getOpen() {
        return this.open;
    }

    @Override
    public BigDecimal getHigh() {
        return this.high;
    }

    @Override
    public BigDecimal getLow() {
        return this.low;
    }

    @Override
    public BigDecimal getClose() {
        return this.close;
    }

    @Override
    public long getEpochtime() {
        return getTradeDate().toEpochDay();
    }

    @Override
    public LocalDate getTradeDate() {
        if (this.tradeDate == null) {
            this.tradeDate = LocalDate.parse(this.tradingDay, formatter);
        }
        return this.tradeDate;
    }
}
