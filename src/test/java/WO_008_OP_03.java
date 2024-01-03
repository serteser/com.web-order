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
 * 5-) Select "MyMoney" from Product dropdown.
 * 6-) Enter "8" as quantity number.
 * 7-) Enter "20" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Enter "Inar Academy" as Name.
 * 10-) Enter "1100 Congress Ave" as Street.
 * 11-) Enter "Austin" as City.
 * 12-) Enter "TX" State.
 * 13-) Enter "92@#83" as Zip Code.
 * 14-) Select "American Express" as Card Type.
 * 15-) Enter "342738261027163" as Card Number.
 * 16-) Enter "01/28" Expire Date(mm/yy format).
 * 17-) Click "Process"" button.
 * 18-) Verify the invalid Zip Code error message is displayed.
 */
public class WO_008_OP_03 extends Hooks {

    @Test
    public void verifyOrderPlacementWithInvalidZipCode() throws InterruptedException {

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

        WebElement screenSaverTextField = driver.findElement(By.cssSelector("[value='MyMoney']"));
        screenSaverTextField.click();

        WebElement quantityTextField = driver.findElement(By.id("quantityInput"));
        quantityTextField.sendKeys("8");

        WebElement discountInputTextField = driver.findElement(By.id("discountInput"));
        discountInputTextField.sendKeys("20");

        WebElement calculateButton = driver.findElement(By.cssSelector("[class=' fs-4 mt-4 fw-bold text-decoration-none border-none btn-primary text-fifth btn']"));
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
        zipTextField.sendKeys("92@#83");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,750)");

        Thread.sleep(500);

        WebElement radioCheckInput = driver.findElement(By.cssSelector("#amex"));
        radioCheckInput.click();

        WebElement cardNumberTextField = driver.findElement(By.cssSelector("#cardNumber"));
        cardNumberTextField.sendKeys("342738261027163");

        WebElement expiryDateTextField = driver.findElement(By.cssSelector("#expiryDate"));
        expiryDateTextField.sendKeys("01/28");

        WebElement processButton = driver.findElement(By.cssSelector("[type='submit']:nth-child(1)"));
        processButton.click();

        WebElement processButtonMessage = driver.findElement(By.xpath("(//div[contains(text(),'New order')])"));

        String processMessage = processButtonMessage.getText();

        js.executeScript("window.scroll(0,450)");

        assertEquals("An error message should be displayed indicating that the entered Zip Code is invalid.", processMessage);
    }
}
