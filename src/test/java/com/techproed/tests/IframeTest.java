package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    private WebDriver webDriver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void iframeTest(){

        webDriver.get("https://the-internet.herokuapp.com/iframe");
        webDriver.switchTo().frame(0); // bir sayfada bir ya da birden fazla iframe varsa index'ine gore buluyoruz.

        WebElement string = webDriver.findElement(By.xpath("//p"));
        string.clear();
        string.sendKeys("SelamunAleykum");

    }

    @Test
    public void iframeTest02(){

        webDriver.get("https://the-internet.herokuapp.com/iframe");
        webDriver.switchTo().frame("mce_0_ifr"); // iframe'ye gecis yapabilmek icin 'id atribute'si' ile gecis yapabiliriz

        WebElement string = webDriver.findElement(By.xpath("//p"));
        string.clear();
        string.sendKeys("Aleykum Selam");
    }

    @Test
    public void iframeTest03(){

        webDriver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframe = webDriver.findElement(By.id("mce_0_ifr"));
        webDriver.switchTo().frame(iframe);

        WebElement string = webDriver.findElement(By.xpath("//p"));
        string.clear();
        string.sendKeys("ne Yabaysin");
    }

    @Test
    public void iframeTest04(){

        webDriver.get("https://the-internet.herokuapp.com/iframe");
        webDriver.switchTo().frame(0); // bir sayfada bir ya da birden fazla iframe varsa index'ine gore buluyoruz.

        WebElement string = webDriver.findElement(By.xpath("//p"));
        string.clear();
        string.sendKeys("SelamunAleykum");
        //webDriver.switchTo().defaultContent(); // iframe'den cikis yapmamizi saglar, en bas satira geri doner.
        webDriver.switchTo().parentFrame(); // parent'ine donus yaparsiniz yani bir once ki satira.


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement link = webDriver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();

    }
}
