import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "MyMoney" from Product dropdown.
 * 6-) Enter "8" as quantity number.
 * 7-) Enter "20" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Enter "Inar Academy" as Name.
 * 10-) Enter "1100 Congress Ave" as Street.
 * 11-) Enter "Austin" as City.
 * 12-) Enter "TX" State.
 * 13-) Enter "78701" as Zip Code(number).
 * 14-) Select "Visa" as Card Type.
 * 15-) Enter "4938281746192845" as Card Number.
 * 16-) Enter "11/28" Expire Date(mm/yy format).
 * 17-) Click "Process"" button.
 * 18-) Verify the confirmation message is displayed.
 * 19-) Navigate to view all orders page.
 * 20-) Verify the order is successfully placed.
 */
public class WO_006_OP_01 extends Hooks {

    String[] list = {"Inar Academy", "MyMoney", "8", "1100 Congress Ave", "Austin", "TX", "78701", "Visa", "4938281746192845", "11/28"};
    List<String> orderInformation = new ArrayList<>(Arrays.asList(list));

    @Test
    public void verifyOrderPlacement() throws InterruptedException {

        orderInformation.add(3, DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));

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

        WebElement screenSaverTextField = driver.findElement(By.cssSelector("[value='MyMoney']"));
        screenSaverTextField.click();

        WebElement quantityTextField = driver.findElement(By.id("quantityInput"));
        quantityTextField.sendKeys("8");

        WebElement discountInputTextField = driver.findElement(By.id("discountInput"));
        discountInputTextField.sendKeys("20");

        WebElement calculateButton = driver.findElement(By.cssSelector("[class=' fs-4 mt-4 fw-bold text-decoration-none border-none btn-primary text-fifth btn']"));
        calculateButton.click();

        WebElement nameTextField = driver.findElement(By.cssSelector("#name"));
        nameTextField.sendKeys("Inar Academy");

        WebElement streetTextField = driver.findElement(By.cssSelector("#street"));
        streetTextField.sendKeys("1100 Congress Ave");

        WebElement cityTextField = driver.findElement(By.cssSelector("#city"));
        cityTextField.sendKeys("Austin");

        WebElement stateTextField = driver.findElement(By.cssSelector("#state"));
        stateTextField.sendKeys("TX");

        WebElement zipTextField = driver.findElement(By.cssSelector("#zip"));
        zipTextField.sendKeys("78701");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,750)");

        Thread.sleep(500);

        WebElement radioCheckInput = driver.findElement(By.cssSelector("#visa"));
        radioCheckInput.click();

        WebElement cardNumberTextField = driver.findElement(By.cssSelector("#cardNumber"));
        cardNumberTextField.sendKeys("4938281746192845");

        WebElement expiryDateTextField = driver.findElement(By.cssSelector("#expiryDate"));
        expiryDateTextField.sendKeys("11/28");

        WebElement processButton = driver.findElement(By.cssSelector("[type='submit']:nth-child(1)"));
        processButton.click();

        WebElement orderAlertMessage = driver.findElement(By.cssSelector("[role='alert']"));

        assertTrue(orderAlertMessage.isDisplayed());

        js.executeScript("window.scroll(0,0)");
        Thread.sleep(500);

        WebElement viewAllOrdersTab = driver.findElement(By.cssSelector("[href='/weborder/view-orders']"));
        viewAllOrdersTab.click();

        String expectedUrl = "https://InarAcademy:Fk160621.@test.inar-academy.com/weborder/view-orders";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);

        List<WebElement> checkBox = driver.findElements(By.xpath("//td/span"));

        for (int i = 0; i < orderInformation.size(); i++) {

            assertEquals(orderInformation.get(i), checkBox.get(i).getText());
        }
    }
}
