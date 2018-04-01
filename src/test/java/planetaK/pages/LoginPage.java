package planetaK.pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoginPage extends BasePage {

//    private final AndroidDriver driver;
//
//    public LoginPage(AndroidDriver driver) {
//        this.driver = driver;
//       // PageFactory.initElements(driver, this);
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
//    }
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    private String email = "echornobai@intersog.com";
    private String password = "AndroidTest1";
    private String wrongPassword = "qwe";

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
        waitForElementDisplayed(emailField);
    }

    private void login (String pwd) {
        emailField.sendKeys(email);
        passwordField.sendKeys(pwd);
        loginButton.click();
    }

    public void successLogin() {
        login(password);
        waitForElementDisplayed(backButton);
        backButton.click();
        swipeRightToLeft(poster1, poster2);
        movieGallery.get(1).click();
        waitForElementDisplayed(movieTitle);
        System.out.println(movieTitle.getText());
        sleep(500);

    }

    public void failureLogin() {
        login(wrongPassword);

    }

    public void logout(){
        upButton.click();
        homeButton.click();
        accountButton.click();
        logoutButton.click();
    }



}



