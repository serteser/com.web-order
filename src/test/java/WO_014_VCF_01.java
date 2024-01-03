import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1-) Open the URL
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the view all order page.
 * 5-) Click "Add More Data" "4" times.
 * 6-) Click "Clipboard" button on the 3rd row.
 * 7-) Verify that you return to the order page with the data of the row you had selected just before.
 */
public class WO_014_VCF_01 extends Hooks {

    @Test
    public void verifyClipboardFunctionalityInViewAllOrderPage() throws InterruptedException {

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

        for (int i = 0; i < 4; i++) {

            addMoreDataButton.click();
        }

        List<String> dataList = new ArrayList<>();

        for (int i = 23; i < 34; i++) {

            if (i != 26) {

                dataList.add(driver.findElement(By.xpath("(//tbody/tr/td/span)[" + i + "]")).getText());
            }
        }

        List<WebElement> clipboardButton = driver.findElements(By.cssSelector("[class='btn-primary btn fs-4']"));
        clipboardButton.get(2).click();

        String productName = driver.findElement(By.cssSelector("#productSelect")).getAttribute("value");
        String quantity = driver.findElement(By.cssSelector("#quantityInput")).getAttribute("value");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(500);

        String name = driver.findElement(By.cssSelector("#name")).getAttribute("value");
        String street = driver.findElement(By.cssSelector("#street")).getAttribute("value");
        String city = driver.findElement(By.cssSelector("#city")).getAttribute("value");
        String state = driver.findElement(By.cssSelector("#state")).getAttribute("value");
        String zip = driver.findElement(By.cssSelector("#zip")).getAttribute("value");

        js.executeScript("window.scroll(0,500)");
        Thread.sleep(500);

        String card = driver.findElement(By.cssSelector("#" + cardIdConvertor(dataList.get(7)))).getAttribute("value");
        String cardNumber = driver.findElement(By.cssSelector("#cardNumber")).getAttribute("value");
        String expireDate = driver.findElement(By.cssSelector("#expiryDate")).getAttribute("value");

        String[] list = {name, productName, quantity, street, city, state, zip, card, cardNumber, expireDate};
        List<String> checkList = new ArrayList<>(Arrays.asList(list));

        for (int i = 0; i < checkList.size(); i++) {

            assertEquals(checkList.get(i), dataList.get(i));
        }
    }

    public static String cardIdConvertor(String str) {

        return switch (str) {

            case "American Express" -> "amex";
            case "Mastercard" -> "mastercard";
            case "Visa" -> "visa";
            default -> "Error";
        };
    }
}
