package edu.citytech.stocks.controller;

import edu.citytech.stocks.model.Stock;

import edu.citytech.stocks.model.StockByTicker;
import edu.citytech.stocks.services.StockByTickerService;
import edu.citytech.stocks.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sp500")
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    StockByTickerService stockByTicker;

    @GetMapping("")
    List<Stock> sp500list(@RequestParam int size) {
        return stockService.getAllStocks(size);
    }

    @GetMapping("top-10-dividends")
    List<Stock> top10Dividends() {
        return stockService.getTop10Dividends();

    }
    @GetMapping("bst/investment/stock")
    List<StockByTicker> getStocksByTicker(@RequestParam(defaultValue = "AAL") String symbol){
        return stockByTicker.getStocksByTicker(symbol);
    }

    @GetMapping("whatif-monthly-dividends")
    List<Stock> whatIfMonthlyDividends(@RequestParam(required = false) String monthName, @RequestParam(required = false) Integer monthNumber, @RequestParam(required = false) Integer monthcode) {
        if (monthName != null) {
            return stockService.getStocksByMonthName(monthName);
        }
        if (monthNumber != null) {
            return stockService.getStocksByMonthNumber(monthNumber);
        }
        return stockService.getStocksByMonthCode(monthcode);
        //http://localhost:8080/sp500/whatif-monthly-dividends?monthcode=7

    }

}
