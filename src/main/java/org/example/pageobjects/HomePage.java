package org.example.pageobjects;

import com.beust.ah.A;
import org.example.actiondriver.Action;
import org.example.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(name="search")
    private WebElement homeTitle;
    @FindBy(name="search")
    private WebElement searchInput;
    @FindBy(name="minPrice")
    private WebElement  minPrice;
    @FindBy(name="maxPrice")
    private WebElement  maxPrice;

    @FindBy(id="products")
    private  WebElement products;

    public HomePage(WebDriver driver){

        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    Action action = new Action(driver);
    public String getCurrURL(){
        return action.getCurrentURL(driver);
    }


}
