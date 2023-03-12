package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Antartica
    choose your command  -> Browser Commands
    click submit button
 */
    static  WebDriver driver;
   @BeforeClass
   public static void setup(){
       WebDriverManager.chromedriver().setup();
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
      // url'ye git: https://www.techlistic.com/p/selenium-practice-form.html
       driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
       // ilk adı doldur
       driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Tuğba");
       // soyadını doldur
       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Fidan");
       // cinsiyeti kontrol et
       driver.findElement(By.id("sex-1")).click();
       // deneyimi kontrol edin
       driver.findElement(By.id("exp-6")).click();
       // tarihi doldur
       driver.findElement(By.id("datepicker")).sendKeys("12.12.2022");
       // mesleğinizi seçin -> Otomasyon Test Cihazı
       driver.findElement(By.xpath("//input[@id='profession-1']")).click();
       // aracınızı seçin -> Selenyum Web Sürücüsü
       driver.findElement(By.xpath("//input[@id='tool-2']")).click();
       // kıtanızı seçin -> Antartika
     /*  WebElement ddm=driver.findElement(By.xpath("//select/[@id='continents']"));
       Select select=new Select(ddm);
       select.selectByVisibleText("Antartica");*/

       driver.findElement(By.id("continents")).click();
       WebElement dropdown = driver.findElement(By.id("continents"));
       dropdown.findElement(By.xpath("//option[. = 'Antartica']")).click();



       // komutunuzu seçin -> Tarayıcı Komutları
       // gönder düğmesine tıklayın
   }


}
