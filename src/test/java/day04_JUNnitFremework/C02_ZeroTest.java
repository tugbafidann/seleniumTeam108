package day04_JUNnitFremework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {
        //1. http://zero.webappsecurity.com sayfasina gidin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        //3. Login alanine  “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in butto8nuna tiklayin
        driver.findElement(By.name("submit")).click();
        //6. Pay Bills sayfasina tiklayin
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //driver.findElement(By.linkText("//*[text()='Pay Bills']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("5000");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement payment= driver.findElement(By.id("alert_content"));
        if (payment.isDisplayed()){
            System.out.println("Payment testi PASSED");
        }else {
            System.out.println("Payment testi FAİLED");
        }

        Thread.sleep(3000);
        driver.close();
    }

}
