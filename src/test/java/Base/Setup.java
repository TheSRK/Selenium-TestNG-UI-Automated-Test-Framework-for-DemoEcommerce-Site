package Base;

import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeTest(groups = "purchase")
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");

        driver = new ChromeDriver(ops);
        //driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod(groups = "purchase")
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils(driver);
                util.takeScreenshot();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }



    @AfterTest(groups = "purchase")
    public void logout(){
        driver.close();
    }
}
