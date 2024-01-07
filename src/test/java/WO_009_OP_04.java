import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "SportsEquipment" from Product dropdown.
 * 6-) Enter "1" as quantity number.
 * 7-) Enter "10" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Enter "Inar Academy" as Name.
 * 10-) Enter "1100 Congress Ave" as Street.
 * 11-) Enter "Austin" as City.
 * 12-) Enter "TX" State.
 * 13-) Enter "78701" as Zip Code(number).
 * 14-) Enter "4938220192845" as Card Number.
 * 15-) Enter "09/26" Expire Date(mm/yy format).
 * 16-) Click "Process"" button.
 * 17-) Verify the Card Type error message is displayed.
 */
public class WO_009_OP_04 extends Hooks {

    @Test
    public void verifyOrderPlacementWithoutCardType() throws InterruptedException {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar"); // valid user name

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy"); // valid password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement orderTab = driver.findElement(By.xpath("//a[@href='/weborder/order']"));
        orderTab.click();

        WebElement screenSaverTextField = driver.findElement(By.cssSelector("[value='SportsEquipment']"));
        screenSaverTextField.click();

        WebElement quantityTextField = driver.findElement(By.id("quantityInput"));
        quantityTextField.sendKeys("1");

        WebElement discountInputTextField = driver.findElement(By.id("discountInput"));
        discountInputTextField.sendKeys("10");

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();

        WebElement nameTextField = driver.findElement(By.cssSelector("#name"));
        nameTextField.sendKeys("Inar Academy");

        WebElement streetTextField = driver.findElement(By.cssSelector("#street"));
        streetTextField.sendKeys("1100 Congress Ave");

        WebElement cityTextField = driver.findElement(By.cssSelector("#city"));
        cityTextField.sendKeys("Austin");

        WebElement stateTextField = driver.findElement(By.cssSelector("#state"));
        stateTextField.sendKeys("TX");

        WebElement zipTextField = driver.findElement(By.cssSelector("#zip"));
        zipTextField.sendKeys("78701");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,750)");

        Thread.sleep(500);

        WebElement cardNumberTextField = driver.findElement(By.cssSelector("#cardNumber"));
        cardNumberTextField.sendKeys("4938220192845");

        WebElement expiryDateTextField = driver.findElement(By.cssSelector("#expiryDate"));
        expiryDateTextField.sendKeys("09/26");

        WebElement processButton = driver.findElement(By.cssSelector("[type='submit']:nth-child(1)"));
        processButton.click();

        js.executeScript("window.scroll(0,450)");

        WebElement errorTextForCard = driver.findElement(By.cssSelector("[style='font-size: 14px; margin-left: 10px; display: block;']"));
        String actualResult = errorTextForCard.getText();

        String expectedResult = "Card type cannot be empty";

        assertEquals(expectedResult, actualResult);
    }
}
