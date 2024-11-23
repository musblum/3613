package edu.citytech.counter.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import jakarta.inject.Singleton;

@Singleton
public class ABCService {

    Map<String, Supplier<List<String>>> map = new HashMap<>();

    public ABCService(){
        System.out.println("I am alive: " + new Date());
        map.put("V", this::getVowelsUpper);
        map.put("A", this::getABC);
        map.put("C", this::getConstonantUpper);
        map.put("v", this::getVowelsLower);
        map.put("a", this::getabc);
        map.put("c", this::getConstonantLower);
    }

    public Object getData(String key){
        List<String>data = map.get(key).get();
        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put("Size", data.size());
        mapResult.put("Data", data);
        mapResult.put("Developer", "Abdallah, Salem");

        return mapResult;
    }

    private static final String ABC = "abcdefghijklmnopqrstuvwxyz";

    private static final String[] alphabet = ABC.split("");
    private static final String[] _alphabet = ABC.toUpperCase().split("");

    public List<String> getabc(){
        return Arrays.asList(alphabet);
    }

    public List<String> getABC(){
        return Arrays.asList(_alphabet);
    }

    @SuppressWarnings("IndexOfReplaceableByContains")
    public boolean isVowel(String letter){
        return "AEIOUaeiou".indexOf(letter) >= 0;
    }

    public List<String> getVowelsUpper(){
        var letters = Arrays.asList(_alphabet);
        var vowels = new ArrayList<String>();
        for(String l : letters){
            if(isVowel(l))
                vowels.add(l);
        }

        return vowels;
    }

    public List<String> getVowelsLower(){
        var letters = Arrays.asList(alphabet);
        var vowels = new ArrayList<String>();
        for(String l : letters){
            if(isVowel(l))
                vowels.add(l);
        }

        return vowels;
    }

    public List<String> getConstonantUpper(){
        var letters = Arrays.asList(_alphabet);
        var vowels = new ArrayList<String>();
        for(String l : letters){
            if(!isVowel(l))
                vowels.add(l);
        }

        return vowels;
    }

    public List<String> getConstonantLower(){
        var letters = Arrays.asList(alphabet);
        var vowels = new ArrayList<String>();
        for(String l : letters){
            if(!isVowel(l))
                vowels.add(l);
        }

        return vowels;
    }
}
