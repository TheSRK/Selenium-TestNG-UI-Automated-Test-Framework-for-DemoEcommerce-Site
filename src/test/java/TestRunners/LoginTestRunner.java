package TestRunners;

import Base.BaseTest;
import Pages.Login;
import Utils.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends BaseTest {
    //@Test
    public void loginTest() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        Login login = new Login(driver);

        JsonReader jsonReader = new JsonReader(driver);
        jsonReader.readJSONArray(1);

        String user = login.doLogin(jsonReader.getEmail(), jsonReader.getPassword());
        Assert.assertEquals(user, "viva test");





    }
    @Test
    public void loginWithInvalidEmailTest() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        Login login = new Login(driver);
        JsonReader jsonReader = new JsonReader(driver);

        jsonReader.readJSONArray(1);

        String lblInvalidEmail = login.loginWithInvalidEmail(jsonReader.getEmail(), jsonReader.getPassword());
        Assert.assertEquals(lblInvalidEmail, "Invalid email address.");

    }

    @Test
    public void loginWithInvalidPasswordTest() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        Login login = new Login(driver);
        JsonReader jsonReader = new JsonReader(driver);

        jsonReader.readJSONArray(2);

        String lblInvalidPassword = login.loginWithInvalidPassword(jsonReader.getEmail(), jsonReader.getPassword());
        Assert.assertEquals(lblInvalidPassword, "Authentication failed.");
    }


}
