import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Add More Data" "4" times.
 * 6-) Click "Check All" button.
 * 7-) Verify all orders selected.
 */
public class WO_010_VOA_01 extends Hooks {

    @Test
    public void verifyCheckAllFunctionalityInViewAllOrderPage() {

        WebElement webOrderTab = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderTab.click();

        WebElement userNameTextField = driver.findElement(By.id("login-username-input"));
        userNameTextField.sendKeys("Inar"); // valid user name

        WebElement passwordTextField = driver.findElement(By.id("login-password-input"));
        passwordTextField.sendKeys("Academy"); // valid password

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewAllOrdersTab = driver.findElement(By.cssSelector("[href='/weborder/view-orders']"));
        viewAllOrdersTab.click();

        WebElement addMoreDataButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));

        for (int i = 0; i < 4; i++) {

            addMoreDataButton.click();
        }

        WebElement checkAllButton = driver.findElement(By.xpath("//button[contains(text(),'Check All')]"));
        checkAllButton.click();

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']:nth-child(1)"));

        for (int i = 0; i < checkboxes.size(); i++) {

            assertTrue(checkboxes.get(i).isSelected());
        }
    }
}
