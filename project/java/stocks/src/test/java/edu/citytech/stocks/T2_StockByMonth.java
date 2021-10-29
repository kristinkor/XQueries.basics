package edu.citytech.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.model.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Search By Month")
public class T2_StockByMonth {
    String jsonStock = """
                {
                    "symbol": "BAC",
                    "dividends": {
                        "frequency": "quarterly",
                        "months": [
                            {
                                "9": 0.21
                            },
                            {
                                "6": 0.18
                            },
                            {
                                "3": 0.18
                            },
                            {
                                "12": 0.18
                            }
                        ],
                        "yield": 0.01849675592909907
                    },
                    "price": 40.27,
                    "marketCapInBillions": 338.868179288,
                    "companyName": "Bank Of America Corp.",
                    "momentumScore": 50.24752475247524,
                    "sector": "Financials",
                    "subSector": "Diversified Banks"
                }
                """;
    @Test
    @DisplayName("Search By Month Number look for 3-March")
    void t1_searchByMonthNumber() {

        Gson gson = new Gson();
        var stock = gson.fromJson(jsonStock, Stock.class);

        var months = stock.getDividends().getMonths();
        boolean actual = false;
        for (Map<Integer, Float> month : months) {
            for (Integer entry : month.keySet()) {
                if (entry.equals(3)) {
                    actual = true;
                    break;
                }
            }
        }

        assertEquals(true, actual);
    }

    @Test
    @DisplayName("Search By Month Number look for 3-March")
    void t2_searchByMonthNumber() {

        Gson gson = new Gson();
        var stock = gson.fromJson(jsonStock, Stock.class);
        var months = stock.getDividends().getMonths();

        boolean actual = Arrays.stream(months).anyMatch(map -> map.containsKey(3));


        assertEquals(true, actual);
    }
}
