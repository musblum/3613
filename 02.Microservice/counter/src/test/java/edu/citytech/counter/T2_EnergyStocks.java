package edu.citytech.counter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.citytech.counter.dto.Stock;
import edu.citytech.counter.services.StockService;

public class T2_EnergyStocks {

    @Test
    void t1(){

        StockService service = new StockService();
        int actual = service.size();
        int expected = 482;

        assertEquals(expected, actual);

    }

    @Test
    void t2(){

        StockService service = new StockService();
        List<Stock> list = service.getDividendStocks();
        int actual = list.size();
        int expected = 299;

        assertEquals(expected, actual);

    }

    @Test
    void t3(){

        StockService service = new StockService();
        List<Stock> list = service.getMarketCapInBillions();
        int actual = list.size();
        int expected = 330;

        assertEquals(expected, actual);

    }

    @Test
    void t4(){

        StockService service = new StockService();
        int actual = service.filter(15).size();
        int expected = 482;

        assertEquals(expected, actual);

    }
}
