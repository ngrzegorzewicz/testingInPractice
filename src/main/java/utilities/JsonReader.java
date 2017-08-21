package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nati on 2017-05-24.
 */
public class JsonReader {

    public static List<PageElement> getPageElementsFromJsonFile(String path){

        ObjectMapper mapper = new ObjectMapper();
        List<PageElement> pageElements = null;
        try {
            pageElements = mapper.readValue(new File(path),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, PageElement.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pageElements;
    }
}
