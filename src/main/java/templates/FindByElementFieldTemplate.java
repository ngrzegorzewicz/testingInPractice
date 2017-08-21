package templates;

import utilities.PageElement;
import utilities.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nati on 2017-05-29.
 */
public class FindByElementFieldTemplate {

    public List<String> getFindByElementField(PageElement element){

        List<String> result = new ArrayList<String>();

        result.add("");
        result.add("  @FindBy( " + element.getSelectorType() + " = \"" + element.getSelector() + "\")");
        result.add("  public WebElement " + element.getName() +
                StringUtils.capitalizeFirstLetter(element.getType().toString()) + ";");
        result.add("");

        return result;
    }
}


