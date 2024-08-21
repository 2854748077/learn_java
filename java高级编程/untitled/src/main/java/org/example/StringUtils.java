package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StringUtils {

    public static String capitalize(String s)throws IOException {
        try(FileWriter a=new FileWriter("src/test/resources/test-capitalize.csv");){
            Map<String,String> strs=Map.of(
                    "abc", "Abc",
                    "APPLE", "Apple",
                    "gooD", "Good");
            for (Map.Entry<String,String> b:strs.entrySet()){
                a.write(b.getKey()+","+b.getValue()+"\n");
            }
        }
        if (s.isEmpty()) {
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

}
