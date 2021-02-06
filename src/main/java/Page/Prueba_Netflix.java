package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Utilities;

import java.io.File;

public class Prueba_Netflix {
    public WebDriver driver;
    public static File resourcesDirectory = new File("src/main/resources");

    @BeforeMethod
    public void inicio() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // windows
        System.setProperty("webdriver.chrome.driver", resourcesDirectory + "\\driver\\windows\\chromedriver.exe");
        driver = new ChromeDriver(cap);
        // Start website with constant variables
        driver.get("https://www.netflix.com/");
        driver.manage().window().maximize();
        System.out.println("Maximizando pantalla....!!!");
        System.out.println("----------");
        Utilities.waitXseconds(3);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}