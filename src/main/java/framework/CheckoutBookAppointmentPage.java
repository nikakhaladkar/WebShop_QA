package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class CheckoutBookAppointmentPage extends BasePage {

    @FindBy(how = How.CSS, using = "a.pick-appointment")
    private WebElement pickAppointmentElement;

    @FindBy(how = How.CSS, using = "input[value='Next']")
    private WebElement bookAppointmentNextElement;


    public CheckoutBookAppointmentPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void enterBookingAppointmentDetails()
    {
        pickAppointmentElement.click();
        Utilities.waitForSomeTime();
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("$('#order_terms_and_conditions').parent('.icheckbox').iCheck('check');");

    }

    public void goToPaymentPage()
    {
        bookAppointmentNextElement.click();
        Utilities.waitForSomeTime();
    }

}
