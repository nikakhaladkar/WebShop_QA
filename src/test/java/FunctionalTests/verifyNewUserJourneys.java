package FunctionalTests;

import framework.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by nika.khaladkar on 16/08/2016.
 */
public class verifyNewUserJourneys {

    static WebDriver driver;
    static commonUtils CommonUtils;

    @BeforeMethod
    public static void before(){

        System.setProperty("webdriver.chrome.driver","/Users/nika.khaladkar/software/ChromeDriver/chromedriver");

        driver =  new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://webshop-release.hivehome.net/");


    }

    @AfterMethod
    public static void after(){

        driver.quit();

    }

    @Test
    public void verifyTabsAreDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.verifyAlltabsAreDisplayed();
    }

   //@Test
    public void verifyNewUserIsAbleToBuyHAHKitAndCompleteTheJourney(){
        HomePage homePage = new HomePage(driver);
        homePage.goToProductsHAHPage();
        ProductsHAHPage productsHAHPage = new ProductsHAHPage(driver);
        productsHAHPage.goToShopHAHPage();
        ShopHAHPage shopHAHPage = new ShopHAHPage(driver);
        shopHAHPage.goToSideBasketPage();
        SideBasketPage sideBasketPage = new SideBasketPage(driver);
        sideBasketPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToHiveLoginPage();
        HiveLoginPage hiveLoginPage = new HiveLoginPage(driver);
        String generated_email_address = hiveLoginPage.loginAsNewCustomerAndEnterEmailAddress();
        System.out.println("New User Email address :"+ generated_email_address);
        hiveLoginPage.goToCheckoutYourDetailsPage();
        CheckoutYourDetailsPage checkoutYourDetailsPage = new CheckoutYourDetailsPage(driver);
        checkoutYourDetailsPage.enterYourContactDetailsForHAH(generated_email_address);
        checkoutYourDetailsPage.goToBookAppointmentPage();
        CheckoutBookAppointmentPage checkoutBookAppointmentPage = new CheckoutBookAppointmentPage(driver);
        checkoutBookAppointmentPage.enterBookingAppointmentDetails();
        checkoutBookAppointmentPage.goToPaymentPage();
        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.enterPaymentDetails();
        checkoutPaymentPage.goToOrderConfirmationPage();
        CheckoutOrderConfirmationPage checkoutOrderConfirmationPage = new CheckoutOrderConfirmationPage(driver);
        String orderConfDetails = checkoutOrderConfirmationPage.getDetailsOfOrderConfirmation();
        String orderConfirmationMsg = "Thanks for your order";
        Assert.assertTrue(orderConfDetails.contains(orderConfirmationMsg),"Order confirmation message not found!");
        //assert.assertTrue(orderConfDetails.contains(orderConfirmationMsg), "Order confirmation message not found!");
        String orderDetails = checkoutOrderConfirmationPage.getOrderDetails();
        System.out.println("Order Details :"+ orderDetails);

    }



    /*@Test
    public void verifyNewUserIsAbleToBuyLightsAndCompleteTheJourney(){
        HomePage homePage = new HomePage(driver);
        homePage.goToProductsLightsPage();
        ProductsLightsPage productsLightsPage = new ProductsLightsPage(driver);
        productsLightsPage.goToShopLightsPage();
        ShopLightsPage shopLightsPage = new ShopLightsPage(driver);
        shopLightsPage.goToSideBasketPage();
        SideBasketPage sideBasketPage = new SideBasketPage(driver);
        sideBasketPage.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToHiveLoginPage();
        HiveLoginPage hiveLoginPage = new HiveLoginPage(driver);
        String generated_email_address = hiveLoginPage.loginAsNewCustomerAndEnterEmailAddress();
        System.out.println("New User Email address :"+ generated_email_address);
        hiveLoginPage.goToCheckoutYourDetailsPage();
        CheckoutYourDetailsPage checkoutYourDetailsPage = new CheckoutYourDetailsPage(driver);
        checkoutYourDetailsPage.enterYourContactDetailsForLights(generated_email_address);
        checkoutYourDetailsPage.goToPaymentPage();
        CheckoutPaymentPage checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.enterPaymentDetails();
        checkoutPaymentPage.goToOrderConfirmationPage();
        CheckoutOrderConfirmationPage checkoutOrderConfirmationPage = new CheckoutOrderConfirmationPage(driver);
        String orderConfDetails = checkoutOrderConfirmationPage.getDetailsOfOrderConfirmation();
        String orderConfirmationMsg = "Thanks for your order";
        Assert.assertTrue(orderConfDetails.contains(orderConfirmationMsg), "Order confirmation message not found!");
        String orderDetails = checkoutOrderConfirmationPage.getOrderDetails();
        System.out.println("Order Details :"+ orderDetails);


    }*/

}
