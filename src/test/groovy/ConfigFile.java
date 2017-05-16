/**
 * Created by nika.khaladkar on 11/08/2016.
 */
public class ConfigFile {


    public static String browser = System.getProperty("qa.browser", "firefox");
    public static String browserVersion = System.getProperty("qa.browserVersion", "45.0.1");
    public static String hostUrl = "https://webshop-release.hivehome.net/";

}
