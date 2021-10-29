package edu.citytech.stocks.services;

import edu.citytech.stocks.repository.StockRepository;


import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class CalculateMonthService {
    private static Map<String, Integer> map = new HashMap<>();

    static {
        System.out.println(new Date());
        map.put("Jan", 1);
        map.put("Feb", 2);
        map.put("Mar", 3);
        map.put("Apr", 4);
        map.put("May", 5);
        map.put("Jun", 6);
        map.put("Jul", 7);
        map.put("Aug", 8);
        map.put("Sep", 9);
        map.put("Oct", 10);
        map.put("Nov", 11);
        map.put("Dec", 12);
    }

    public static int getMonthCode(int[] months) {

        return Arrays.stream(months).filter(e -> e != 0)
                .map(month -> 1 << (month - 1)).sum();
    }

    public static int getMonthName(String monthName) {
        if (!map.containsKey(monthName))
            return -1;

        return map.get(monthName);
    }

}
