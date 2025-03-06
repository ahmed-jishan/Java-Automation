package org.example.basedrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {


    public static String url="https://www.rokomari.com/book";
    public static String url2= "https://www.rokomari.com/login";
    public static String url3= "https://www.facebook.com/login.php?skip_api_login=1&api_key=3088986207874317&kid_directed_site=0&app_id=3088986207874317&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fdialog%2Foauth%3Fresponse_type%3Dcode%26client_id%3D3088986207874317%26scope%3Dpublic_profile%2Bemail%26state%3DHoIw4heMYln6GlM7-NblyFimQI_f3KTjptMYklZ_0tE%253D%26redirect_uri%3Dhttps%253A%252F%252Fwww.rokomari.com%252Fauth%252Flogin%252Foauth2%252Fcode%252Ffacebook%26ret%3Dlogin%26fbapp_pres%3D0%26logger_id%3D0d51597d-9375-4836-b26c-d22d333979fa%26tp%3Dunspecified&cancel_url=https%3A%2F%2Fwww.rokomari.com%2Fauth%2Flogin%2Foauth2%2Fcode%2Ffacebook%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%26state%3DHoIw4heMYln6GlM7-NblyFimQI_f3KTjptMYklZ_0tE%253D%23_%3D_&display=page&locale=en_GB&pl_dbl=0";
    public static String url4= "https://www.rokomari.com/book?social_user=true#_=_";
    public static String url5= "https://www.rokomari.com/book/authors?ref=sm_p0";
    public static String url6= "https://www.rokomari.com/book/authors?ref=sm_p0&page=2";
    public static String url7= "https://www.rokomari.com/book/author/1247/kazi-nazrul-islam";
    public static String url8= "https://www.rokomari.com/book/author/1247/kazi-nazrul-islam?xyz=&categoryIds=718&priceRange=0to5200&discountRange=0to40";
    public static String url9= "https://www.rokomari.com/book/8112/serstho-golpo";
    public static WebDriver driver;

    @BeforeSuite
    public void startBrowser() {
        // Define a string variable to specify the browser name
        String browser_name = "chrome";

        // Check if the specified browser is "chrome"
        if (browser_name.equals("chrome")) {
            // Set up the Chrome WebDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();
            // Initialize the ChromeDriver instance
            driver = new ChromeDriver();
            // Maximize the browser window
            driver.manage().window().maximize();
        } else if (browser_name.equals("firefox")) {
            // Set up the Firefox WebDriver using WebDriverManager
            WebDriverManager.firefoxdriver().setup();
            // Initialize the FirefoxDriver instance
            driver = new FirefoxDriver();
            // Maximize the browser window
            driver.manage().window().maximize();
        } else {
            // Set up the Edge WebDriver using WebDriverManager
            WebDriverManager.edgedriver().setup();
            // Initialize the EdgeDriver instance
            driver = new EdgeDriver();
            // Maximize the browser window
            driver.manage().window().maximize();
        }

        // Set the WebDriver instance in the PageDriver
        PageDriver.getInstance().setDriver(driver);
    }

    // Annotate the method to indicate it should run after the entire test suite
    @AfterSuite
    public void closeBrowser() {
        // Close the browser and quit the WebDriver session
        driver.quit();
    }
}
