package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by jdbaker on 7/25/18.
 */

public interface DailyPrice {

    BigDecimal getOpen();

    BigDecimal getHigh();

    BigDecimal getLow();

    BigDecimal getClose();

    long getEpochtime();

    LocalDate getTradeDate();

}
