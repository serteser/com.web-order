import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "ScreenSaver" from Product dropdown.
 * 6-) Leave blank the quantity box.
 * 7-) Enter "20" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Verify the invalid Quantity error message is displayed.
 */
public class WO_005_CF_02 extends Hooks {

    @Test
    public void verifyCalculateFunctionalityInOrderPageInvalidInput() {

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

        WebElement screenSaverTextField = driver.findElement(By.cssSelector("[value='ScreenSaver']"));
        screenSaverTextField.click();

        WebElement discountInputTextField = driver.findElement(By.id("discountInput"));
        discountInputTextField.sendKeys("20");

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();

        WebElement quantityValidateError = driver.findElement(By.xpath("//em[contains(text(),'Field')]"));

        assertTrue(quantityValidateError.isDisplayed());
    }
}
