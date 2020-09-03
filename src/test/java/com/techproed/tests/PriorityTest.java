package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriorityTest {

    WebDriver webDriver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test (priority = 0)
    public void dropDown(){

        webDriver.get("https://amazon.com");

    }

    @Test (priority = 2)
    public void google(){

        webDriver.get("https://google.com");

    }

    @Test (priority = 1)
    public void face(){

        webDriver.get("https://facebook.com");
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }


}
