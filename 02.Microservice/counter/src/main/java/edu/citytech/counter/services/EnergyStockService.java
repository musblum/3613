package edu.citytech.counter.services;
import java.util.ArrayList;
import java.util.List;
import com.learning.java.data.repository.ExcelRepository;

import edu.citytech.counter.dto.EnergyStock;
import jakarta.inject.Singleton;

@Singleton
public class EnergyStockService {

    private static String DIR = System.getenv("CST_3613_DATA");
    private static List<EnergyStock> list = new ArrayList<>();
        
    static {
		String fileName = DIR + "/BestEnergyStocks2024-10-25.xlsx";		
		int sheetNumber = 0, skip = 1;	
		
		var repository = new ExcelRepository<EnergyStock>(fileName, sheetNumber, skip);				
		repository.findAll(EnergyStock.class, list::add);

        for (EnergyStock energyStock : list) {
            System.out.println(energyStock.toString());
        }
	
	}

    public int size() {
        
        return list.size();
    }

    public List<EnergyStock> getDividendStocks() {

        List<EnergyStock> divList = new ArrayList<>();
        
        for (EnergyStock energyStock : list) {
            
            if(energyStock.getDivYield() > 0){
                divList.add(energyStock);
            }
        }

        return divList;
    }

    public List<EnergyStock> getMarketCapInBillions() {

        List<EnergyStock> capList = new ArrayList<>();
        
        for (EnergyStock energyStock : list) {
            
            if(energyStock.getMarketCap() > 1_000_000_000){
                capList.add(energyStock);
            }
        }

        return capList;
        
    }

}
