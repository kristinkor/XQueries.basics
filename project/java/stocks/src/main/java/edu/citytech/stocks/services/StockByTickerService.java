package edu.citytech.stocks.services;

import com.jbbwebsolutions.bst.BSTFacade;
import edu.citytech.datastructure.sid23953296.bst.BinarySearchTree;
import edu.citytech.stocks.model.Stock;
import edu.citytech.stocks.model.StockByTicker;
import edu.citytech.stocks.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StockByTickerService {
    private final List<StockByTicker> stockList;


    public StockByTickerService() {
        stockList = StockRepository.findAllNew();
    }

    public List<StockByTicker> getStocksByTicker(String ticker) {
        Predicate<StockByTicker> sbt = stock -> stock.getTicker().equals(ticker);

        return stockList.stream()
                .filter(sbt)
                .sorted()
                .limit(10).collect(Collectors.toList());
    }

    private int getNodeNum (String ticker){
        BSTFacade<Integer> bst = new BinarySearchTree<Integer>(new CustomSearchEngine<Integer>());

        return 0;
    }



}
