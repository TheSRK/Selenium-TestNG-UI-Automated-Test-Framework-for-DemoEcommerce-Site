package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Shop')]")
    WebElement txtMainMenuShop;

    @FindBy(xpath = "//a[@title='Sale'][contains(text(), 'Sale')]")
    WebElement txtMainMenuSale;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * this method will click Shop from the menu
     */

    public boolean clickShopFromMenu(){
        //click shop
        txtMainMenuShop.click();
        return true;
    }

    /**
     * this method will click Sale from the menu
     */

    public boolean clickSaleFromMenu(){
        //click sale
        txtMainMenuSale.click();
        return true;

    }
}
