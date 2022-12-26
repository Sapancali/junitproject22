package com.arcane.tests;

import com.arcane.utilities.TestBase;

import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_C25_Cookies extends TestBase {
/*
    Method: handleCookies
    -Amazon'a (https://www.amazon.com) git and tasks automate et
    1. Toplam cookies sayisini bul
    2. Tum cookies yazdir
    3. Cookies isimleriyle yazdir
    4. Yeni cookie ekle
    5. Cookie ismiyle sil
    6. Tum cookies sil
    */
@Test
    public void handleCookies(){
    driver.get("https://www.amazon.com");

//    1. Toplam cookies sayisini bul
    Set<Cookie> tumCookies= driver.manage().getCookies();
    System.out.println(tumCookies);
    int cookieSayisi=tumCookies.size();
    System.out.println(cookieSayisi);

//    2. Tum cookies yazdir
    for(Cookie herbirEleman : tumCookies){
        System.out.println("Cookie ismi: "+herbirEleman.getName());
        System.out.println("Cookie value: "+herbirEleman.getValue());
    }

//    3. Cookies isimleriyle yazdir
    System.out.println("Cookie ismi session-id-time olan cookie "+ driver.manage().getCookieNamed("session-id-time"));

//    4. Yeni cookie ekle
    Cookie cookieEkle = new Cookie("Favori Kekim","incirli ");
    //cookie ekle
//    driver.manage().addCookie(cookieEkle);

    //tüm cookileri al ve sayısını yazdır
 //   tumCookies=driver.manage().getCookies();
 //   System.out.println(tumCookies);

//    5. Cookie ismiyle sil
    driver.manage().deleteCookieNamed("skin");
    tumCookies=driver.manage().getCookies();
    System.out.println(tumCookies.size());

//    6. Tum cookies sil
    driver.manage().deleteAllCookies();
    tumCookies=driver.manage().getCookies();
    System.out.println(tumCookies.size());

}
}
