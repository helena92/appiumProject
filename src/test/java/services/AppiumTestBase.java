package services;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestBase {

    protected AndroidDriver driver;

    @Parameters("appPath")
    @BeforeTest(alwaysRun = true)
    public void setUp(String appPath) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        File app = new File(appPath);
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel");
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //caps.setCapability(MobileCapabilityType.FULL_RESET, "true");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Tools.setDriver(driver);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
