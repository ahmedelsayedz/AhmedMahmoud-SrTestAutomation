package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class common {
    public static WebDriver driver;
    public static JavascriptExecutor jse;

    // common constructor
    @SuppressWarnings("static-access")
    public common(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected static void clickButton(By button) {
        driver.findElement(button).click();
    }

    protected static void setTextElementText(By textElement, String value) {
        driver.findElement(textElement).sendKeys(value);
    }

    protected static void scrollToBottom() {
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    protected static void goToElement(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected static void clearText(WebElement element) {
        element.clear();
    }

    protected static void goToPreviousPage() {
        driver.navigate().back();
    }

    protected static String getText(WebElement element) {
        return element.getText();
    }

    protected static WebElement selectliItem(WebElement parentElement, int b) {
        List<WebElement> links = parentElement.findElements(By.tagName("li"));
        return links.get(b);
    }

    public String getLastListItem(By element){
        List<WebElement> orders = driver.findElements(element);
        WebElement webElement = orders.get(orders.size()-1);
        return webElement.getText();
    }
    public void selectByVisibleText(By element, String value){
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(value);
    }

    public void selectRandomIndex(By element, int min, int max){
        Select selects = new Select(driver.findElement(element));
        selects.selectByIndex(getRandomNumber(min, max));
    }

    public static String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public static void closeAlert(){
        driver.switchTo().alert().accept();
    }

    // Helper method to generate a random number
    public int getRandomNumber(int min, int max) {
        //Generate random int value from 1 to 3
        System.out.println("Random value in int from "+min+" to "+ max + ":");
        int random_int = (int)Math.floor(Math.random()*(max -min+1)+min);
        System.out.println(random_int);
        return random_int;
    }
}
