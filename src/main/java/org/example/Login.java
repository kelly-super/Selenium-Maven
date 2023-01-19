package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    public static void main(String[] args) {

            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY,"/home/kelly/Downloads/firefox/firefox");
            FirefoxDriver webDriver = new FirefoxDriver();
        webDriver.get("https://rahulshettyacademy.com/client");
        WebElement emailId = webDriver.findElement(By.name("emailid"));
        emailId.sendKeys("");
        webDriver.findElement(By.name("btnLogin")).click();
        webDriver.close();


    }
}
