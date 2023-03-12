package day09_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_JavascriptExecutorClick extends TestBase {
    // wisequarter anasayfaya gidelim
    // Java Test Automation tanitimina kadar asağı inin
    // ve resmi click yapin
    // ekrana "JUnit bitti" yazdirin
    @Test
    public void test01(){
        // wisequarter anasayfaya gidelim
        driver.get("https://wisequarter.com");
        /*      eger reklam cikarsa
            driver.navigate().refresh();
                  yazıp sayfa yenilenince reklamı engelleriz
         */

        // Java Test Automation tanitimina kadar asağı inin
        WebElement otomasyonElementi= driver.findElement(By.xpath
                 ("//img[@class='attachment-ecademy_810x545 size-ecademy_810x545 wp-image-6287']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;// driver'i casting yapmamız gerekiyor

        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElementi);

        // ve resmi click yapin ?
        bekle(2);
        jse.executeScript("arguments[0].click();",otomasyonElementi);

        // ekrana "JUnit bitti" yazdirin
        bekle(2);
        jse.executeScript("alert('JUnit Bitti');");

        bekle(3);
    }
}
