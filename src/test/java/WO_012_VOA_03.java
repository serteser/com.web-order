import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Add More Data" "8" times.
 * 6-) Click 1st, 3rd and 5th orders checkbox's.
 * 7-) Click "Delete All" button.
 * 8-) Verify the orders are deleted.
 */
public class WO_012_VOA_03 extends Hooks {

    @Test
    public void verifyDeleteFunctionalityInViewAllOrderPage() {

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

        for (int i = 0; i < 8; i++) {

            addMoreDataButton.click();
        }

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']:nth-child(1)"));

        for (int i = 0; i < checkboxes.size(); i++) {

            if (i == 0 || i == 2 || i == 4) {

                checkboxes.get(i).click();
            }
        }

        WebElement deleteButton = driver.findElement(By.cssSelector("[class='btn btn-danger fs-4 text-white ']"));
        deleteButton.click();

        checkboxes = driver.findElements(By.cssSelector("[type='checkbox']:nth-child(1)"));

        assertEquals(5, checkboxes.size(), "Since actual value is not 5 it means that \"Delete\" button does not work well.");
    }
}
