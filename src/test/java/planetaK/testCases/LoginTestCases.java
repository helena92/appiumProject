package planetaK.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import planetaK.AppiumTestBase;
import org.testng.annotations.Test;
import planetaK.pages.LoginPage;


@Test(groups = "loginGroup")
public class LoginTestCases extends AppiumTestBase {

    protected static LoginPage loginPage;

    @BeforeTest()
    protected void initLoginPage() {
        loginPage = new LoginPage(driver);
        System.out.println("Login Page is initialized");
    }

    @BeforeClass()
    protected void loginPreparation() { loginPage.openLoginPage(); }

    @Test(description = "Failure Login to Planeta Kino App", groups = { "loginGroup" }, priority = 1)
    protected void failureLoginTest() { loginPage.failureLogin(); }

    @Test(description = "Successful Login to Planeta Kino App", groups = { "loginGroup" }, priority = 2)
    protected void successLoginTest() { loginPage.successLogin(); }

    @AfterClass(groups = {"OneDriveFilesGroup"})
    protected void logout(){ loginPage.logout(); }

}
