import generators.PageActionsClassGenerator;
import generators.PageElementClassGenerator;
import templates.ClickOnElementMethodTemplate;
import utilities.FileUtils;
import utilities.JsonReader;
import utilities.PageElement;
import utilities.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nati on 2017-05-16.
 */
public class Main {

    public static void main(String[] args){

        List<String> fileNames = getAllFilesNames();

        for(String file : fileNames){

            String filePath = new FileUtils().getResourcesDirectoryPath()
                    + File.separator + "pageStructureFiles" + File.separator + file;
            String pageName = file.substring(0, file.indexOf("."));

            List<PageElement> pageElements = JsonReader.getPageElementsFromJsonFile(filePath);

            generatePageElementClass(pageElements, pageName);
            generatePageActionsClass(pageElements, pageName);

        }

    }

    private static void generatePageActionsClass(List<PageElement> pageElements, String pageName){
        PageActionsClassGenerator actionsClassGenerator = new PageActionsClassGenerator(pageElements, pageName);
        actionsClassGenerator.generateMethods();
        actionsClassGenerator.generateImports();
        actionsClassGenerator.generateClassName();
        actionsClassGenerator.generateField();
        actionsClassGenerator.generateClassBody();
        actionsClassGenerator.saveClassToFile();
    }

    private static void generatePageElementClass(List<PageElement> pageElements, String pageName) {
        PageElementClassGenerator elementsClassGenerator = new PageElementClassGenerator(pageElements, pageName);
        elementsClassGenerator.generateFields();
        elementsClassGenerator.generateClassName();
        elementsClassGenerator.generateImports();
        elementsClassGenerator.generateClassBody();
        elementsClassGenerator.saveClassToFile();;
    }

    private static List<String> getAllFilesNames(){

        List<String> results = new ArrayList<String>();

        File[] files = new File(new FileUtils().getResourcesDirectoryPath()
                + File.separator + "pageStructureFiles").listFiles();

        if(files != null){
            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                }
            }

        }

        return results;
    }



}
