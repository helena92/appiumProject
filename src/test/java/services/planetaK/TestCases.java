package services.planetaK;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.AppiumTestBase;
import services.planetaK.pages.LoginPage;


@Test(groups = "loginGroup")
public class TestCases extends AppiumTestBase {

    private LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    protected void initPages() {
        loginPage = new LoginPage(driver);
        System.out.println("Login Page is initialized");
    }

    @BeforeClass( groups = {"loginGroup"})
    protected void loginPreparation() {
        loginPage.openLoginPage();
    }

    @Test(description = "Failure Login to Planeta Kino App", groups = {"loginGroup"}, priority = 1)
    protected void failureLoginTest() {
        loginPage.failureLogin();
    }

    @Test(description = "Successful Login to Planeta Kino App", groups = {"loginGroup"}, priority = 2)
    protected void successLoginTest() {
        loginPage.successLogin();
    }

    @Test(description = "Search Gallery Movies", groups = {"galleryGroup"}, priority = 3)
    protected void openGalleryMovieTest() {
        loginPage.openGalleryMovie();
    }

}
