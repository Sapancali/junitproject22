package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day06_C12_IFrameOrnek {
    //mulakat sorusu : bir web safyası icerisinde toplam iframe leri bulun
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @Test
    public void iframeSayisi(){
        List<WebElement> iframeElement= driver.findElements(By.xpath("//iframe"));
        int iframesayisi= iframeElement.size();
        System.out.println(iframesayisi);

        driver.get("https://the-internet.herokuapp.com");
        System.out.println(driver.findElements(By.xpath("//iframe")).size());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
