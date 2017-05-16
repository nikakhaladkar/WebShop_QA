package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='TopNav_Products']")
    private WebElement productsLinkElement;

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='TopNav_Installation']")
    private WebElement installationLinkElement;

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='TopNav_Help']")
    private WebElement helpLinkElement;

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='TopNav_Shop']")
    private WebElement shopLinkElement;

    @FindBy(how = How.ID, using = "open-sidebar-basket")
    private WebElement basketLinkElement;

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='Heating_subnav']")
    private WebElement heatingLinkElement;

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='Lights_subnav']")
    private WebElement lightsLinkElement;


    public HomePage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToProductsLightsPage()
    {
        Utilities.waitForSomeTime();
        productsLinkElement.click();
        Utilities.waitForSomeTime();
        lightsLinkElement.click();
        Utilities.waitForSomeTime();
    }

    public void goToProductsHAHPage()
    {
        productsLinkElement.click();
        Utilities.waitForSomeTime();
        heatingLinkElement.click();
    }

    public void goToShopPage()
    {
       //TODO
    }

    public void goToProductsSensorsPage()
    {
        //TODO
    }

    public void verifyAlltabsAreDisplayed(){

        Assert.assertTrue(productsLinkElement.isDisplayed(), "Products Tab not found!");
        Assert.assertTrue(installationLinkElement.isDisplayed(), "Installation Tab not found!");
        Assert.assertTrue(helpLinkElement.isDisplayed(), "Help Tab not found!");
        Assert.assertTrue(shopLinkElement.isDisplayed(), "Shop Tab not found!");
        Assert.assertTrue(basketLinkElement.isDisplayed(), "Basket Tab not found!");

    }
}
