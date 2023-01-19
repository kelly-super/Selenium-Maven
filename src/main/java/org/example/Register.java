package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

public class Register {
    public String userEmail="kellycc677@gmail.com";
    public String userPwd ="Ab&212ab";
    public static WebDriver webDriver =null;
    boolean status = false;
    @Parameters(value= {"browser","version"})
    @BeforeClass
    public void setUp(String browser, String version){
        if (browser.contains("fireFox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY,"/home/kelly/Downloads/firefox/firefox");
            webDriver = new FirefoxDriver();
            webDriver.get("https://rahulshettyacademy.com/client");
            System.out.println(" open FireFox");
        }
        if(browser.contains("chrome")){
            //Setting the webdriver.chrome.driver property to its executable's location
                        //Instantiating driver object
            webDriver = new ChromeDriver();
            webDriver.get("https://stackoverflow.com/questions/21442898/how-to-initialize-selenium-driver-for-default-web-browser-and-os");
            System.out.println(" chrome");
        }

        if(browser.contains("InternetExplore")){
            System.setProperty("webdriver.ie.driver","");
            webDriver = new InternetExplorerDriver();
        }
        //Safari browser doesn't require any additional configuration and can be directly launched by instantiating with SafariDriver.
        if(browser.contains("Safari")){
            webDriver = new SafariDriver();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName",browser);
        capabilities.setCapability("version",version);
        capabilities.setCapability("visual",true);
        capabilities.setCapability("console",true);
        capabilities.setCapability("video",true);
        capabilities.setCapability("network",true);
        capabilities.setCapability("name","SeleniumJavaTestSample");
    }
    @BeforeMethod
    public void openBrowser()
    {
        webDriver.manage().deleteAllCookies();
        webDriver.get("https://rahulshettyacademy.com/client");
        webDriver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        webDriver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(5));
        WebElement registerButton = webDriver.findElement(By.cssSelector("a.text-reset"));
        registerButton.click();
    }
    // Verifying elements on Registration page
    @Test
    public void verifyElementsOnPageTest()
    {

        WebElement registerTitle = webDriver.findElement(By.cssSelector("h1[class=login-title]"));
        registerTitle.isDisplayed();

        WebElement firstName = webDriver.findElement(By.id("firstName"));
        firstName.isDisplayed();

        WebElement lastName = webDriver.findElement(By.id("lastName"));
        lastName.isDisplayed();

        WebElement userEmail = webDriver.findElement(By.id("userEmail"));
        userEmail.isDisplayed();

        WebElement userMobile = webDriver.findElement(By.id("userMobile"));
        userMobile.isDisplayed();

        WebElement occupation = webDriver.findElement(By.id(""));
        registerTitle.isDisplayed();

        WebElement gender = webDriver.findElement(By.id(""));
        registerTitle.isDisplayed();

        WebElement userPassword = webDriver.findElement(By.id("userPassword"));
        userPassword.isDisplayed();

        WebElement confirmPassword = webDriver.findElement(By.id("confirmPassword"));
        confirmPassword.isDisplayed();

        WebElement over18 = webDriver.findElement(By.cssSelector("input[type=checkbox]"));
        over18.isDisplayed();

        WebElement registerButton = webDriver.findElement(By.cssSelector("input[name=login]"));
        registerButton.isDisplayed();

        WebElement haveAccount = webDriver.findElement(By.partialLinkText("Already have an account?"));
        haveAccount.isDisplayed();

    }
    //Verifying redirection to the login page
        @Test
    public void loginRedirectionTest(){
            WebElement haveAccount = webDriver.findElement(By.partialLinkText("Already have an account?"));
            haveAccount.click();

           /* Set <String>    allWindows = webDriver.getWindowHandles();
            for( String handle: allWindows){
                webDriver.switchTo().window(handle);
            }*/
            String expectedUrl = "https://rahulshettyacademy.com/client/auth/login";
            String actualUrl = webDriver.getCurrentUrl();
            Assert.assertEquals(actualUrl,expectedUrl);

            String expectedTitle ="Let's Shop";
            String actualTitle = webDriver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);

        }
    //Registration with all valid data
    @Test
    public void validRegistrationTest(){

        webDriver.findElement(By.id("firstName")).sendKeys("kelly");
        webDriver.findElement(By.id("lastName")).sendKeys("Liu");
        webDriver.findElement(By.id("userEmail")).sendKeys("kellycc677@gmail.com");
        webDriver.findElement(By.id("userMobile")).sendKeys(""+1234567888);
        webDriver.findElement(By.id("userPassword")).sendKeys("Ab&212ab");
        webDriver.findElement(By.id("confirmPassword")).sendKeys("Ab&212ab");
        WebElement occuption = webDriver.findElement(By.cssSelector("select[formcontrolname=occupation]"));
        Select occuptionSelect = new Select(occuption);
        //   List<WebElement> optionList = occuptionSelect.getOptions();

        occuptionSelect.selectByVisibleText("Engineer");
        WebElement over18 = webDriver.findElement(By.cssSelector("input[type=checkbox]"));
        over18.click();
        if(!over18.isSelected())
            over18.click();

        WebElement genderF = webDriver.findElement(By.cssSelector("input[value=Female]"));
        genderF.click();
        webDriver.findElement(By.id("login")).click();
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "";
        Assert.assertEquals(currentUrl,expectedUrl);

    }
    //Registration without providing firstName,considering user has provided all other information correctly
    //Registration without providing lastName,considering user has provided all other information correctly
    //Registration without providing email,considering user has provided all other information correctly
    //Registration without providing phoneNumber,considering user has provided all other information correctly
    //Registration without providing Occupation,considering user has provided all other information correctly
    //Registration without providing gender,considering user has provided all other information correctly
    //Registration without providing password,considering user has provided all other information correctly
    //Registration without providing confirmPassword,considering user has provided all other information correctly

    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY,"/home/kelly/Downloads/firefox/firefox");
        FirefoxDriver webDriver = new FirefoxDriver();

        webDriver.get("https://rahulshettyacademy.com/client");




    }
 public void tearDown(){
        if(webDriver!=null)
        {
            webDriver.quit();
        }
 }
}
