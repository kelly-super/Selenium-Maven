package testcases;

import org.example.base.BaseClass;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.example.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterPageTest {
    WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private HomePage   homePage;




    public void tearDown() {
        driver.quit();
    }


    public void verifyElementsOnPageTest(){

    }

}
