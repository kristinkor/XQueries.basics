package edu.citytech.stocks;

import com.google.gson.Gson;
import edu.citytech.stocks.model.Stock;
import edu.citytech.stocks.services.CalculateMonthService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Search By Month Name")
public class T4_StockByMonthName {

    @Test
    @DisplayName("Functional: Search By Month Name: Jan")
    void t1_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Jan");
        int expected = 1;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Functional: Search By Month Name: Feb")
    void t2_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Feb");
        int expected = 2;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Functional: Search By Month Name: Mar")
    void t3_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Mar");
        int expected = 3;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Functional: Search By Month Name: Apr")
    void t4_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Apr");
        int expected = 4;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Functional: Search By Month Name: May")
    void t5_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("May");
        int expected = 5;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Functional: Search By Month Name: Jun")
    void t6_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Jun");
        int expected = 6;


        assertEquals(expected, actual);
    }    @Test
    @DisplayName("Functional: Search By Month Name: Jul")
    void t7_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Jul");
        int expected = 7;


        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Functional: Search By Month Name: Aug")
    void t8_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Aug");
        int expected = 8;


        assertEquals(expected, actual);
    }    @Test
    @DisplayName("Functional: Search By Month Name: Sep")
    void t9_searchByMonthName() {
        int actual = CalculateMonthService.getMonthName("Sep");
        int expected = 9;


        assertEquals(expected, actual);
    }




}
