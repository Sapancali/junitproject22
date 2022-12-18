package Bana_Ozel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class deneme {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void biseyDene() {
       driver.get("https://www.coinpayu.com/login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).
              sendKeys("ustabona@gmail.com");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Muzaffer1mustafa.");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[3]/div[1]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();



        }

}
