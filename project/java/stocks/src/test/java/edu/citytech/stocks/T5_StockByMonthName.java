package edu.citytech.stocks;

import edu.citytech.stocks.services.CalculateMonthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Search By All Month Names")
public class T5_StockByMonthName {

    @ParameterizedTest
    @CsvSource({
            "Jan,1",
            "Feb,2",
            "Mar,3",
            "Apr,4",
            "May,5",
            "Jun,6",
            "Jul,7",
            "Aug,8",
            "Sep,9",
            "Oct,10",
            "Nov,11",
            "Dec,12",
            "nnnnn,-1"
    })
    void testWithCSVSource(String monthName, int monthNumber) {

        int actual = CalculateMonthService.getMonthName(monthName);
        int expected = monthNumber;
        assertEquals(expected, actual);

    }

}
