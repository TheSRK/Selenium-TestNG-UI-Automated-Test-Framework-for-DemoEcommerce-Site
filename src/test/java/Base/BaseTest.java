package Base;

import Pages.HomePage;
import Utils.BrowserManager;
import Utils.Constants;
import Utils.SuiteListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage homePage;


    @BeforeTest(groups = "shop")
    //@Parameters(value = {"browserName"})
    public void Setup(){
        BrowserManager.doBrowserSetup(Constants.browserName);
        //get URL
        driver.get(Constants.BaseUrl);
        homePage = new HomePage(driver);

    }

    /**
     * this method takes screenshot upon failed test
     */

    @AfterMethod(groups = "shop")
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
               SuiteListener suiteListener = new SuiteListener();
                suiteListener.onTestFailure(result);
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }



    @AfterTest(groups = "shop")
    public void logout(){
        driver.close();
    }



}
