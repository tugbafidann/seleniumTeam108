package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {

    /* ...Exercise2...
 1 - Java class'imiza chromedriver.exe'yi tanitalim
 2 - Driver olusturalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) {
        //1 - Java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        //2 - Driver olusturalim
        WebDriver driver=new ChromeDriver();
        //  3 - Driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        //4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
        //     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        /*
        Thread.sleep(10000);
        Aralarındaki fark :
            - implicitlyWait selenium özelliklerinden gelir. En fazla 10 sn bekler 10 den önce başlarsa
        devam eder çalışmaya
            - Thread.sleep: java tabanlıdır. Burada kesin 10 sn bekler. Açılsa bile islem yapmak icin
        10 sn tamamlanana kadar beklemeye devam eder
         */
        // 5 - "https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");
        // 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String ottoTitle=driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);
        String ottoUrl=driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);
        // 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
       if(ottoTitle.contains("OTTO") && ottoUrl.contains("OTTO")){
           System.out.println("OTTO yazisi iceriyor");
       }else {
           System.out.println("OTTO yazisi icermiyor");
       }
        // 8 - Ardindan "https://wisequarter.com/" adresine gidelim
        driver.navigate().to("https://wisequarter.com");
        // 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
        //     kontrol edelim
        String wqTitle= driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);

        boolean isTrue=wqTitle.contains("Quarter");
        if (isTrue){
            System.out.println("test PASSED");
        }else {
            System.out.println("test FAİLED ");
        }
        // 10- Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        // 11- Sayfayi yenileyelim
        driver.navigate().refresh();
        // 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().back();
        driver.close();
        // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }
}
