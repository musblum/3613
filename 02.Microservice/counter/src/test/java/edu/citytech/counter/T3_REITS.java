package edu.citytech.counter;

import edu.citytech.counter.services.REITSService;
import edu.citytech.counter.services.StockService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T3_REITS {


    @Test
    void t1(){

        var service = new REITSService();
        var results = service.findAll();

        int actual = results.size();
        int expected = 177;

        results.forEach(System.out::println);

        assertEquals(expected, actual);

    }
}
