package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class CheckoutYourDetailsPage extends BasePage {


    @FindBy(how = How.CSS, using = "input[value='Next']")
    private WebElement nextButtonElement;


    public CheckoutYourDetailsPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterYourContactDetailsForHAH(String email_address){
        new Select(driver.findElement(By.id("order_ship_address_attributes_title"))).selectByVisibleText("Mr");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("TestUserFirstname");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys("TestUserLastname");
        int randomPhoneNumber;
        randomPhoneNumber = 100 + (int)(Math.random() * ((999999999 - 99) + 1));
        int initialDigits = 07;
        System.out.println("\n");

        System.out.println("User Phone number:"+ initialDigits+""+randomPhoneNumber);
        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("07"+randomPhoneNumber);

        driver.findElement(By.id("order_email_confirmation")).sendKeys(email_address);
        System.out.println("User Email address :"+ email_address);

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("$('#order_hivehome_info_attributes_heating_control_separate_from_boiler').parent('.iradio').iCheck('check');");

        driver.findElement(By.id("postcodelookup")).sendKeys("SL2 5GF");

        driver.findElement(By.xpath(".//*[@data-omniture-ref='PostcodeLU_CTA']")).click();

        Utilities.waitForSomeTime();
        WebElement unorderedList = driver.findElement(By.className("lookup-results"));
        selectValueFromUnorderedList(unorderedList, "Flat 73 The Junction Grays Place, Slough");
        Utilities.waitForSomeTime();

    }

    public void enterYourContactDetailsForLights(String email_address){

        new Select(driver.findElement(By.id("order_ship_address_attributes_title"))).selectByVisibleText("Mr");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("TestUserFirstname");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys("TestUserLastname");

        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("07720240790");


        driver.findElement(By.id("order_email_confirmation")).sendKeys("testuser250701@yopmail.com");

        //click on postcode lookup
        driver.findElement(By.id("postcodelookup")).sendKeys("SL2 5GF");

        //Postcode lookup for Lights kit
        driver.findElement(By.xpath(".//*[@id='shipping']/div[2]/div/div[7]/div/div[2]/div[1]/a")).click();

        WebElement unorderedList = driver.findElement(By.className("lookup-results"));
        selectValueFromUnorderedList(unorderedList, "Flat 73 The Junction Grays Place, Slough");

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("$('#order_terms_and_conditions').parent('.icheckbox').iCheck('check');");




        new Select(driver.findElement(By.id("order_ship_address_attributes_title"))).selectByVisibleText("Mr");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("TestUserFirstname");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys("TestUserLastname");
        int randomPhoneNumber;
        randomPhoneNumber = 100 + (int)(Math.random() * ((999999999 - 99) + 1));
        int initialDigits = 07;
        System.out.println("\n");

        System.out.println("User Phone number:"+ initialDigits+""+randomPhoneNumber);
        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("07"+randomPhoneNumber);

        driver.findElement(By.id("order_email_confirmation")).sendKeys(email_address);
        System.out.println("User Email address :"+ email_address);

        JavascriptExecutor js1 =(JavascriptExecutor)driver;
        js1.executeScript("$('#order_hivehome_info_attributes_heating_control_separate_from_boiler').parent('.iradio').iCheck('check');");

        driver.findElement(By.id("postcodelookup")).sendKeys("SL2 5GF");

        driver.findElement(By.xpath(".//*[@data-omniture-ref='PostcodeLU_CTA']")).click();

        Utilities.waitForSomeTime();
        WebElement unorderedList1 = driver.findElement(By.className("lookup-results"));
        selectValueFromUnorderedList(unorderedList1, "Flat 73 The Junction Grays Place, Slough");
        Utilities.waitForSomeTime();

    }


    public void goToBookAppointmentPage(){

        nextButtonElement.click();
        Utilities.waitForSomeTime();
    }

    public void goToPaymentPage(){

        nextButtonElement.click();
        Utilities.waitForSomeTime();
    }

    public void selectValueFromUnorderedList (WebElement unorderedList, final String value) {

        List<WebElement> options = unorderedList.findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (value.equals(option.getText())) {
                option.click();
                break;
            }
        }
    }

}
