package edu.citytech.counter.services;
import java.util.ArrayList;
import java.util.List;

import com.learning.java.data.repository.ExcelRepository;

import edu.citytech.counter.dto.Category;
import edu.citytech.counter.dto.Stock;
import jakarta.inject.Singleton;

@Singleton
public class StockService {

    private static String DIR = System.getenv("CST_3613_DATA");
    private static List<Stock> list = new ArrayList<>();
    private static List<Category> categories = new ArrayList<Category>();        

    static {

       categories.add(new Category(1, "Energy")); 
       categories.add(new Category(2, "REITS"));
       categories.add(new Category(4, "ConsumerStaples")); 
       categories.add(new Category(8, "Gaming")); 

		int sheetNumber = 0, skip = 1;	
		
        for (var category : categories) {
            
            String fullName = DIR + "/" + category.category() + ".xlsx";		
            var repository = new ExcelRepository<Stock>(fullName, sheetNumber, skip);				
            repository.findAll(Stock.class, list::add);
        }

        for (Stock energyStock : list) {
            System.out.println(energyStock.toString());
        }
	
	}

    public int size() {
        
        return list.size();
    }

    public List<Stock> getDividendStocks() {

        List<Stock> divList = new ArrayList<>();
        
        for (Stock energyStock : list) {
            
            if(energyStock.getDivYield() > 0){
                divList.add(energyStock);
            }
        }

        return divList;
    }

    public List<Stock> getAll() {
        return list;
    }

    public List<Stock> filter(int code) {

        List<Stock> filteredList = new ArrayList<>();

        for (Category category : categories) {
            boolean display = (category.code() & code) > 0;
            if(display){
                var newList = list.stream()
                                  .filter(e -> e.getCategory().equals(category.category()))
                                  .toList();
                filteredList.addAll(newList);
            }
        }
        return filteredList;

    }

    public List<Stock> getMarketCapInBillions() {

        List<Stock> capList = new ArrayList<>();
        
        for (Stock energyStock : list) {
            
            if(energyStock.getMarketCap() > 1_000_000_000){
                capList.add(energyStock);
            }
        }

        return capList;
        
    }

}
