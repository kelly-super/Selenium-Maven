package TestComponents;

import org.example.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static Properties prop;
    public WebDriver driver;
    public LoginPage loginPage;
    public WebDriver initializeDriver() {
        try (FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config/Configuation.properties")) {
            prop = new Properties();
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY, "/home/kelly/Downloads/firefox/firefox");

            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            driver= new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicityWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(prop.getProperty("pageLoadTimeOut"))));
        driver.get(prop.getProperty("url"));
        return driver;
    }
    @BeforeMethod
    public LoginPage lauchApp( ) {
        driver = initializeDriver();
        loginPage = new LoginPage(driver);
        String url = prop.getProperty("url")!=null ?"https://rahulshettyacademy.com/client": prop.getProperty("url");
        loginPage.openWebsite(url);
        return loginPage;
    }
    @AfterMethod
    public  void tearDown(){
        driver.close();
    }
}
