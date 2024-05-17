package PageObjects.ListBoxObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DataListFilter extends AbstractComponent {

    WebDriver driver;
    public DataListFilter(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //BOOTSTRAP LIST BOX
    @FindBy(xpath = "(//ul[@class='list-group'])[1]/li")
    List<WebElement> leftList;
    @FindBy(xpath = "(//ul[@class='list-group'])[2]/li")
    List<WebElement> rightList;
    @FindBy(xpath = "(//a/i[contains(@class, 'glyphicon')])[1]")
    WebElement leftSelectAll;
    @FindBy(xpath = "(//a/i[contains(@class, 'glyphicon')])[2]")
    WebElement rightSelectAll;
    @FindBy(xpath = "//button[contains(@class, 'move-right')]")
    WebElement moveRightBtn;
    @FindBy(xpath = "//button[contains(@class, 'move-left')]")
    WebElement moveLeftBtn;

    //DATA LIST FILTER
    @FindBy(id = "input-search")
    WebElement dataListSearchBox;
    @FindBy(css = "[style*='display: block;']")
    List<WebElement> visibleItems;

    //BOOTSTRAP LIST BOX
    public void bootstrapListBox(){
        try{
            Actions a = new Actions(driver);

            //Select all items on the LEFT LIST
            for (WebElement webElement : leftList) {
                webElement.click();
            }
            a.click(moveRightBtn).build().perform(); //Move right

            //Select all items on the RIGHT LIST
            for (WebElement webElement : rightList) {
                webElement.click();
            }
            a.click(moveLeftBtn).build().perform(); //Move left
            a.click(leftSelectAll).build().perform(); //Select ALL on LEFT LIST
            a.click(moveRightBtn).build().perform(); //Move right
            a.click(rightSelectAll).build().perform(); //Select ALL on RIGHT LIST
            a.click(moveLeftBtn).build().perform(); //Move left
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    //DATA LIST FILTER
    public void dataListFilter(String searchInput){
        try{
            Actions a = new Actions(driver);
            a.sendKeys(dataListSearchBox, searchInput).build().perform();
            for (WebElement webElement : visibleItems) {
                Assert.assertTrue(webElement.getText().toLowerCase().contains(searchInput.toLowerCase())); //Shift all text to lowercase for comparison
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
