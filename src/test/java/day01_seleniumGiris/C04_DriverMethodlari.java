package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        System.out.println(driver.getWindowHandle());
       // CDwindow-1C2A2FCAFB5BA5E44D08B2E0C669E6AE
        // getWindowHandle selenium tarafindan her driver sayfasi icin uretilen
        // unique handle degerini döndürür
        // getWindowHandels() ise test sirasinda birden fazla sayfa acilmissa
        // bir set olarak, tum sayfalarin window handle degerlerini döndürür

        // System.out.println(driver.getPageSource());

        // sayfa kodlari "2 hours weekly meeting with the team" iceriyor mu test edin
        String expectedIcerik="display";
        String actualSayfaKodlari=driver.getPageSource();
        if (actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAİLED");
        }




        driver.quit();
        // close() ve quit() ikisi de sayfa kapatmak icin kullanilir
        // close() sadece bir sayfa kapatirken
        // quit() test sirasinda acilan tum sayfalari kapatir
    }
}
