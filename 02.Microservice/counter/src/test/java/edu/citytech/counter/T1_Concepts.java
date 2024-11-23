package edu.citytech.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class T1_Concepts {

    public int booboo(){
        return 4 * 3;
    }

    public int itDoesNotMatter(){
        return 4 * 5;
    }
    
    public String _2Example(){
        return 20 * 4 * 5 + "";
    }

    @Test
    public void t1(){
        
        Supplier<Integer> s1 = this::booboo;
        Supplier<Integer> s2 = this::itDoesNotMatter;
        Supplier<String> a2 = this::_2Example;

        int x = s2.get();
        int y = s1.get();
        String z = a2.get();


        System.out.println("s2 = this::itDoesNotMatter: " + x);
        System.out.println("s1 = this::booboo.........: " + y);
        System.out.println("a2 = this::_2Example......: " + z);

        
    }

    @Test
    public void t2(){
        
        Supplier<Integer> s1 = this::booboo;
        Supplier<Integer> s2 = this::itDoesNotMatter;

        Map<Integer, Supplier<Integer>> map = new HashMap<>();
        map.put(1, s1);
        map.put(2, s2);

        Supplier<Integer> o = map.get(1);
        System.out.println(o.get()); 
        
        o = map.get(1);
        System.out.println(o.get()); 
        
    }

}
