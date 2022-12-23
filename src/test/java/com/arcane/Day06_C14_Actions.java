package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Day06_C14_Actions {
  /*
    Test method olustur : contextClickMethod() ve scenario test et:
   1-  Given kullanici the https://the-internet.herokuapp.com/context_menu sayfasindadir
   2-  When box (kutucuk) Right clicks edilir
   3- Then “You selected a context menu” alert mesajini verify et
   4- Then alert'u accept et
    */
  WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void contextClickMethod(){
//        1-  Given kullanici the https://the-internet.herokuapp.com/context_menu sayfasindadir
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        2-  When box (kutucuk) Right clicks edilir
        //1. adım action object oluştur
        Actions actions=new Actions(driver);
        //2. adım calışılmak istenen elemanı locate et
        WebElement box=driver.findElement(By.id("hot-spot"));
        //3. adım actions object oluştu, elementi bulduk aldık, right (sağ tıkla) click yap. perform() sonda MUTLAKA kullanılmalı
        actions.contextClick(box).perform();

//        3- Then “You selected a context menu” alert mesajini verify et
        String alert= driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alert);
//        4- Then alert'u accept et
        driver.switchTo().alert().accept();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
