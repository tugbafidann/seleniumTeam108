package day02_webElementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        // 1.Yeni bir class olusturalim (Homework)
        //2.ChromeDriver kullanarak, facebook sayfasina gidin
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.
        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("facebook title testi PASSED");
        }else {
            System.out.println("facebook title testi FAILED"+
                                "\nGerceklesen Title : "+actualTitle);

        }
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.
        String expecteIcerik="facebook";
        String actualURL=driver.getCurrentUrl();
        if (actualURL.contains(expecteIcerik)){
            System.out.println("facebook url testi PASSED");
        }else {
            System.out.println("facebook Url testi FAILED"+
                              "\nGerceklesen Url : "+actualURL );
        }

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmarteExpecteIcerik="Walmart.com";
        String walmartActualTitle=driver.getTitle();
        if (walmartActualTitle.contains(walmarteExpecteIcerik)){
            System.out.println("Walmart title testi PASSED");
        }else {
            System.out.println("Walmart title testi FAILED");
        }
        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7. Sayfayi yenileyin
        driver.navigate().refresh();
        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //9.Browser’i kapatin
        driver.close();

    }
}
