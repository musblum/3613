package edu.citytech.counter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import edu.citytech.counter.services.EnergyStockService;

@Controller("/stocks")
public class EnergyStockController {

    @Inject
    EnergyStockService service;

    @Get(value = "/dividends")
    public Object getAll(){

        Map<String, Object> map = new HashMap<>();
        var data = service.getDividendStocks();
        map.put("data", data);
        map.put("size", data.size());

        System.out.println("Abdallah, Salem");

        return map;
    }
    

}
