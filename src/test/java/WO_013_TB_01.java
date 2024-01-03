import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Toggle Button" 5 times.
 * 6-) Verify the toggle button functionality is working correctly.
 */
public class WO_013_TB_01 extends Hooks {

    @Test
    public void verifyToggleButtonFunctionality() throws InterruptedException {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar"); // valid user name

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy"); // valid password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(5000);

        WebElement toggleButton = driver.findElement(By.cssSelector("[class='react-switch-bg']"));

        boolean initialStateOfToggleButton = toggleButton.isSelected();

        for (int i = 0; i < 5; i++) {

            Thread.sleep(100);
            toggleButton.click();
        }

        boolean updatedStateOfToggleButton = toggleButton.isSelected();

        if (initialStateOfToggleButton == updatedStateOfToggleButton) {

            System.out.println("The toggle button functionality is working correctly!");
        }
    }
}
