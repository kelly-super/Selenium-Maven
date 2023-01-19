package org.example.pageobjects;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.example.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver driver;


    @FindBy(id ="userEmail")
    private WebElement userEmail;
    @FindBy(id="userPassword")
    private WebElement password;
    @FindBy(id="login")
    private WebElement loginButton;
   @FindBy(partialLinkText = "Register here")
    private WebElement registerLink;
    @FindBy(partialLinkText = "Forgot password?")
    private WebElement forgotPassword;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    Action action = new Action(driver);

    public  String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
        String text = errorMessage.getText();
        return  text;
    }
    public String getProjectTitle(){
        return driver.getTitle();
    }
    public ProductsPage clickOnLoginButton(String uname, String pswd){
        action.fluentWait(driver,loginButton,10);
        action.type(userEmail,uname);
        action.type(password,pswd);
        action.click(driver,loginButton);
        ProductsPage productsPage = new ProductsPage(driver);
        System.out.println(" current url" +driver.getCurrentUrl());
        return productsPage;

    }

    public void clickOnForgotPassword(){
        action.click(driver,forgotPassword);
        System.out.println(" current url" +driver.getCurrentUrl());

    }
    public RegisterPage clickOnRegisterLink(){
        Log.info("Register page");
       action.fluentWait(driver,registerLink,10);
       action.click(driver,registerLink);
       return new RegisterPage(driver);


    }
    public void openWebsite(String url){
        driver.get(url);
    }
}
