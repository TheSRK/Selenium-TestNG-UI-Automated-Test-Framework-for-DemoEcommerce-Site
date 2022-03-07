import org.testng.annotations.Test;

public class LoginTestRunner extends Setup{
    @Test
    public void loginTest(){
        Login login = new Login(driver);
        login.doLogin("test_viva@test.com", "123456");

    }
}
