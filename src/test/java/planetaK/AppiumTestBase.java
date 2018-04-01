package planetaK;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AppiumTestBase {

    protected AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        File filePath = new File(System.getProperty("user.dir"));
        File appDir = new File(filePath, "/bin");
        File app = new File(appDir, "planeta.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.FULL_RESET, "true");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
