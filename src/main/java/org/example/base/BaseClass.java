package org.example.base;

import org.example.pageobjects.CartPage;
import org.example.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public  WebDriver driver;
    public LoginPage loginPage;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHearder;

    By cart = By.cssSelector("[routerlink*='cart']");
   /* public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }*/

    public BaseClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void waitForElementToAppear(By findBy) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForWebElementToAppear(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitForElementToDisapper(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public CartPage goToCart() {
        waitForElementToAppear(cart);
        cartHearder.click();
        return new CartPage(driver);
    }


}
