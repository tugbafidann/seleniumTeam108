package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Q1 {
        /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/
    Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */
        public static void main(String[] args) {
            //Set Path
            // System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
            // Ust satirda sisteme dirverimizi tanitiyoruz. Driver yolunu da gösteriyoruz

            //Create chrome driver
            WebDriver driver=new ChromeDriver();

            //Maximize the window
            driver.manage().window().maximize();

            //Open google home page https://www.google.com/.
            driver.get("https://www.google.com");
            /*
            Driver get daha hızli
            Driver.navigate.to ==>Birbirine bagımlı olaylarda kullanılır
             */

            //On the same class, Navigate to amazon home page https://www.amazon.com/
            driver.navigate().to("https://www.amazon.com");

            //Navigate back to google
            driver.navigate().back();

            //Navigate forward to amazon
            driver.navigate().forward();

            //Refresh the page
            driver.navigate().refresh();

            //Close/Quit the browser
            driver.quit();
            /*
            Close: Sadece oldugumuz sayfayı kapatir
            Quit : Bütün hepsini kapatır
             */
            System.out.println("All OK");


        }
}
