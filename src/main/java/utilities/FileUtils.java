package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Nati on 2017-05-29.
 */
public class FileUtils {

    public static void saveGeneratedClassToFile(List<String> classBody, String filePath){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(pw != null){
            for(String line : classBody){
                pw.println(line);
            }
            pw.close();
            System.out.println("File saved successfully.");
        }else{
            System.out.println("Error has occurred while saving generated code to file.");
        }

    }

    public String getTestDirectoryPath(){
        return System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test";
    }

    public String getResourcesDirectoryPath(){
        return System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources";
    }
}
