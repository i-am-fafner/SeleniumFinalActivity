package PageObjects.AlertsAndModalsObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BootstrapAlerts extends AbstractComponent {

    WebDriver driver;
    public BootstrapAlerts(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //SUCCESS BUTTON
    @FindBy(id = "autoclosable-btn-success")
    WebElement autoCloseSuccessAlertBtn;
    @FindBy(id = "normal-btn-success")
    WebElement normalSuccessAlertBtn;
    //WARNING BUTTON
    @FindBy(id = "autoclosable-btn-warning")
    WebElement autoCloseWarningAlertBtn;
    @FindBy(id = "normal-btn-warning")
    WebElement normalWarningAlertBtn;
    //DANGER BUTTON
    @FindBy(id = "autoclosable-btn-danger")
    WebElement autoCloseDangerAlertBtn;
    @FindBy(id = "normal-btn-danger")
    WebElement normalDangerAlertBtn;
    //INFO BUTTON
    @FindBy(id = "autoclosable-btn-info")
    WebElement autoCloseInfoAlertBtn;
    @FindBy(id = "normal-btn-info")
    WebElement normalInfoAlertBtn;
    //CLOSE ALERTS
    @FindBy(xpath = "(//button[@class='close'])[1]")
    WebElement successAlertClose;
    @FindBy(xpath = "(//button[@class='close'])[2]")
    WebElement warningAlertClose;
    @FindBy(xpath = "(//button[@class='close'])[3]")
    WebElement dangerAlertClose;
    @FindBy(xpath = "(//button[@class='close'])[4]")
    WebElement infoAlertClose;
    //AUTOCLOSE ALERTS' WEBELEMENT
    @FindBy(className = "[class*='alert-autocloseable-success']")
    WebElement autoCloseSuccessAlert;
    @FindBy(className = "[class*='alert-autocloseable-warning']")
    WebElement autoCloseWarningAlert;
    @FindBy(className = "[class*='alert-autocloseable-danger']")
    WebElement autoCloseDangerAlert;
    @FindBy(className = "[class*='alert-autocloseable-info']")
    WebElement autoCloseInfoAlert;

    //BOOTSTRAP ALERTS
    public void bootstrapAlerts(){
        try{
            Actions a = new Actions(driver);
            //SUCCESS ALERT
            a.click(autoCloseSuccessAlertBtn).build().perform();
            a.click(normalSuccessAlertBtn).build().perform();
            waitForWebElementToDisappear(autoCloseSuccessAlert);
            a.click(successAlertClose).build().perform();
            //WARNING ALERT
            a.click(autoCloseWarningAlertBtn).build().perform();
            a.click(normalWarningAlertBtn).build().perform();
            waitForWebElementToDisappear(autoCloseWarningAlert);
            a.click(warningAlertClose).build().perform();
            //DANGER ALERT
            a.click(autoCloseDangerAlertBtn).build().perform();
            a.click(normalDangerAlertBtn).build().perform();
            waitForWebElementToDisappear(autoCloseDangerAlert);
            a.click(dangerAlertClose).build().perform();
            //INFO ALERT
            a.click(autoCloseInfoAlertBtn).build().perform();
            a.click(normalInfoAlertBtn).build().perform();
            waitForWebElementToDisappear(autoCloseInfoAlert);
            a.click(infoAlertClose).build().perform();
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
