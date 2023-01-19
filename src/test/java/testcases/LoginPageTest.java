package testcases;

import TestComponents.BaseTest;
import org.example.base.BaseClass;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.ProductsPage;
import org.example.utility.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductsPage productsPage;




    @Test()
    @Parameters({"emailId","password"})
    public void loginTest(String emailId,String password){
        Log.startTestCase("loginTest");
        loginPage = lauchApp();
        productsPage = loginPage.clickOnLoginButton(emailId,password);
        String actualURL = productsPage.getCurrURL();
        String expectedURL ="https://rahulshettyacademy.com/client/dashboard/dash";
        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("Login is Success");
        Log.endTestCase("loginTest");
    }
}
