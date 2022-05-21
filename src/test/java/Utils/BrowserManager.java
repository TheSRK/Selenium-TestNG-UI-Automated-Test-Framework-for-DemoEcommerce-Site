package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import static Base.BaseTest.driver;

import java.time.Duration;

public class BrowserManager {
//    WebDriver driver;
//
//    public BrowserManager(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
    public static void doBrowserSetup(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            //steup chrome browser
            //System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);


            /**
             * Add options for --headed or --headless browser launch
             *
             */
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(Constants.browserMode);

            //initialize driver for chrome
            driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            //maximize window
            driver.manage().window().maximize();


            //add implicit timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.waitTime));


        }
        else if (browserName.equalsIgnoreCase("firefox")){
            //setup firefox browser
            //System.setProperty("webdriver.gecko.driver",Constants.firefoxDriverPath);

            /**
             * Add options for --headed or --headless browser launch
             *
             */
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(Constants.browserMode);

            //initialize driver for firefox
            driver = WebDriverManager.firefoxdriver().capabilities(firefoxOptions).create();

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.waitTime));
        }
        else {
            //setup chrome browser by default
            System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");

            /**
             * Add options for --headed or --headless browser launch
             *
             */
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(Constants.browserMode);

            //initialize driver for chrome
            driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();

            //maximize window
            driver.manage().window().maximize();

            //add implicit timeout
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.waitTime));

        }
    }


}
