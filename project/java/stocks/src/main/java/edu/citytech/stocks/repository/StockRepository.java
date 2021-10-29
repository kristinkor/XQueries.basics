package edu.citytech.stocks.repository;
/*repository should focus on getting the data*/

import com.google.gson.Gson;
import edu.citytech.stocks.model.Stock;
import edu.citytech.stocks.model.StockByTicker;
import edu.citytech.stocks.utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StockRepository {
    private static Stock getStockInfo(File file){
        var directoryName = file.toString();

        Gson gson = new Gson();
        var json = FileUtility.getFile(directoryName);


        // 2. JSON string to Java object
        var stock = gson.fromJson(json, Stock.class);

        return stock;
    }

    private static StockByTicker getStockByTickerInfo(File file){
        var directoryName = file.toString();

        Gson gson = new Gson();
        var json = FileUtility.getFile(directoryName);


        // 2. JSON string to Java object

        return gson.fromJson(json, StockByTicker.class);
    }

    public static List<Stock> findAll() {
        var dirLocation = System.getenv().get("CST3650_STOCK_DATA");
        try {
            List<Stock> stockList = Files.list(Paths.get(dirLocation))
                    .map(Path::toFile)
                    .map(e -> getStockInfo(e))
                    .collect(Collectors.toList());
           return stockList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static List<StockByTicker> findAllNew() {
        var dirLocation = System.getenv().get("CST3650_STOCK_DATA_NEW");
        try {
            List<StockByTicker> stockList = Files.list(Paths.get(dirLocation))
                    .map(Path::toFile)
                    .map(e -> getStockByTickerInfo(e))
                    .collect(Collectors.toList());
            return stockList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}