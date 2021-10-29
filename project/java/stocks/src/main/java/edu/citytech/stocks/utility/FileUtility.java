package edu.citytech.stocks.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtility {
    public static String getFile(String FileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FileName));


            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null){
                sb.append(currentLine);
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return sb.toString();
    }
}
