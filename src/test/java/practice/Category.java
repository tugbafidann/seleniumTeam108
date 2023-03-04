package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Category {
    /*
        1- Bir test class’i olusturun ilgili ayarlari yapin
        2- https://www.automationexercise.com/ adresine gidin
        3- Category bolumundeki elementleri locate edin
        4- Category bolumunde 3 element oldugunu test edin
        5- Category isimlerini yazdirin
        6-sayfayı kapatın
        */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01(){
        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");
        //        3- Category bolumundeki elementleri locate edin
       List<WebElement> categoryList=driver.findElements(By.xpath("//div[@class='panel panel-default']"));
        //        4- Category bolumunde 3 element oldugunu test edin
        int expectedCategory=3;
        int actualCategory=categoryList.size();
        Assert.assertTrue(actualCategory==expectedCategory);
      if(actualCategory==expectedCategory)
            System.out.println("Category testi PASSED ");
        else {
            System.out.println("Category testi FAİLED");
            System.out.println("Category size : "+categoryList.size());
        }
        //        5- Category isimlerini yazdirin
        int elementNo=1;
        for (WebElement each:categoryList
             ) {
            System.out.println(elementNo+" - "+each.getText());
            elementNo++;
        }

    }


}
