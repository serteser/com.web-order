import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter "Inar" as username and "Academy" password.
 * 4-) Click on the "Login" button.
 * 5-) Verify that the user is successfully logged in
 */

public class WO_001_LP_01 extends Hooks {

    @Test
    public void verifyLoginFunctionality() {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar");

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement welcomeMessage = driver.findElement(By.id("welcome-heading"));
        String message = welcomeMessage.getText();

        assertEquals("Welcome, Inar!", message, "At the new page welcome-heading is Welcome, Inar!");
    }
}
