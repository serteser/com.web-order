import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
 * 4-) Click on the "Login" button
 * 5-) Verify that the appropriate error message is displayed.
 */

public class WO_002_LP_02 extends Hooks {

    @Test
    public void verifyLoginFailureForUserName() {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("inar"); // invalid user name

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy"); // valid password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement userNameErrorMessage = driver.findElement(By.id("username-error-alert"));
        String userNameErrorAlertMessage = userNameErrorMessage.getText();

        assertEquals("Invalid username", userNameErrorAlertMessage);
    }

    @Test
    public void verifyLoginFailureForPassword() {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar"); // valid user name

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("academy"); // invalid password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement passwordErrorMessage = driver.findElement(By.id("password-error-alert"));
        String passwordErrorAlertMessage = passwordErrorMessage.getText();

        assertEquals("Invalid password", passwordErrorAlertMessage);
    }
}
