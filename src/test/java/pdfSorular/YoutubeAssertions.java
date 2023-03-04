package pdfSorular;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeAssertions {
     /* Assertions
1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının "YouTube" oldugunu test edin
○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            ○ wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin*/
    static WebDriver driver;
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
    public void test01() {
        driver.get("https://www.youtube.com");
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //○ titleTest => Sayfa başlığının "YouTube" oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin



    @Test
    public void test02(){
        WebElement image= driver.findElement(By.xpath("//yt-icon[@class='style-scope ytd-logo'][1]"));
        Assert.assertTrue(image.isDisplayed());
    }
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void test03(){
        WebElement searchBox=driver.findElement(By.id("search-input"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    // ○ wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
    @Test
    public void test04(){
        String expectedWrongTitle="youtube";
        String actualWrongTitle=driver.getTitle();
        Assert.assertNotEquals(expectedWrongTitle,actualWrongTitle);

    }
}
