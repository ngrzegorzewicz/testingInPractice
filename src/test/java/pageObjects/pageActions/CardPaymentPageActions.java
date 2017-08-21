package pageObjects.pageActions;

import pageObjects.pageElements.CardPaymentPageElements;

public class CardPaymentPageActions {

 CardPaymentPageElements pageElements = new CardPaymentPageElements();

  public void clickOnSubmitButton(){
     pageElements.submitButton.click();
  }

}
