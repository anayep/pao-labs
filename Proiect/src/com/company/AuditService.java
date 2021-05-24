package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AuditService {

    public void writeCSV(String action,String time){
        String path = "D:\\facultateee\\pao\\github\\pao-labs\\csvs\\audit.csv";
        File file = new File(path);

        boolean header = false;
        boolean result;
        try{
            result = file.createNewFile();
            if(result)      // test if successfully created a new file
            {
                System.out.println("file created "+file.getCanonicalPath()); //returns the path string
                header = true;
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileWriter csvWriter = new FileWriter(file,true);
            if(header){
                csvWriter.append("Nume_Actiune,Timestamp");
                csvWriter.append("\n");
            }
            csvWriter.append(action);
            csvWriter.append(",");
            csvWriter.append(time);
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
