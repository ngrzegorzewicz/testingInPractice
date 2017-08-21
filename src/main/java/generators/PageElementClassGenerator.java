package generators;

import templates.FindByElementFieldTemplate;
import utilities.FileUtils;
import utilities.PageElement;
import utilities.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nati on 2017-05-18.
 */

public class PageElementClassGenerator {

    private List<PageElement> pageElements;
    private List<String> fields = new ArrayList<String>();
    private String pageName;
    private String className;
    private String packageName = "package pageObjects.pageElements;";
    private List<String> imports = new ArrayList<String>();
    private List<String> classBody = new ArrayList<String>();

    public PageElementClassGenerator(List<PageElement> pageElements, String pageName){
        this.pageElements = pageElements;
        this.pageName = pageName;
    }

    public void generateFields(){
        FindByElementFieldTemplate template = new FindByElementFieldTemplate();

        for(PageElement element : pageElements){
            fields.addAll(template.getFindByElementField(element));
        }
    }

    public void generateClassName(){
        className = StringUtils.capitalizeFirstLetter(pageName) + "Elements";
    }

    public void generateImports(){
        imports.add("import org.openqa.selenium.WebElement;");
        imports.add("import org.openqa.selenium.support.FindBy;");
    }

    public void generateClassBody(){
        classBody.add(packageName);
        classBody.add("");
        classBody.addAll(imports);
        classBody.add("");
        classBody.add("public class " + className + " {");
        classBody.add("");
        classBody.addAll(fields);
        classBody.add("");
        classBody.add("}");
    }

    public void saveClassToFile(){
        FileUtils.saveGeneratedClassToFile(classBody, new FileUtils().getTestDirectoryPath()
                + "\\java\\pageObjects\\pageElements\\" + className + ".java");

    }


}

