package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Nati on 2017-05-24.
 */
public class StringUtils {

    public static String capitalizeFirstLetter(String text){
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }


}
