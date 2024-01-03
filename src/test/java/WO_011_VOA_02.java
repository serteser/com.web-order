import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Add More Data" "6" times.
 * 6-) Click "Check All" button.
 * 7-) Verify all orders selected.
 * 8-) Click "Uncheck All" button.
 * 9-) Verify all orders are unselected.
 */
public class WO_011_VOA_02 extends Hooks {

    @Test
    public void verifyUncheckAllFunctionalityInViewAllOrderPage() {

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

        WebElement addMoreDataButton = driver.findElement(By.cssSelector("[class='fs-4 btn btn-primary text-fifth me-3']"));

        for (int i = 0; i < 6; i++) {

            addMoreDataButton.click();
        }

        WebElement checkAllButton = driver.findElement(By.cssSelector("[class='btn btn-success fs-4 text-fifth me-3']"));
        checkAllButton.click();

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']:nth-child(1)"));

        for (int i = 0; i < checkboxes.size(); i++) {

            assertTrue(checkboxes.get(i).isSelected(), "Since actual value is false it means that \"Check All\" button does not work well.");
        }

        WebElement uncheckAllButton = driver.findElement(By.cssSelector("[class='btn btn-primary fs-4 text-fifth']"));
        uncheckAllButton.click();

        for (int i = 0; i < checkboxes.size(); i++) {

            assertFalse(checkboxes.get(i).isSelected(), "Since actual value is true it means that \"Uncheck All\" button does not work well.");
        }
    }
}
