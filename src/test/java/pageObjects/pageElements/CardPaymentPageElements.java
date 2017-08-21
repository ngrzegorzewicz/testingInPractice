package pageObjects.pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardPaymentPageElements {


  @FindBy( id = "task8_form_cardType")
  public WebElement cardTypeSelect;


  @FindBy( id = "task8_form_name")
  public WebElement cardOwnerInput;


  @FindBy( name = "task8_form[save]")
  public WebElement submitButton;


}
