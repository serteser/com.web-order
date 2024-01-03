import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Click "Logout" button.
 * 5-) Verify logout successfully.
 */
public class WO_003_LP_03 extends Hooks {

    @Test
    public void VerifyLogoutFunctionality() {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar");

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.cssSelector("#logout-button"));
        logoutButton.click();

        String currentUrl = driver.getCurrentUrl();

        assertEquals("https://InarAcademy:Fk160621.@test.inar-academy.com", currentUrl);
    }
}
