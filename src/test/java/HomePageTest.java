import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.text.CollationElementIterator;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class HomePageTest extends BaseTest
{
    @Test
    public void orderingFilterZtoATest()
    {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Name (Z to A)");

        //verification
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

        List<String> actualProductOrder = new ArrayList<>();

        for(WebElement element : productNames)
        {
            actualProductOrder.add(element.getText());
        }

        boolean isSorted = Ordering.natural().reverse().isOrdered(actualProductOrder);
        Assertions.assertTrue(isSorted);



    }
    //PRUEBAS REALIZADAS PARA EXAMEN
    @Test
    public void orderingFilterAtoZTest()
    {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Name (A to Z)");

        //verification
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

        List<String> actualProductOrder = new ArrayList<>();

        for(WebElement element : productNames)
        {
            actualProductOrder.add(element.getText());
        }

        boolean isSorted = Ordering.natural().isOrdered(actualProductOrder);
        Assertions.assertTrue(isSorted);



    }

    @Test
    public void orderingFilterLowtoHighTest()
    {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Price (low to high)");

        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));

        List<Double> actualProductOrder = new ArrayList<>();

        for (WebElement element : productPrices)
        {
            String priceText = element.getText().replace("$", "");
            actualProductOrder.add(Double.parseDouble(priceText));
        }

        List<Double> expectedProductOrder = new ArrayList<>(actualProductOrder);
        Collections.sort(expectedProductOrder);

        Assertions.assertEquals(expectedProductOrder, actualProductOrder, "The products are not sorted from low to high.");
    }

    @Test
    public void orderingFilterHightoLowTest()
    {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Price (high to low)");

        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));

        List<Double> actualProductOrder = new ArrayList<>();

        for (WebElement element : productPrices)
        {
            String priceText = element.getText().replace("$", "");
            actualProductOrder.add(Double.parseDouble(priceText));
        }

        List<Double> reverseExpectedProductOrder = new ArrayList<>(actualProductOrder);
        Collections.sort(reverseExpectedProductOrder);
        Collections.reverse(reverseExpectedProductOrder);

        Assertions.assertEquals(reverseExpectedProductOrder,actualProductOrder, "The products are not sorted from low to high.");
    }

    @Test
    public void addToCartButtons()
    {
        WebElement userNameTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-name")));
        userNameTextBox.sendKeys("standard_user");

        WebElement passwordTextBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#password")));
        passwordTextBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();

        List<WebElement> buttons = driver.findElements(By.className("btn_primary"));

        Integer i =1;
        for (WebElement button : buttons)
        {
            button.click();
            WebElement remove = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child("+i+") > div.pricebar > button"));
            String text=remove.getText();
            Assertions.assertEquals("REMOVE",text);
        }
    }

}
