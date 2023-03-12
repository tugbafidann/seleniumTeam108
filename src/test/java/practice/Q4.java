package practice;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {
    /* ...Exercise4...
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01(){

        // Şuraya git https://testpages.herokuapp.com/styled/index.html
        //        Mikro Uygulamalar altındaki Hesaplayıcıya tıklayın
        //        İlk girişe herhangi bir sayı yazın
        //        İkinci girişe herhangi bir sayı yazın
        //        Hesapla'ya tıklayın
        //        Sonucu al
        //        Sonucu yazdır
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        driver.findElement(By.id("number1")).sendKeys("456");
        driver.findElement(By.id("number2")).sendKeys("123");
        driver.findElement(By.id("calculate")).click();
        WebElement sonuc=driver.findElement(By.id("answer"));
        System.out.println("answer = " + sonuc.getText());






    }
}
