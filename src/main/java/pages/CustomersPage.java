package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomersPage extends common {

    private final WebDriver driver;

    private final By orderList = By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr");
    private final By deleteBtn = By.xpath("//tr[contains(., 'Ahmed')]//button");

    public CustomersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public int getListSize(){
        return driver.findElements(orderList).size();
    }

    public String getLastOrderData(){
        return getLastListItem(orderList);
    }

    public String getAlertMessage(){
        return getAlertText();
    }

    public void closeAlertPopUp(){
        closeAlert();
    }

    public void deleteRecord(){
        List<WebElement> orders = driver.findElements(orderList);
        for (WebElement order : orders){
            if (order.getText().contains("Ahmed Mahmoud")){
                clickButton(deleteBtn);
            }
        }
    }

    public String checkRecordExisted(){
        List<WebElement> orders = driver.findElements(orderList);
        for (WebElement order : orders){
            order.getText();
        }
        return null;
    }
}
