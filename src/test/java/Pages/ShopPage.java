package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(), 'Shop')]")
    WebElement txtShop;

    public ShopPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * this method will get shop text
     * @param
     * @return String shop text
     */

    public String getTxtShop(){
        return txtShop.getText();
    }


}
