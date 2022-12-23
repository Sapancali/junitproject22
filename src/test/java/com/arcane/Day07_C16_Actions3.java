package com.arcane;

import com.arcane.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day07_C16_Actions3 extends TestBase {
 /*
    1- test method olustur : keysUpDown()
    2- https://www.google.com sayfasina git
    3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.
    4- cift tiklayarak search box'i etkilestir
 */

    @Test
    public void keysUpDown(){
//        2- https://www.google.com sayfasina git
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();

//        3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.
        WebElement searchBox=driver.findElement(By.name("q"));
        Actions actions=new Actions(driver);

//        4- cift tiklayarak search box'i etkilestir
        actions.keyDown(searchBox, Keys.SHIFT).//shift butonuna bas
                sendKeys("iPhone Pro Max"). // element içinde yaz
                keyUp(searchBox, Keys.SHIFT).// shift butonuna basmayı bırak

                sendKeys(" 14 cok pahali"+Keys.ENTER).
                build(). // build() opsiyoneldir. perform() daha güçlü yapar. build olmadan da calışır
                perform();
    }

}
