package templates;

import utilities.PageElement;
import utilities.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nati on 2017-05-18.
 */

public class ClickOnElementMethodTemplate {


    public List<String> getClickMethod(PageElement element){
        List<String> result = new ArrayList<String>();

        String methodName = "clickOn" + StringUtils.capitalizeFirstLetter(element.getName())
                                + StringUtils.capitalizeFirstLetter(element.getType().toString());

        result.add(0, "  public void " + methodName + "(){");
        result.add(1, "     pageElements." + element.getName()
                + StringUtils.capitalizeFirstLetter(element.getType().toString()) + ".click();");
        result.add(2, "  }");

        return result;
    }

}


