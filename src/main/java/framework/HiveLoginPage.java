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
public class HiveLoginPage extends BasePage {

    @FindBy(how = How.ID, using = "order_email")
    private WebElement newUserEmailElement;


    @FindBy(how = How.CSS, using = "input[value='Start checkout']")
    private WebElement startCheckoutElement;


    public HiveLoginPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToCheckoutYourDetailsPage()
    {
        startCheckoutElement.click();
        Utilities.waitForSomeTime();
    }

    public void loginAsExistingCustomer()
    {

    }

    public String loginAsNewCustomerAndEnterEmailAddress(){
        int randomNumber;
        randomNumber = 100 + (int)(Math.random() * ((1000000 - 100) + 1));
        newUserEmailElement.sendKeys("automationtest"+randomNumber+"@yopmail.com");
        String generated_emailID = newUserEmailElement.getAttribute("value");
        return generated_emailID;

    }




}
