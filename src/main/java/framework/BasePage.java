package framework;

import org.openqa.selenium.WebDriver;

/**
 * Created by nika.khaladkar on 18/08/2016.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }


}
