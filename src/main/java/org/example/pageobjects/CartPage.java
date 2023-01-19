package org.example.pageobjects;

import org.example.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseClass {
    WebDriver driver;
    @FindBy(css=".cartSection h3")
    public List<WebElement> cartProducts;
    @FindBy(css=".totalRow button")
    public WebElement checkout;
    @FindBy(css="[routerlink*='dashboard']")
    public  WebElement continueShopping;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public  Boolean VerifyProductDisplay(String name){
        Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(name));
        return match;
    }

    public CheckoutPage goToCheckout(){
        checkout.click();
        return new CheckoutPage(driver);
    }

    public void continueShopping(){
        continueShopping.click();
    }

}
