import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * for starting a test with a specific driver different from chrome,  we must use the code in terminal like that; mvn test -DbrowserType="firefox"
 * -D it means to Define a property of the system. When it comes to Type="firefox" pairs, can be considered as key and value pairs in java HashMap.
 */

public class Hooks {

    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeAll
    public static void setUpBeforeTest() {

        String browser = System.getProperty("browserType", "chrome");

        switch (browser.toLowerCase()) {

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1680");
                firefoxOptions.addArguments("--height=1050");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--ignore-certificate-errors");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--ignore-certificate-errors");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

        if (browser.equalsIgnoreCase("firefox")) {

            driver.navigate().refresh();
        }
    }

    @AfterAll
    public static void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}
