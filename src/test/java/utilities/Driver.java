package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ConfigReader;

import java.time.Duration;

public class Driver {


    private Driver(){

    }

    /* Daha fazla kontrol imkani ve extends kullanmadan driver'a ulasmak icin
       webDriver objesini Driver class'indaki static bir method ile olusturacagiz
      Ancak getDriver() her kullanildiginda yeni bir driver olusturuyor
      bunu engellemek ve kodumuzun duzgun calismasini saglamak icin
      ilk kullanimda  driver= new ChromeDriver(); kodu calissin
      sonraki kullanimlarda calismasin diye bir yontem gelistirmeliyiz
     */

    static WebDriver driver;
    static ChromeOptions ops = new ChromeOptions();

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    ops.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);

                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();


            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // driver'a deger atanmissa
            driver.close();
            driver = null;
        }
    }
}