import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginTestRunner extends Setup{
    @Test
    public void loginTest() throws IOException, ParseException {
        Login login = new Login(driver);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONObject jsonObject = (JSONObject) obj;

        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");

        String user = login.doLogin(email, password);
        Assert.assertEquals(user, "viva test");

    }
}
