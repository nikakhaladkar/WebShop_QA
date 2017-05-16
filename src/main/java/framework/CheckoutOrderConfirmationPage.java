package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class CheckoutOrderConfirmationPage extends BasePage{

    @FindBy(how = How.XPATH, using = ".//*[@data-omniture-ref='HAHshowCTA']")
    private WebElement HAHBuyNowElement;


    public CheckoutOrderConfirmationPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getDetailsOfOrderConfirmation()
    {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        return bodyText;

    }

    public String getOrderDetails()
    {
        WebElement divElement = driver.findElement(By.className("ref_and_date"));
        String orderRefNumberDetails = divElement.getText();
        return orderRefNumberDetails;

    }

}