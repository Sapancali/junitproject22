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

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day06_WindowHandle {
  /*
    1- Given kullanici the https://the-internet.herokuapp.com/windows sayfasindadir
    2- Then kullanici text : “Opening a new window” text'i verify eder
    3- Then kullanici sayfanin title (baslik)'i “The Internet” oldugunu verify eder
    4- When kullanici  “Click Here” button'una click eder
    5- Then kullanici yeni pencere basliginin (window title) “New Window” oldugunu verify eder
    6- Then kullanic text: “New Window” oldugunu verify eder
    7- When kullanici onceki window'a gider ve title : “The Internet” oldugunu verify eder
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
    public void windowHandle() throws InterruptedException {
//        1- Given kullanici the https://the-internet.herokuapp.com/windows sayfasindadir
        driver.get("https://the-internet.herokuapp.com/windows");

//        2- Then kullanici text : “Opening a new window” text'i verify eder
        WebElement window1handling=driver.findElement(By.xpath("//*[(text()='Opening a new window')]"));
        Assert.assertEquals("Opening a new window",window1handling.getText());

//        3- Then kullanici sayfanin title (baslik)'i “The Internet” oldugunu verify eder
        String window1Title= driver.getTitle();
        System.out.println(window1Title);
        Assert.assertEquals("The Internet",window1Title);

//        4- When kullanici  “Click Here” button'una click eder
        driver.findElement(By.linkText("Click Here")).click();

        //Driver hala window 1 dedir
        //1. window 1  handle edelim
        String window1Handle=driver.getWindowHandle();
        System.out.println(window1Handle);

        // 2. tüm windowslari handle edelim
        Set<String> tumWindowHandle= driver.getWindowHandles();
        System.out.println(tumWindowHandle);
        //tumWindowHandle hem window1 i, hem window2 yi verir
        for(String herBirWindow:tumWindowHandle){
            if(!herBirWindow.equals(window1Handle)){
                driver.switchTo().window(herBirWindow);
                break;
            }
        }
        //driver window 2 dedir
        //driver window 2 deki elementleri görebilir
        //driver 1 deki elementleri göremez

        //driver.getWindowHandles() == içinde olduğumuz window u döndürur
        //driver.getWindowHandles() == tüm windows ları döndürür
        //spesifik window'lar arasında gecis için index KULLANILMAZ
        //Mantık: eger driver, window 1 ise değistir diyoruz

//        5- Then kullanici yeni pencere basliginin (window title) “New Window” oldugunu verify eder
        String window2Title= driver.getTitle();
        System.out.println(window2Title);
        Assert.assertEquals("New Window",window2Title);

//        6- Then kullanic text: “New Window” oldugunu verify eder
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());

        //driver window 2 de olduğundan window 2 handle edilebilir
        String window2Handle=driver.getWindowHandle();
        System.out.println(window2Handle);

//        7- When kullanici onceki window'a gider ve title : “The Internet” oldugunu verify eder
        Thread.sleep(2000);
        driver.switchTo().window(window1Handle);
        Assert.assertTrue(driver.getTitle().equals("The Internet"));

        //window 2 ye tekrar git
        Thread.sleep(2000);
        driver.switchTo().window(window2Handle);

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
