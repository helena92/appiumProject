package services.planetaK.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.PageFactory;
import services.Tools;
import services.planetaK.PlanetaKVars;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginPage {

    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    @WithTimeout(time = 20, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "button_cabinet_f")
    private MobileElement userProfile;

    @AndroidFindBy(id = "email")
    private MobileElement emailField;

    @AndroidFindBy(id = "password")
    private MobileElement passwordField;

    @AndroidFindBy(id = "login_button")
    private MobileElement loginButton;

    @AndroidFindBy(id = "logout_button")
    private MobileElement logoutButton;

    @AndroidFindBy(accessibility = "Планета Кіно, Перейти вгору")
    private MobileElement backButton;

    @AndroidFindBy(xpath = ".//*[@instance=24]")
    private MobileElement poster1;

    @AndroidFindBy(xpath = ".//*[@instance=22]")
    private MobileElement poster2;

    @AndroidFindBy(id = "movie_poster")
    private List<MobileElement> movieGallery;

    @AndroidFindBy(id = "movieTitle")
    private MobileElement movieTitle;

    @AndroidFindBy(id = "home")
    private MobileElement homeButton;

    @AndroidFindBy(id = "button_cabinet_menu")
    private MobileElement accountButton;

    @AndroidFindBy(id = "up")
    private MobileElement upButton;


    public void openLoginPage() {
        userProfile.click();
        Tools.waitForElementDisplayed(emailField);
    }

    private void login(String pwd) {
        emailField.sendKeys(PlanetaKVars.EMAIL);
        passwordField.sendKeys(pwd);
        loginButton.click();
    }

    public void successLogin() {
        login(PlanetaKVars.PASSWORD);
        Tools.waitForElementDisplayed(backButton);
    }

    public void openGalleryMovie() {
        backButton.click();
        Tools.swipeElems(poster1, poster2);
        movieGallery.get(1).click();
        Tools.waitForElementDisplayed(movieTitle);
        System.out.println(movieTitle.getText());
    }

    public void failureLogin() {
        login(PlanetaKVars.WRONG_PASS);
    }

    public void logout() {
        upButton.click();
        homeButton.click();
        accountButton.click();
        logoutButton.click();
    }

}



