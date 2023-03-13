package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q7 {
    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin.
     */
    // BeforeClass ile driver'i olusturun ve class icinde static yapin
    //    Maximize edin ve 10 sn bekletin
   static  WebDriver  driver;
    WebElement searchBox;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions(); // bu ve alttaki satiri chrome hata verdigi icin
        options.addArguments("--remote-allow-origins=*"); // hatayı önlemek icin yazdım
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void before(){
        driver.get("http://www.google.com");
        searchBox=driver.findElement(By.xpath("//input[@class='gLFyf']"));
    }

        //    http://www.google.com adresine gidin
        //    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01(){
        searchBox.sendKeys("The Lord of the Rings"+ Keys.ENTER);
        System.out.println("sonuc1 : "+driver.findElement(By.id("result-stats")).getText());

    }

        //    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
        @Test
        public void test02(){


            searchBox.sendKeys("Brave Heart"+ Keys.ENTER);
            System.out.println("sonuc2 : "+driver.findElement(By.id("result-stats")).getText());

        }
        //    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
        @Test
        public void test03(){

            searchBox.sendKeys("Harry Potter"+ Keys.ENTER);
            System.out.println("sonuc3 : "+driver.findElement(By.id("result-stats")).getText());

        }
        //    AfterClass ile kapatin.
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
    }



