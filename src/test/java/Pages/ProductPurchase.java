package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPurchase {
    WebDriver driver;

    @FindBy(css = "img")
    List<WebElement> productImage;

    @FindBy(xpath = "//button[@name ='add-to-cart'][contains(text(), 'Add to cart')]")
    WebElement btnCart;

    @FindBy(xpath ="//a[contains(text(), 'View cart')]" )
    List<WebElement> btnViewCart;

    @FindBy(xpath = "//a[contains(text(), ' Proceed to checkout')]")
    WebElement btnCheckout;

    @FindBy(xpath = "//select[@name='product_cat']")
    WebElement dropdown;

    @FindBy(xpath = "//button[@class='header-search-button']")
    WebElement search;

    @FindBy(xpath = "//h3[contains(text(), 'Billing details')]")
    WebElement lblBillingDetails;

    public ProductPurchase(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProduct(int pos) throws InterruptedException {
        productImage.get(pos).click();
    }

    public void addToCart(){
        btnCart.click();
    }

    public void viewCart(){
        btnViewCart.get(2).click();
    }

    public void proceedCheckout(){
        btnCheckout.click();
    }

    public void selectDropdown(){
        Select select = new Select(dropdown);
        select.selectByIndex(3);
    }

    public void searchProduct(){
        search.click();
    }

    public String performPurchase() throws InterruptedException {
        clickProduct(1);
        Thread.sleep(3000);

        addToCart();
        Thread.sleep(3000);

        viewCart();
        Thread.sleep(3000);

        proceedCheckout();

        return lblBillingDetails.getText();
    }

    public String performPurchaseFromDropDown() throws InterruptedException {
        selectDropdown();
        searchProduct();
        Thread.sleep(3000);

        clickProduct(3);
        Thread.sleep(3000);

        addToCart();
        Thread.sleep(3000);

        viewCart();
        Thread.sleep(3000);

        proceedCheckout();

        return lblBillingDetails.getText();

    }


}
