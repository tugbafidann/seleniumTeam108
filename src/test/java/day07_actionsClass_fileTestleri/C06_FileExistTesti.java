package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C06_FileExistTesti extends TestBase {
    // 2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. logo.png dosyasını indirelim
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    @Test
    public void test01(){
        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. Image.PNG dosyasını indirelim
        driver.findElement(By.linkText("Image.PNG")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        bekle(5); // dosyanın inmesi icin belli bir süreye ihtiyac var

        // dosya dowlands a ineceği icin dinamik dosya yolu olusturacagız
        String dinamikDosyaYolu=System.getProperty("user.home")+"/Downloads/Image.PNG";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
