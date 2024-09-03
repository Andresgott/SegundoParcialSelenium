import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumExampleNavigation {

    @Test
    public void seleniumNavigateTestChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/v1/");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void seleniumNavigateTestFirefox() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.saucedemo.com/v1/");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void seleniumNavigateTestEdge() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.saucedemo.com/v1/");
        Thread.sleep(5000);
        driver.quit();
    }

}
