package steps;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait wait;
    public static Properties properties = TestProperties.getInstance().getProperties();
    private final static String tag = System.getProperty("tag");

    public static String getTag() {
        return tag;
    }

    public static void setUp() {
        switch (properties.getProperty("browser")) {
            case "opera":
                System.setProperty("webdriver.opera.driver", properties.getProperty("driver"));
                driver = new OperaDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("driver"));
                driver = new ChromeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(properties.getProperty("app.url"));
    }

    public static void tearDown() {
        driver.quit();
    }
}
