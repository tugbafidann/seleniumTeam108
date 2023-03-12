package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions(); // bu ve alttaki satiri chrome hata verdigi icin
        options.addArguments("--remote-allow-origins=*"); // hatayı önlemek icin yazdım
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
    public void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {

        }
    }
}
