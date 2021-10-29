package edu.citytech.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.model.StockByMonthCode;
import edu.citytech.stocks.services.CalculateMonthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3_StockByMonthCode {
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
    @DisplayName("Search By Month Code: look for 2340")
    void t3_searchByMonthNumber() {
        Gson gson = new Gson();
        var stock = gson.fromJson(jsonStock, StockByMonthCode.class);

        int months[] = new int[]{
                3, 6, 9, 12
        };
        int monthCode = CalculateMonthService.getMonthCode(months);
        var actual = monthCode;
        var expected = 2340;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Functional(2). Search By Month Code: look for 7")
    void t4_searchByMonthNumber() {
//        CalculateMonthService.getMonthCode(1, 2, 3, 4, 4);
        int months[] = new int[]{1, 2, 3};
        int monthCode = CalculateMonthService.getMonthCode(months);
        var actual = monthCode;
        var expected = 7;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Search By Month Code: look for 4095")
    void t5_searchByAll() {
        int months[] = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        };
        int monthCode = CalculateMonthService.getMonthCode(months);
        var actual = monthCode;
        var expected = 4095;

        assertEquals(expected, actual);
    }
}
