package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class ShopLightsPage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='Ec_LightScrew_ATB']")
    private WebElement addToBasketElement;


    public ShopLightsPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToSideBasketPage()
    {
        addToBasketElement.click();
        Utilities.waitForSomeTime();
    }
}
