import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInfo extends BaseTest
{
    @Test
    public void OverviewPassWithCorrectData()
    {
        WebElement addProductButton = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button"));
        addProductButton.click();

        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button"));
        checkoutButton.click();

        WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
        firstName.sendKeys("Andres");

        WebElement lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("last-name")));
        lastName.sendKeys("Gottlieb");

        WebElement postalCode = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postal-code")));
        postalCode.sendKeys("0000");

        WebElement continueButton = driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > input"));
        continueButton.click();

        WebElement checkoutOverview = driver.findElement(By.className("subheader"));

        String text = checkoutOverview.getText();
        Assertions.assertEquals("Checkout: Overview",text);


    }

    @Test
    public void OverviewPassWithoutFirstName()
    {
        WebElement addProductButton = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button"));
        addProductButton.click();

        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button"));
        checkoutButton.click();

        WebElement lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("last-name")));
        lastName.sendKeys("Gottlieb");

        WebElement postalCode = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postal-code")));
        postalCode.sendKeys("0000");

        WebElement continueButton = driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > input"));
        continueButton.click();

        WebElement error = driver.findElement(By.cssSelector("#checkout_info_container > div > form > h3"));


        Assertions.assertTrue(error.isDisplayed());
        String errorMessage=error.getText();
        Assertions.assertEquals("Error: First Name is required",errorMessage);


    }

    @Test
    public void OverviewPassWithIncorrectData()
    {
        WebElement addProductButton = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button"));
        addProductButton.click();

        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button"));
        checkoutButton.click();

        WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
        firstName.sendKeys("98734");

        WebElement lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("last-name")));
        lastName.sendKeys("9034279");

        WebElement postalCode = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postal-code")));
        postalCode.sendKeys("hola");

        WebElement continueButton = driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > input"));
        continueButton.click();

        WebElement error = driver.findElement(By.cssSelector("#checkout_info_container > div > form > h3"));


        Assertions.assertTrue(error.isDisplayed());
        String errorMessage=error.getText();
        Assertions.assertEquals("Error: Information format not valid",errorMessage);

    }
}
