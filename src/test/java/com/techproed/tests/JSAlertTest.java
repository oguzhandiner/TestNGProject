package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {

    WebDriver webDriver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void jsAlertTest(){

        webDriver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJsAlert = webDriver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickJsAlert.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Alert'in icerdigi mesaj almak icin getText() kullaniriz.
        String alertMsj = webDriver.switchTo().alert().getText();
        System.out.println(alertMsj);
        // Alert'n icinde ki "okey" butonuna tiklamaya yarar.
        webDriver.switchTo().alert().accept();
    }

    @Test
    public void jsAlert02(){

        webDriver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsCorfim = webDriver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsCorfim.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String corfimText = webDriver.switchTo().alert().getText();
        System.out.println(corfimText);
        webDriver.switchTo().alert().dismiss();
        jsCorfim.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.switchTo().alert().accept();
    }

    @Test
    public void jsPrompt(){

        webDriver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = webDriver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsPromptText = webDriver.switchTo().alert().getText();
        System.out.println(jsPromptText);
        webDriver.switchTo().alert().sendKeys("SelamunAleykum");
        webDriver.switchTo().alert().accept();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jsPrompt.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.switchTo().alert().dismiss();

    }
}
