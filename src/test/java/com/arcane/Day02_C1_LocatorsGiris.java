package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_C1_LocatorsGiris {
/* user story
Bir class olustur : LocatorsGiris
Main method olustur ve asagidaki gorevi (task) yap.
Kullanici "https://www.testyou.in/Login.aspx" gider
username textbox, password textbox, and signin button icin locator bul
Kullanici adi and password'i gir ve sign in button click et
Username : aykut.arcanedata@gmail.com
Password : Aykut123!
Kullanici adini verify et (USE getText() method to get the text from the page)
Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
Sayfada bulunan toplam link sayisini bul
Sayfadan log out yapiniz
Logged out basarili oldugunu verify edin
 */
    WebDriver chrome;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chrome=new ChromeDriver();
        chrome.manage().window().maximize();
    }

@Test
    public void locatorGiris(){
        chrome.get("https://www.testyou.in/Login.aspx");

        //kullanıcı adını locate ettik ve kullanıcı adını gönderdik
//        WebElement emailBox= chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
//        emailBox.sendKeys("aykut.arcanedata@gmail.com");

        chrome.
                findElement(By.id("ctl00_CPHContainer_txtUserLogin")).
                sendKeys("aykut.arcanedata@gmail.com");

        // password için yapalım
        chrome.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("Aykut123!");

        //sing in butonunu locate et ve tıkla (click yap)
        chrome.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();

        //kullanıcı adını verify et
        WebElement kullaniciAdi= chrome.findElement(By.id("ctl00_headerTopStudent_username"));
        String kullaniciAdiText= kullaniciAdi.getText();

    //getText() WebElemet in kendisini String olarak döndürür
    System.out.println(kullaniciAdiText);
    String expectedKullaniciAdi="Aykutsaglam ,";
    Assert.assertEquals(expectedKullaniciAdi,kullaniciAdiText);

    //Home sekmesinin sayfada gosterildigini dogrula/verify et
    WebElement homeElement= chrome.findElement(By.linkText("Home"));
//    WebElement homeElement1= chrome.findElement(By.partialLinkText("ome"));

    //LinkTesxt ile partialLinkText() arasındaki farklar
    /*LinkText() MUTLAKA text veya metnini tamamını bosluk  ve noktalama işaretleri dahil yazmak lazım
    partialLinkText() metnin/text in tamamını yazabildiğiniz gibi bir kısmını da yazabilirsininz
    linkText daha güvenlidir çünkü bütün metni eksiksiz ekledigimizde yanlış yapma olasılığı azalır
     */

    Assert.assertTrue(homeElement.isDisplayed());

    //isDisplayed() bir elementin sayfada bulunup bulunmadğını dogrular
    //return type boolean dır

    //log out sekmelerinin sayfada gosterildigini dogrula/verify et
    WebElement logoutElement= chrome.findElement(By.className("signout"));
    Assert.assertTrue(logoutElement.isDisplayed());

    //Sayfada bulunan toplam link sayisini bul
    // Linkler "a" tag ile oluşturulur dolayısıyla butun "a" tag ile oluşturulan elementeleri bulursam tüm linkleri bulmuş olurum
    List<WebElement> tumLinkler= chrome.findElements(By.tagName("a"));
    int linkSayisi= tumLinkler.size();
    System.out.println("Tum linklerin sayisi: "+linkSayisi);

    //Sayfadan log out yapiniz
    chrome.findElement(By.className("signout")).click();

    //logged out yapıldığını verify et
    Boolean loggedOut= chrome.getCurrentUrl().equals("http://testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx%3faction%3dlogout&action=logout");
    Assert.assertTrue(loggedOut);
}
@After
    public void tearDown(){
 //       chrome.close();
}
}
