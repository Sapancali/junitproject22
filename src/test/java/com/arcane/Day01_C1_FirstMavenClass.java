package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_C1_FirstMavenClass {
    public static void main(String[] args) {
        //System.setProperty("driver Type", "Driver Path'i" kullanılmayacak

        //chrome driver i set et
        WebDriverManager.chromedriver().setup();

        // driver objesi oluştur
        WebDriver driver=new ChromeDriver();

        // ekranı kapla
        driver.manage().window().maximize();

        //amazon a git
        driver.get("https:/www.amazon.com");

        //browser kapat
        driver.close();
    }
}
