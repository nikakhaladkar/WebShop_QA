package FunctionalTests;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * Created by nika.khaladkar on 04/04/2016.
 */
public class Verify_New_User_Journey_For_Light {

    private WebDriver driver;
    private String baseURL;

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    //@Test
    public void verifyNewUserIsAbleToBuyLightProduct() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/nika.khaladkar/software/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        baseURL = "https://webshop-release.hivehome.net/";
        driver.manage().deleteAllCookies();
        driver.get(baseURL);
        driver.manage().window().maximize();
        //Click on products
        driver.findElement(By.xpath(".//*[@data-omniture-ref='TopNav_Products']")).click();
        Thread.sleep(3000);
        //Click on Heating
        driver.findElement(By.xpath(".//*[@data-omniture-ref='Lights_subnav']")).click();
        Thread.sleep(3000);
        //Click on Buy Now for Heating
        driver.findElement(By.xpath(".//*[@data-omniture-ref='HALshowCTA']")).click();
        Thread.sleep(3000);
        //Click on Add To basket
        driver.findElement(By.xpath(".//*[@data-omniture-ref='Ec_LightScrew_ATB']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("cart-link")).click();
        Thread.sleep(2000);
        //Click on Buy now on cart page
        driver.findElement(By.id("checkout-link")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("order_email")).sendKeys("testuser250701@yopmail.com");
        Thread.sleep(2000);
        String str = driver.findElement(By.cssSelector("input[value='Start checkout']")).getAttribute("value");
        Assert.assertEquals(str,"Start checkout");
        driver.findElement(By.cssSelector("input[value='Start checkout']")).click();
        enterYourContactDetails();
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

    public void enterYourContactDetails() throws InterruptedException{
        new Select(driver.findElement(By.id("order_ship_address_attributes_title"))).selectByVisibleText("Mr");
        driver.findElement(By.id("order_ship_address_attributes_firstname")).sendKeys("TestUserFirstname");
        driver.findElement(By.id("order_ship_address_attributes_lastname")).sendKeys("TestUserLastname");
        driver.findElement(By.id("order_ship_address_attributes_phone")).sendKeys("07720240790");
        driver.findElement(By.id("order_email_confirmation")).sendKeys("testuser250701@yopmail.com");

        //click on postcode lookup
        driver.findElement(By.id("postcodelookup")).sendKeys("SL2 5GF");

        //Postcode lookup for Lights kit
        driver.findElement(By.xpath(".//*[@id='shipping']/div[2]/div/div[7]/div/div[2]/div[1]/a")).click();
        Thread.sleep(2000);
        WebElement unorderedList = driver.findElement(By.className("lookup-results"));
        selectValueFromUnorderedList(unorderedList, "Flat 73 The Junction Grays Place, Slough");

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("$('#order_terms_and_conditions').parent('.icheckbox').iCheck('check');");

        driver.findElement(By.cssSelector("input[value='Next']")).click();
    }

    public void enterPaymentDetails() throws InterruptedException{

        driver.findElement(By.id("card_number")).sendKeys("4263971921001307");
        driver.findElement(By.id("card_code")).sendKeys("000");
        driver.findElement(By.cssSelector("input[value='Pay securely now']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
    }
}


