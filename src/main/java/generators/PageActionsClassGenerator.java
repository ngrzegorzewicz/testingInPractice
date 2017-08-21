package generators;

import templates.ClickOnElementMethodTemplate;
import utilities.FileUtils;
import utilities.PageElement;
import utilities.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nati on 2017-05-18.
 */

public class PageActionsClassGenerator {

    private List<PageElement> pageElements;
    private List<String> classBody = new ArrayList<String>();
    private List<String> methods = new ArrayList<String>();
    private List<String> imports = new ArrayList<String>();
    private String packageName = "package pageObjects.pageActions;";;
    private String pageName;
    private String className;
    private String field;

    public PageActionsClassGenerator(List<PageElement> pageElements, String pageName){
        this.pageElements = pageElements;
        this.pageName = pageName;
    }

    public void generateMethods(){

        ClickOnElementMethodTemplate template = new ClickOnElementMethodTemplate();

        for(PageElement element : pageElements){
            switch (element.getType()){
                case button:
                    List<String> results = template.getClickMethod(element);
                    this.methods = new ArrayList<String>(classBody);
                    this.methods.addAll(results);
                    this.methods.add("");
                    break;
                default:
                    System.out.println("Not supported element type");
            }
        }
    }

    public void generateImports(){
        this.imports.add("import pageObjects.pageElements."
                + StringUtils.capitalizeFirstLetter(pageName) +"Elements;");
    }

    public void generateClassName(){
        this.className = StringUtils.capitalizeFirstLetter(pageName) + "Actions";
    }

    public void generateField(){
        this.field = StringUtils.capitalizeFirstLetter(pageName)
                +"Elements pageElements = new " + StringUtils.capitalizeFirstLetter(pageName)
                +"Elements();";
    }

    public List<String> getClassBody(){
        return classBody;
    }


    public void generateClassBody(){

        classBody.add(packageName);
        classBody.add("");
        classBody.addAll(imports);
        classBody.add("");
        classBody.add("public class " + className + " {");
        classBody.add("");
        classBody.add(" " + field);
        classBody.add("");
        classBody.addAll(methods);
        classBody.add("}");

    }

    public void saveClassToFile(){
        FileUtils.saveGeneratedClassToFile(classBody,  new FileUtils().getTestDirectoryPath()
                + "\\java\\pageObjects\\pageActions\\" + className + ".java");
    }
}

