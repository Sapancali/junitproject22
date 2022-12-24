package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day08_C26_JavaScript_Executor extends TestBase {
    /*
    JavaScript Executor ile bazı browser elemenlerini otomate icçin kullanırız
    -scroll up/down/right/left== arrow up/down
    -elemmente kadar kaydır
    -click
    -alert
    -renk değiştirebilir

    Note: scrollIntoView() istediğimiz elemente kadar asağı/yukarı yada sağa/sola kaydırıbiliriz
     */

  /*
    Kullanici aplicasyonun Url (websayfasi)'ine gider
    Sayfada "Have a Questions?" text'ini verify et
     */
@Test
    public void scrollIntoView() throws InterruptedException {
    driver.get("http://www.carettahotel.com/");
    Thread.sleep(2000);
    driver.findElement(By.id("details-button")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("proceed-link")).click();

    WebElement question= driver.findElement(By.xpath("//*[.='Have a Questions?']"));
    //Assert.assertTrue(question.isDisplayed());
    Thread.sleep(2000);
    JavascriptExecutor je=(JavascriptExecutor) driver;
    je.executeScript("arguments[0].scrollIntoView(true);",question);
    Thread.sleep(2000);
    Assert.assertEquals(question.getText(),"Have a Questions?");

}
}
