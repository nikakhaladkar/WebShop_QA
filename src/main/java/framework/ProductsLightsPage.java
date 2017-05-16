package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class ProductsLightsPage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='HALshowCTA']")
    private WebElement lightsBuyNowElement;


    public ProductsLightsPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToShopLightsPage()
    {
        lightsBuyNowElement.click();
        Utilities.waitForSomeTime();
    }
}
