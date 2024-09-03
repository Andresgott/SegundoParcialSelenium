import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SeleniumFindingElementsExample {

    @Test
    public void searchByIdExample() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByClassName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        WebElement sortComboBox = driver.findElement(By.className("product_sort_container"));
        sortComboBox.click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void searchByName() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/v1/");

        WebElement userNameTextBox = driver.findElement(By.name("user-name"));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        Thread.sleep(5000);
    }

    @Test
    public void searchByLinkTest() throws  InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/v1/");



        WebElement considerSmallDonationLink = driver.findElement(By.linkText("Consider a small Donation and support this page."));
        considerSmallDonationLink.click();

        Thread.sleep(5000);
    }

    @Test
    public void searchingByTagName() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/v1/");

        List<WebElement> webElements = driver.findElements(By.tagName("input"));
        System.out.println(webElements.size());
        Thread.sleep(5000);
    }

    @Test
    public void searchByCssSelector() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/v1/");

        //CSS SELECTOR
        //NUMERAL ES ID -> any element con user name #user-name
        //input#user-name -> mas especifico
        WebElement userNameTextBox = driver.findElement(By.cssSelector("#user-name"));
        userNameTextBox.sendKeys("standard_user");

        //tag_element[attribute='VALUE']
        //input[placeholder='Username']
        WebElement passwordTextBox = driver.findElement(By.cssSelector("#password"));
        passwordTextBox.sendKeys("secret_sauce");

        // . ->class
        //input.btn_action -> selects an input with class btn_action

        WebElement loginButton = driver.findElement(By.cssSelector("input.btn_action"));
        loginButton.click();

        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a > svg"));
        cartButton.click();

        Thread.sleep(5000);

    }

    @Test
    public void searchingByXpath() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://saucedemo.com/v1/");

        ////*[@id="user-name"]
        WebElement userNameTextBox = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        userNameTextBox.sendKeys("standard_user");
        WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a > svg"));
        cartButton.click();

        Thread.sleep(5000);

    }
    //https://selectorshub.com/xpath-practice-page/
}
