package org.example.pageobjects;

import org.example.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage  extends BaseClass {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {

        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".hero-promary")
    WebElement confrimationMessage;
    public String verifyConfirmationMessage(){
        return confrimationMessage.getText();
    }

    public String getConfirmationMessage() {
        return confrimationMessage.getText();
    }
}
