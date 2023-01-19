package org.example.pageobjects;

import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {

    WebDriver driver;
    @FindBy(id="firstName")
    private WebElement firstName;
    @FindBy(id="lastName")
    private WebElement lastName;
    @FindBy(id="userEmail")
    private WebElement userEmail;
    @FindBy(id="userMobile")
    private WebElement userMobile;
    @FindBy(id="userPassword")
    private WebElement userPassword;
    @FindBy(id="confirmPassword")
    private WebElement confirmPassword;
    @FindBy(css="select[formcontrolname=occupation]")
    private WebElement occupation;
    @FindBy(css="input[type=checkbox]")
    private WebElement over18;
    @FindBy(css="input[value=Female]")
    private WebElement female;
    @FindBy(css="input[value=Male]")
    private WebElement male;
    @FindBy(id="login")
    private WebElement registerBth;

    @FindBy(partialLinkText = "Login here")
    private WebElement loginHere;

    public  RegisterPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
   /* Action action = new Action();
    public void createAccount(String fName,String lName,
                                   String uemail,
                                   String phone,
                                   String occp,
                                   String upswd,
                                   String conPswd,
                                   String wover18,
                                   String gender){
        if(gender.equalsIgnoreCase("Male")){
            action.click(driver,male);
        }else{
            action.click(driver,female);
        }
        action.type(firstName,fName);
        action.type(lastName,lName);
        action.type(userEmail,uemail);
        action.type(userMobile,phone);
        action.selectByValue(occupation,occp);
        action.type(userPassword,upswd);
        action.type(confirmPassword,conPswd);
        if(wover18.equals("Y")){
            action.isSelected(driver,over18);
        }

    }*/
    public HomePage validateRegistration(){
        registerBth.click();
        return new HomePage(driver);
    }
    public LoginPage loginLink(){
        loginHere.click();
        return new LoginPage(driver);
    }

}
