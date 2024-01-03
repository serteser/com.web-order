import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "FamilyAlbum" from Product dropdown.
 * 6-) Enter "3" as quantity number.
 * 7-) Enter "17" as discount percentage.
 * 8-) Enter "Inar Academy" as Name.
 * 9-) Enter "1100 Congress Ave" as Street.
 * 10-) Enter "Austin" as City.
 * 11-) Enter "TX" State.
 * 12-) Enter "78701" as Zip Code(number).
 * 13-) Select "Mastercard" as Card Type.
 * 14-) Enter "5162738261027163" as Card Number.
 * 15-) Enter "11/28" Expire Date(mm/yy format).
 * 16-) Click "Process"" button.
 * 17-) Verify the invalid Product Information error message is displayed.
 */
public class WO_007_OP_02 extends Hooks {

    @Test
    public void verifyOrderPlacementWithoutCalculation() throws InterruptedException {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar"); // valid user name

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy"); // valid password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement welcomingMessage = driver.findElement(By.xpath("//a[@href='/weborder/order']"));
        welcomingMessage.click();

        WebElement screenSaverTextField = driver.findElement(By.cssSelector("[value='FamilyAlbum']"));
        screenSaverTextField.click();

        WebElement quantityTextField = driver.findElement(By.id("quantityInput"));
        quantityTextField.sendKeys("3");

        WebElement discountInputTextField = driver.findElement(By.id("discountInput"));
        discountInputTextField.sendKeys("17");

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

        WebElement radioCheckInput = driver.findElement(By.cssSelector("#mastercard"));
        radioCheckInput.click();

        WebElement cardNumberTextField = driver.findElement(By.cssSelector("#cardNumber"));
        cardNumberTextField.sendKeys("5162738261027163");

        WebElement expiryDateTextField = driver.findElement(By.cssSelector("#expiryDate"));
        expiryDateTextField.sendKeys("11/28");

        WebElement processButton = driver.findElement(By.cssSelector("[type='submit']:nth-child(1)"));
        processButton.click();

        js.executeScript("window.scroll(0,500)");
        Thread.sleep(500);

        WebElement errorText = driver.findElement(By.xpath("//span/em[contains(text(),'Product Information')]"));

        assertTrue(errorText.isDisplayed());
    }
}
