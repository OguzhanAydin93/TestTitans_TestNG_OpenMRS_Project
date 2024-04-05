package Utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver {

    public static Logger logger = LogManager.getLogger();

    public static WebDriverWait wait;
    public static WebDriver driver;


    @BeforeClass(groups = {"Smoke","Login Test","Logout Testing","Regression","Patient Management Testing","Appointment Testing"})
    @Parameters("browserTipi")
    public void BaslangicIslemleri(String browserTipi) {

        switch (browserTipi.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }



            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));



    }

        @AfterClass(groups = {"Smoke","Login Test","Logout Testing","Regression","Patient Management Testing","Appointment Testing"})
        public void KapanisIslemleri () {
            MyFunc.bekle(3);
            driver.quit();

            logger.info("Driver kapatıldı");
        }

        @BeforeMethod
        public void BeforeMetod () {
            logger.info("Metod başladı");

            logger.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
        }

        @AfterMethod
        public void AfterMetod (ITestResult sonuc){
            logger.info(sonuc.getName() + " Metod bitti " + (sonuc.getStatus() == 1 ? "Passed" : "failed"));

            logger.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
        }
    }
