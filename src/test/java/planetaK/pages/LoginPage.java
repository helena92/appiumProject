package planetaK.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.PageFactory;
import planetaK.Tools;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginPage {

    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    private final String email = "echornobai@intersog.com";
    private final String password = "AndroidTest1";
    private final String wrongPassword = "qwe";

    @WithTimeout(time = 20, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "button_cabinet_f")
    private MobileElement userProfile;

    //resource-id
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
        emailField.sendKeys(email);
        passwordField.sendKeys(pwd);
        loginButton.click();
    }

    public void successLogin() {
        login(password);
        Tools.waitForElementDisplayed(backButton);
        backButton.click();
        Tools.swipeElems(poster1, poster2);
        movieGallery.get(1).click();
        Tools.waitForElementDisplayed(movieTitle);
        System.out.println(movieTitle.getText());
        // Tools.sleep(500);
    }

    public void failureLogin() {
        login(wrongPassword);
    }

    public void logout() {
        upButton.click();
        homeButton.click();
        accountButton.click();
        logoutButton.click();
    }

}



