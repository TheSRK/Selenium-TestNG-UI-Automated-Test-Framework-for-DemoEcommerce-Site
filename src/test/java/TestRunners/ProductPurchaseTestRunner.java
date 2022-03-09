package TestRunners;

import Base.Setup;
import Pages.ProductPurchase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPurchaseTestRunner extends Setup {


    @Test(priority = 0, enabled = true, groups = "purchase")
    public void testProductPurchase() throws InterruptedException {
        ProductPurchase productPurchase = new ProductPurchase(driver);
        driver.get("https://envothemes.com/envo-ecommerce/");
        String text = productPurchase.performPurchase();
        Assert.assertEquals(text,"Billing details");
    }

    @Test(priority = 1, groups = "purchase")
    public void testProductPurchaseFromDropdown() throws InterruptedException {
        ProductPurchase productPurchase = new ProductPurchase(driver);
        driver.get("https://envothemes.com/envo-ecommerce/");
        String text = productPurchase.performPurchaseFromDropDown();
        Assert.assertEquals(text,"Billing details");
    }
}
