package edu.citytech.counter.controller;

import edu.citytech.counter.services.ABCService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/abc")
public class ABCController {

    @Inject ABCService service;
    
    @Get(value = "/letters/{mode}") 
    public Object getData(String mode) { 
        return service.getData(mode);
    }


}
