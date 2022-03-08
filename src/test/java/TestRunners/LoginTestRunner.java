package TestRunners;

import Base.Setup;
import Pages.Login;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    //@Test
    public void loginTest() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        Login login = new Login(driver);

        Utils utils = new Utils(driver);
        utils.readJSONArray(0);

        String user = login.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(user, "viva test");





    }
    @Test
    public void loginWithInvalidEmailTest() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        Login login = new Login(driver);
        Utils utils = new Utils(driver);

        utils.readJSONArray(1);

        String lblInvalidEmail = login.loginWithInvalidEmail(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(lblInvalidEmail, "Invalid email address.");

    }

    @Test
    public void loginWithInvalidPasswordTest() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        Login login = new Login(driver);
        Utils utils = new Utils(driver);

        utils.readJSONArray(2);

        String lblInvalidPassword = login.loginWithInvalidPassword(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(lblInvalidPassword, "Authentication failed.");
    }


}
