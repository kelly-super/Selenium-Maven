package org.example.dataprovider;

import org.example.utility.NewExcelLibrary;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DataProviders {
    NewExcelLibrary obj = new NewExcelLibrary();

    @Test
    public Object[][] registerInfo(){
        int rows = obj.getRowCount("registerInfo");
        int column = obj.getColumnCount("registerInfo");
        int actrow = rows-1;
        Object[][] data = new Object[actrow][1];
        for(int i =0; i< actrow;i++){
            Map<String, String> hashMap= new HashMap<>();
            for(int j =0; j<column; j++){
                hashMap.put(obj.getCellData("registerInfo",j,i),
                        obj.getCellData("registerInfo", j, i + 2));

            }
            data[i][0]=hashMap;
        }
        return data;
    }
}
