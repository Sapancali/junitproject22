package com.arcane;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day07_C17_Actions4 extends TestBase {
/*
    Test method olustur : scrollUpDown()
    1- Amazon'a git : https://www.amazon.com
    2- Sayfayi Scroll down (asagi kaydir) yap
    3- Sayfayi Scroll up (yukari kaydir) yap
    */
   @Test
   public void scrollUpDown() throws InterruptedException {
//       1- Amazon'a git : https://www.amazon.com
       driver.get("https://www.amazon.com");

//       2- Sayfayi Scroll down (asagi kaydir) yap

       Actions actions=new Actions(driver);
       actions.sendKeys(Keys.ARROW_DOWN). //Arrow_Down == Scroll Down== Page_Down
               perform();
        Thread.sleep(2000);
       //2. kere asagı kaydır
       actions.sendKeys(Keys.PAGE_DOWN). // Arrow_Down sayfayı daha az aşağı kaydırır
               perform();
       Thread.sleep(2000);
//       3- Sayfayi Scroll up (yukari kaydir) yap
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       Thread.sleep(2000);
       actions.sendKeys(Keys.PAGE_UP).perform();
       Thread.sleep(2000);
   }

}
