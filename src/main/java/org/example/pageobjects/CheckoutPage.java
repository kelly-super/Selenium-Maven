package org.example.pageobjects;

import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseClass {
    WebDriver driver;

    @FindBy(css=".action_submit")
    WebElement placeOrder;
    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;
    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;
    public CheckoutPage(WebDriver driver) {

        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    Action action = new Action(driver);
    By results = By.cssSelector(".ta-results");
    public  void selectCountry(String countryName){
        action.type(country,countryName);
        waitForElementToAppear(results);
        selectCountry.click();
        //action.selectBySendkeys(countryName,country);
    }

    public ConfirmationPage placeOrder(){
        placeOrder.click();
        return new ConfirmationPage(driver);
    }
}
