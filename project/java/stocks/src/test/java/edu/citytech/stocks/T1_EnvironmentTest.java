package edu.citytech.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.model.Stock;

import edu.citytech.stocks.repository.StockRepository;
import edu.citytech.stocks.utility.FileUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_EnvironmentTest {
    @Test
    void t1_environment() {
        Map<String, String> env = System.getenv();
        var actual = env.containsKey("CST3650_STOCK_DATA");
        var expected = true;


        assertEquals(true, actual);
    }

    @Test
    @DisplayName("Apple Stock information")
    void t2_environment() {

        var directoryName = System.getenv().get("CST3650_STOCK_DATA");
        System.out.println(directoryName);

        var actual = FileUtility.getFile(directoryName + "/AAPL.json")
                .contains("Apple Inc");
        var expected = true;

        assertEquals(true, actual);
    }

    @Test
    @DisplayName("JSON to POJO")
    void t3_environment() {

        var directoryName = System.getenv().get("CST3650_STOCK_DATA");
        var json = FileUtility.getFile(directoryName + "/AAPL.json");
        System.out.println(directoryName);

        var actual = json.contains("Apple Inc");
        boolean expected = true;

        Gson gson = new Gson();

        // 2. JSON string to Java object
        var stock = gson.fromJson(json, Stock.class);
        System.out.println(stock);


        assertEquals(true, actual);
    }

    @Test
    @DisplayName("Get all stocks")
    void t4_environment() {

        StockRepository.findAll()
                .forEach(System.out::println);

        // assertEquals(true, actual);
    }
}
