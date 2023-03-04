package pdfSorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe extends TestBase {
    // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //(https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Test
    public void test01(){
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home");

        //2) sayfadaki iframe sayısını bulunuz.
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frameElementi= driver.findElement(By.xpath("//iframe[@wmode='transparent'] "));
        driver.switchTo().frame(frameElementi);
        driver.findElement(By.xpath(
                "//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"))
                .click();
        //
        bekle(3);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        bekle(3);

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement frameElementi2= driver.findElement(By.name("a077aa5e"));
        driver.switchTo().frame(frameElementi2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        bekle(3);
    }
}
