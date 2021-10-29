package edu.citytech.stocks.services;

import edu.citytech.stocks.model.Stock;
import edu.citytech.stocks.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


@Service
public class StockService {
    private final List<Stock> stockList;

    public StockService() {
        stockList = StockRepository.findAll();
    }

    private final Predicate<Stock> gtDiv100B = stock -> stock.getMarketCapInBillions() > 100;
    private final Predicate<Stock> paysDiv = stock -> stock.getDividends().getYield() > 0;


    public List<Stock> getAllStocks(int size) {
        return stockList.stream()
                .limit(size).collect(Collectors.toList());
    }

    public List<Stock> getTop10Dividends() {
        var rule = gtDiv100B.and(paysDiv);
        return stockList.stream().filter(stock -> stock != null)
                .filter(rule)
                .sorted()
                .limit(10).collect(Collectors.toList());
    }

    public List<Stock> getStocksByMonthName(String monthName) {
        Predicate<Stock> byMonth = stock -> {
            var months = stock.getDividends().getMonths();
            var monthNumber = CalculateMonthService.getMonthName(monthName);
            return stream(months).anyMatch(map -> map.containsKey(monthNumber));
        };
        return stockList.stream().filter(stock -> stock != null)
                .filter(byMonth)
                .limit(10).collect(Collectors.toList());
    }

    public List<Stock> getStocksByMonthNumber(int monthNumber) {
        Predicate<Stock> byMonth = stock -> {
            var months = stock.getDividends().getMonths();
            return Arrays.stream(months).anyMatch(map -> map.containsKey(monthNumber));
        };

        return stockList.stream().filter(stock -> stock != null)
                .filter(byMonth)
                .limit(10).collect(Collectors.toList());
    }

    public List<Stock> getStocksByMonthCode(int monthCode) {
        Predicate<Stock> byMonth = stock -> {
            var months = stock.getDividends().getMonths();

            int[] monthNumbers = stream(months)
                    .map(month -> month.keySet().iterator().next())
                    .mapToInt(Integer::intValue)
                    .toArray();
            var currentMonthCode = CalculateMonthService.getMonthCode(monthNumbers);
            return monthCode == currentMonthCode;
        };

        return stockList.stream().filter(stock -> stock != null)
                .filter(byMonth)
                .limit(10).collect(Collectors.toList());
    }
}
