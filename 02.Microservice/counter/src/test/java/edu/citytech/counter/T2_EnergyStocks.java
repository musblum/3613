package edu.citytech.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.citytech.counter.dto.EnergyStock;
import edu.citytech.counter.services.EnergyStockService;

public class T2_EnergyStocks {

    @Test
    void t1(){

        System.out.println(System.getenv("CST_3613_DATA"));
        EnergyStockService service = new EnergyStockService();
        int actual = service.size();
        int expected = 232;

        assertEquals(expected, actual);

    }

    @Test
    void t2(){

        EnergyStockService service = new EnergyStockService();
        List<EnergyStock> list = service.getDividendStocks();
        int actual = list.size();
        int expected = 150;

        assertEquals(expected, actual);

    }

    @Test
    void t3(){

        EnergyStockService service = new EnergyStockService();
        List<EnergyStock> list = service.getMarketCapInBillions();
        int actual = list.size();
        int expected = 150;

        assertEquals(expected, actual);

    }
}
