package PageObjects.AlertsAndModalsObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class WindowPopupModal extends AbstractComponent {

    WebDriver driver;
    public WindowPopupModal(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WINDOW POPUP BUTTONS
    @FindBy(xpath = "//a[contains(text(),'Follow On Twitter')]")
    WebElement openTwitterBtn;
    @FindBy(xpath = "//a[contains(text(),'Like us On Facebook')]")
    WebElement openFacebookBtn;
    @FindBy(xpath = "//a[contains(text(),'Follow Twitter & Facebook')]")
    WebElement openTwitterFacebookBtn;
    @FindBy(xpath = "//a[contains(text(),'Follow All')]")
    WebElement openAllBtn;
    @FindBy(className = "[class*='btn-primary']")
    WebElement allBtn;

    //WINDOW POPUP MODAL
    public void windowPopupModal() throws InterruptedException {
        try {
            Actions a = new Actions(driver);
            String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER); //Opens links in new tab (Mac)

            //OPEN WINDOWS
            a.sendKeys(openTwitterBtn, openInNewTab).build().perform();
            a.sendKeys(openFacebookBtn, openInNewTab).build().perform();
            a.sendKeys(openTwitterFacebookBtn, openInNewTab).build().perform();
            a.sendKeys(openAllBtn, openInNewTab).build().perform();

            //VERIFY OPENED WINDOWS
            Set<String> windows = driver.getWindowHandles(); //Gets all windows opened by automation and store in the set
            String[] linkArray; //Declare an array to contain WindowHandles
            for (int i = 0; i < windows.size(); i++) { //Loop to get the title of all links in the column
                linkArray = driver.getWindowHandles().toArray(new String[i]); //Adds window into array
                driver.switchTo().window(linkArray[i]); //Move interface to link window
                System.out.println("Link " + i + ": " + driver.getTitle()); //Print the title of the current webpage
                driver.switchTo().window(linkArray[0]); //Move interface back to main window
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
