package FunctionalTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by nika.khaladkar on 11/08/2016.
 */
public class verify_New_User_Journey {

    private WebDriver driver = null;
    private String baseURL;

    //@Test
    public void verifyNewUserIsAbleToBuyHAH() throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver","/Users/nika.khaladkar/software/ChromeDriver/chromedriver");
//        System.setProperty("webdriver.chrome.driver","/Users/nika.khaladkar/software/ChromeDriver/chromedriver");

        WebDriver driver = new FirefoxDriver();
       // driver = new ChromeDriver();
        baseURL = "https://webshop-release.hivehome.net/";
        //driver.manage().deleteAllCookies();
        driver.get(baseURL);
        driver.manage().window().maximize();
        //Click on products
        driver.findElement(By.xpath(".//*[@data-omniture-ref='TopNav_Products']")).click();
        Thread.sleep(3000);
        //Click on Heating
        driver.findElement(By.xpath(".//*[@data-omniture-ref='Heating_subnav']")).click();
        Thread.sleep(3000);
        //Click on Buy Now for Heating
        driver.findElement(By.xpath(".//*[@data-omniture-ref='HAHshowCTA']")).click();
        Thread.sleep(3000);
        //Click on Add To basket
        driver.findElement(By.xpath(".//*[@data-omniture-ref='Ec_HAH_ATB']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("cart-link")).click();
        Thread.sleep(2000);
        //Click on Buy now on cart page
        driver.findElement(By.id("checkout-link")).click();
        Thread.sleep(2000);
        String login_Email = "order_email";
        String email_address = enterEmailAddress(login_Email);
        Thread.sleep(2000);
        String str = driver.findElement(By.cssSelector("input[value='Start checkout']")).getAttribute("value");
        Assert.assertEquals(str,"Start checkout");
        driver.findElement(By.cssSelector("input[value='Start checkout']")).click();
        enterYourContactDetails(email_address);
        enterBookingAppointmentDetails();
        enterPaymentDetails();

        String orderConfirmationMsg = "Thanks for your order";
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains(orderConfirmationMsg), "Order confirmation message not found!");
        driver.quit();

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

    public void enterYourContactDetails(String email_address) throws InterruptedException{
        new Select(driver.findElement(By.id("order_ship_address_attributes_title"))).selectByVisibleText("Mr");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("TestUserFirstname");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys("TestUserLastname");
        int randomPhoneNumber;
        randomPhoneNumber = 100 + (int)(Math.random() * ((999999999 - 99) + 1));
        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("07"+randomPhoneNumber);
        driver.findElement(By.id("order_email_confirmation")).sendKeys(email_address);

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("$('#order_hivehome_info_attributes_heating_control_separate_from_boiler').parent('.iradio').iCheck('check');");

        driver.findElement(By.id("postcodelookup")).sendKeys("SL2 5GF");

        driver.findElement(By.xpath(".//*[@data-omniture-ref='PostcodeLU_CTA']")).click();

        Thread.sleep(2000);
        WebElement unorderedList = driver.findElement(By.className("lookup-results"));
        selectValueFromUnorderedList(unorderedList, "Flat 73 The Junction Grays Place, Slough");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='Next']")).click();
    }

    public void enterBookingAppointmentDetails() throws InterruptedException{

        //driver.findElement(By.xpath(".//*[@data-omniture-ref='BA_Book_CTA']")).click();
        driver.findElement(By.cssSelector("a.pick-appointment")).click();
        Thread.sleep(4000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("$('#order_terms_and_conditions').parent('.icheckbox').iCheck('check');");
        driver.findElement(By.cssSelector("input[value='Next']")).click();
    }


    public void enterPaymentDetails() throws InterruptedException{

        driver.findElement(By.id("card_number")).sendKeys("4263971921001307");
        driver.findElement(By.id("card_code")).sendKeys("000");
        driver.findElement(By.cssSelector("input[value='Pay securely now']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.cssSelector("input[value='Submit']")).click();
    }

    public String enterEmailAddress(String fieldId){
        int randomNumber;
        randomNumber = 100 + (int)(Math.random() * ((1000000 - 100) + 1));
        driver.findElement(By.id(fieldId)).sendKeys("automationtest"+randomNumber+"@yopmail.com");
        String generated_emailID = driver.findElement(By.id(fieldId)).getAttribute("value");
        return generated_emailID;

    }
}


// String test = "new" + random.nextInt();
