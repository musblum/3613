package edu.citytech.counter.controller;

import java.util.Date;

import edu.citytech.counter.dto.Developer;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller()
public class DeveloperController {

    @Get() 
    public String developer() { 
        return "Abdallah, Salem " + new Date();
    }



    @Get(uri = "developer") 
    @Produces(MediaType.APPLICATION_JSON)
    public Object detailDeveloper() { 
        String name = "Abdallah, Salem";
        String[] skills = {"Java" , "Python", "C++", "HTML", "Javascript", "PHP", "SQL"};
        var developer = new Developer(name, skills, 3);
        return developer;
    }

}