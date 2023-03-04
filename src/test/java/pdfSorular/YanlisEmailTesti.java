package pdfSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class YanlisEmailTesti extends TestBase {
    //1. Bir Class olusturalim YanlisEmailTesti
    //2. https://www.amazon.com sayfasina gidelim
    //3. Sign in butonuna basalim
    //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
    //email address” uyarisi ciktigini test edelim
   @Test
    public void yanlisEmailTesti(){
       //1. Bir Class olusturalim YanlisEmailTesti
       //2. http://automationpractice.com/index.php sayfasina gidelim
       // http://www.amazon.com
       driver.get("http://www.amazon.com");
       //3. Sign in butonuna basalim
       driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
       //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “There was
       //a problem” uyarisi ciktigini test edelim

       WebElement emailBox=driver.findElement(By.id("ap_email"));
       emailBox.sendKeys("tugba45gmail.com"+ Keys.ENTER);
       WebElement uyari= driver.findElement(By.xpath("//span[@class='a-list-item']"));
       Assert.assertTrue(uyari.isDisplayed());
       bekle(3);

   }


}
