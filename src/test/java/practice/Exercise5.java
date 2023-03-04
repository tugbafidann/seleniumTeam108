package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Exercise5 {
    // .......Exercise5........
    /*
    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
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
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test1(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[text()='Alerts']")).click();
        System.out.println("Url alerts : "+driver.getCurrentUrl());
        // navigate back
        driver.navigate().back();
        //    print the URL
        System.out.println("Url index :"+driver.getCurrentUrl());
        //    Click on Basic Ajax
        driver.findElement(By.id("basicajax")).click();

        //    print the URL
        System.out.println("Url basicajax : "+driver.getCurrentUrl());
        //    enter value 20 and ENTER
        WebElement enterValue=driver.findElement(By.id("lteq30"));
        enterValue.sendKeys("20"+ Keys.ENTER);
        //    and then verify Submitted Values is displayed open page
        WebElement submit= driver.findElement(By.xpath("//*[text()='Submitted Values']"));
        Assert.assertTrue(submit.isDisplayed());
       /* if (submit.isDisplayed()){
            System.out.println("Submit displayed testi PASSED");
        }else{
            System.out.println("Submit displayed testi FAİLED");
        }*/

        //    close driver





    }




}
