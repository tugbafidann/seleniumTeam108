package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions(); // bu ve alttaki satiri chrome hata verdigi
        options.addArguments("--remote-allow-origins=*"); // icin hatayi önlemek icin yazdım
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() throws InterruptedException {
        driver.quit();
    }

    public void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {

        }
    }
}
