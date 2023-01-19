package testcases;

import org.example.base.BaseClass;
import org.example.pageobjects.HomePage;
import org.example.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class HomePageTest extends BaseClass {
    private LoginPage loginPage;
    private HomePage homePage;


    public HomePageTest(WebDriver driver) {
        super(driver);
    }
}
