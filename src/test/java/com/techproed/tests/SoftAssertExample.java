package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertExample {

    WebDriver webDriver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test01(){
        webDriver.get("http://a.testaddressbook.com/sign_in");
        SoftAssert softAssert = new SoftAssert();

        WebElement email = webDriver.findElement(By.id("session_email"));
        email.sendKeys("testtechproed@gmail.com");
        softAssert.assertTrue(email.getText().equals(webDriver.getTitle().equals("Deneme")));

        WebElement password = webDriver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");
        softAssert.assertTrue(email.getText().equals(webDriver.getTitle().equals("AdressDeneme")));
        password.submit();

        WebElement signOut = webDriver.findElement(By.partialLinkText("Sign out"));
        boolean varYok = signOut.isDisplayed();

        softAssert.assertAll();



    }
}
