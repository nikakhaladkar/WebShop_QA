package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class CheckoutPaymentPage extends BasePage {

    @FindBy(how = How.ID, using = "card_number")
    private WebElement cardNumberElement;

    @FindBy(how = How.ID, using = "card_code")
    private WebElement cardSecurityCodeElement;

    @FindBy(how = How.CSS, using = "input[value='Pay securely now']")
    private WebElement paySecurelyNowElement;


    public CheckoutPaymentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterPaymentDetails()
    {
        cardNumberElement.sendKeys("4263971921001307");
        cardSecurityCodeElement.sendKeys("000");

    }

    public void goToOrderConfirmationPage()
    {
        paySecurelyNowElement.click();
        Utilities.waitForSomeTime();
    }
}
