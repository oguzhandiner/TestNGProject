package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DependsOnMethodTest {

    WebDriver webDriver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test (dependsOnMethods = "googleTest")
    public void amazonTest(){
        webDriver.get("https://amazon.com");
    }

    // dependsOnMethod() bir methodu bir method'dan once calistirmasini saglar
    @Test (dependsOnMethods = "face")
    public void googleTest(){
        webDriver.get("https://google.com");
    }

    @Test
    public void face(){
        webDriver.get("https://facebook.com");
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }


}
