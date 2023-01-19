package testcases;

import TestComponents.BaseTest;
import org.example.pageobjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class InvalidLoginTest extends BaseTest {
    public  void loginErrorValidation() {

        LoginPage loginPage = this.lauchApp();
        loginPage.clickOnLoginButton("kelly677@gmail.com","Ab&212ab");
        loginPage.getErrorMessage();

        Assert.assertEquals("Incorrect email or password.",loginPage.getErrorMessage());


    }
}
