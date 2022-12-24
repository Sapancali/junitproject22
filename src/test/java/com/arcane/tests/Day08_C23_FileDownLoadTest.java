package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_C23_FileDownLoadTest extends TestBase {
  /*
    FileDownloadTest() olustur
    1- https://the-internet.herokuapp.com/download adresine git
    2- Screenshot (6).png download et
    3- Dosyanin download edildigini verify et
     */
@Test
    public void FileDownloadTest() throws InterruptedException {
//    1- https://the-internet.herokuapp.com/download adresine git
    driver.get("https://the-internet.herokuapp.com/download");

//    2- Screenshot (6).png download et
    driver.findElement(By.linkText("Screenshot (6).png")).click();
    //Download da MUTLAKA hard wait eklenmeli çünkü dosyanın indirilmesi zaman alır
    //implicitly ve explicitly wait bekleme problemini cözmez cünkü download window (bilgisayar) aplikasyonudur
    //selenium ile halledilemez
    Thread.sleep(3000);

//    3- Dosyanin download edildigini verify et
    String homePath= System.getProperty("user.home");
    String fotoPath= homePath+"\\Downloads\\Screenshot (6).png";
    boolean downloadEttiMi= Files.exists(Paths.get(fotoPath));
    Assert.assertTrue(downloadEttiMi);

}
}
