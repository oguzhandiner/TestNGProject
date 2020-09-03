package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {

    /*
        SoftAssert kullaniminin Hard Assert'ten farklari
        1- SoftAssert'de test basarisizsa calistirmaya devam eder.
        2- SoftAssert'te obje olusturmamiz gerekiyor.
        Assert denilince aklimiza Hard Assert gelmeli
        Vericty denilince SoftAssert aklimiza gelmeli.
     */

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
        SoftAssert softAssert = new SoftAssert();
        webDriver.get("https://amazon.com");
        String title = webDriver.getTitle();
        softAssert.assertEquals(title.contains("Amazon"), title);
        softAssert.assertTrue(title.contains("car"));
        softAssert.assertFalse(title.contains("online"));
        softAssert.assertAll();


    }
}
