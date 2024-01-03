import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "HomeDecor" from Product dropdown.
 * 6-) Enter "5" as quantity number.
 * 7-) Enter "15" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Verify that the total amount is successfully displayed.
 */
public class WO_004_CF_01 extends Hooks {

    @Test
    public void verifyCalculateFunctionalityInOrderPage() {

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

        WebElement homeDecorTextField = driver.findElement(By.cssSelector("[value='HomeDecor']"));
        homeDecorTextField.click();

        WebElement quantityTextField = driver.findElement(By.id("quantityInput"));
        quantityTextField.sendKeys("5");

        WebElement discountInputTextField = driver.findElement(By.id("discountInput"));
        discountInputTextField.sendKeys("15");

        WebElement calculateButton = driver.findElement(By.cssSelector("[class=' fs-4 mt-4 fw-bold text-decoration-none border-none btn-primary text-fifth btn']"));
        calculateButton.click();

        WebElement totalInputTextField = driver.findElement(By.id("totalInput"));
        String total = totalInputTextField.getAttribute("value");

        assertEquals("638", total);
    }
}
