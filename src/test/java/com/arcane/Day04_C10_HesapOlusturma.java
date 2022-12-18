package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_C10_HesapOlusturma {
    /*
    Zorunlu tum alanlari doldurun ve Hesap olusturmanin basarili oldugunu verify edin
1. Create a class HesapOlusturma
2. Go to https://www.automationexercise.com/
3. Signup/Login link'ine click edin
4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
5. Text'i Verify et : ENTER ACCOUNT INFORMATION
6. Text'i Verify et : ADDRESS INFORMATION
7. Text'i Verify et : Title
8. title'i secin
9. Name girin (var olani degistir)
10. Password girin
11. Date of Birth (dogum tarihi) girin
12. Sign up for our newsletter! click edin
13. Receive special offers from our partners! click edin
14. first name girin
15. last name girin
16. company girin
17. Address girin
18. Country secin
19. State girin
20. City girin
21. ZipCode girin
22. mobile phone girin
23. Create Account'u Click edin
24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
     */
//    2. Go to https://www.automationexercise.com/
    WebDriver driver;
    Faker faker=new Faker();
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void hesapOlusturma(){
        driver.get("https://www.automationexercise.com");
//            3. Signup/Login link'ine click edin
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Login")).click();
//            4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[.='Signup']")).click();
//            5. Text'i Verify et : ENTER ACCOUNT INFORMATION
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Enter Account Information']")).isDisplayed());
//            6. Text'i Verify et : ADDRESS INFORMATION
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Address Information']")).isDisplayed());
//            7. Text'i Verify et : Title
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Title']")).isDisplayed());
//            8. title'i secin
        WebElement bay= driver.findElement(By.xpath("//input[@value='Mr']"));
        if(!bay.isSelected()){
            bay.click();
        }
//            9. Name girin (var olani degistir)
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(faker.name().fullName());
//10. Password girin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(faker.internet().password());
//11. Date of Birth (dogum tarihi) girin
        //gun
        WebElement gun= driver.findElement(By.xpath("//select[@name='days']"));
        Select gunDropDown=new Select(gun);
        gunDropDown.selectByValue("17");
        //ay
        WebElement ay= driver.findElement(By.xpath("//select[@name='months']"));
        Select ayDropDown=new Select(ay);
        ayDropDown.selectByVisibleText("November");
        //yıl
        WebElement yil= driver.findElement(By.xpath("//select[@name='years']"));
        Select yilDropDown=new Select(yil);
        yilDropDown.selectByVisibleText("1990");
//12. Sign up for our newsletter! click edin
        WebElement newsletter= driver.findElement(By.xpath("//input[@id='newsletter']"));
        if(!newsletter.isSelected()){
            newsletter.click();
        }
//13. Receive special offers from our partners! click edin
        WebElement offers= driver.findElement(By.xpath("//input[@id='optin']"));
        if(!offers.isSelected()){
            offers.click();
        }
//14. first name girin
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
//15. last name girin
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());
//16. company girin
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
//17. Address girin
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
//18. Country secin
        WebElement ulke= driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDropDown=new Select(ulke);
        countryDropDown.selectByVisibleText("Canada");
//19. State girin
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
//20. City girin
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
//21. ZipCode girin
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
//22. mobile phone girin
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());
//23. Create Account'u Click edin
        driver.findElement(By.xpath("//*[.='Create Account']")).click();
//            24. Ardindan ACCOUNT CREATED!'un sayfada bulundugunuzu verifey edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Account Created!']")).isDisplayed());
    }
    @After
    public void tearDown(){
        driver.close();
    }

}
