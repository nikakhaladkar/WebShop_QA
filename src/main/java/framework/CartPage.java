package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class CartPage extends BasePage{

    @FindBy(how = How.ID, using = "checkout-link")
    private WebElement buyNowCartElement;


    public CartPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToHiveLoginPage()
    {
        buyNowCartElement.click();
        Utilities.waitForSomeTime();
    }
}
