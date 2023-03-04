package pdfSorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class HandleDropdown extends TestBaseClass {

    @Test
    public void test01(){
       //       1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //        2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        bekle(2);
        //        3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        bekle(2);
        //        4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        bekle(2);
        //        5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();

        //        6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //        7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        //        8. “Currency” drop down menusunden Eurozoneu secin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByIndex(6);
        //        9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("456");
        //        10. “US Dollars” in secilmedigini test edin
        WebElement radio=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radio.isSelected());

        //        11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //             kontrol edin
        WebElement yazi=driver.findElement(By.id("alert_content"));
        Assert.assertTrue(yazi.isDisplayed());
    }


}
