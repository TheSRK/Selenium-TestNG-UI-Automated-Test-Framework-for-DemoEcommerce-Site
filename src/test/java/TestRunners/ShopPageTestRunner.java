package TestRunners;

import Base.BaseTest;
import Pages.HomePage;
import Pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopPageTestRunner extends BaseTest {


    String txtShop;

    @Test(groups = "shop")
    public void testShopPageHeader(){
        ShopPage shopPage = new ShopPage(driver);
        Boolean flag = homePage.clickShopFromMenu();
        if(flag==true){
            txtShop = shopPage.getTxtShop();
            Assert.assertEquals(txtShop, "Shop");
        }
        else {
            System.out.println("clickShopFromMenu retuned false");
        }


    }
}
