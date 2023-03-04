package practice1.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup(); // choremdriver olusturuyoruz
        WebDriver driver=new ChromeDriver(); // kullanicak oldugum driveri chrome üzerinde kullanıyoruz
                                             // diye belirtiyoruz


    }

    @Test
    public void test01(){

    }
    @After
    public void tearDown(){

    }
}
