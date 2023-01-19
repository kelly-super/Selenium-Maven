package testcases;

import TestComponents.BaseTest;
import org.example.base.BaseClass;
import org.example.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test
    public  void submitOrder() {
        String productName ="ZARA COAT 3";
        LoginPage lp = this.lauchApp();
        ProductsPage productsPage = lp.clickOnLoginButton("kellycc677@gmail.com","Ab&212ab");

        List<WebElement> products = productsPage.getProducts();
        productsPage.addProductToCart(productName);

        CartPage cartPage = productsPage.goToCart();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("China");
        ConfirmationPage confirmationPage = checkoutPage.placeOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER."));


    }
}
