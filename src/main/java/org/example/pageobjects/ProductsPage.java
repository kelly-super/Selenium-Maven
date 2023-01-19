package org.example.pageobjects;

import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseClass {
    WebDriver driver;
    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".mb-3")
    List<WebElement> products;
    @FindBy(css=".ng-animating")
    WebElement spinner;
    Action action = new Action(driver);
    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".fa-shopping-cart");

    By toastMessage =By.cssSelector("#toast-container");

    public List<WebElement> getProducts(){
        waitForElementToAppear(productsBy);
        return products;
    }

    public  WebElement getProductByName(String name){

        return getProducts().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
    }

    public void addProductToCart(String name){
        WebElement prod = getProductByName(name);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisapper(spinner);
    }
    public String getCurrURL(){
        return action.getCurrentURL(driver);
    }
}
