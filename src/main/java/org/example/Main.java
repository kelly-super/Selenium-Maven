package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_BINARY,"/home/kelly/Downloads/firefox/firefox");
        FirefoxDriver webDriver = new FirefoxDriver();
      /*  webDriver.get("https://demo.guru99.com/");
        WebElement emailId = webDriver.findElement(By.name("emailid"));
        emailId.sendKeys("kelly");
        webDriver.findElement(By.name("btnLogin")).click();
        webDriver.close();*/
        webDriver.get("https://rahulshettyacademy.com/client");

        String title = webDriver.getTitle();
        System.out.println("title: "+title);
        WebElement email = webDriver.findElement(By.id("userEmail"));
        email.sendKeys("kellycc677@gmail.com");
        //Assert email's format
        WebElement pwd = webDriver.findElement(By.id("userPassword"));
        pwd.sendKeys("test");
        webDriver.findElement(By.id("login")).click();

    }

}