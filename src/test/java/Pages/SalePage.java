package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalePage {
    WebDriver driver;

    public SalePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
