package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nika.khaladkar on 16/08/2016.
 */
public class commonUtils {

    WebDriver driver;

    public commonUtils(WebDriver driver){
        this.driver = driver;
    }

    public void closeBrowser(){
        driver.close();
    }

    public void testOutput(){
        System.out.println("Hello World From London");
    }

    public void clickOnProducts(){
        driver.findElement(By.xpath(".//*[@data-omniture-ref='TopNav_Products']")).click();
    }

    public void clickOnHeating(){
        driver.findElement(By.xpath(".//*[@data-omniture-ref='Heating_subnav']")).click();
    }
}
