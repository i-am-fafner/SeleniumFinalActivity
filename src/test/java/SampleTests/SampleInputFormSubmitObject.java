package SampleTests;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SampleInputFormSubmitObject extends AbstractComponent {

    WebDriver driver;

    public SampleInputFormSubmitObject(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //INPUT FORM SUBMIT
    @FindBy(name = "first_name")
    WebElement firstNameInput;
    @FindBy(name = "last_name")
    WebElement lastNameInput;
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "phone")
    WebElement phoneInput;
    @FindBy(name = "address")
    WebElement addressInput;
    @FindBy(name = "city")
    WebElement cityInput;
    @FindBy(name = "state")
    WebElement stateInput;
    @FindBy(name = "zip")
    WebElement zipCodeInput;
    @FindBy(name = "website")
    WebElement websiteInput;
    @FindBy(xpath = "(//input[@type='radio'])[1]")
    WebElement radioYesInput;
    @FindBy(xpath = "(//input[@type='radio'])[2]")
    WebElement radioNoInput;
    @FindBy(name = "comment")
    WebElement projectDescriptionInput;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement submitInputBtn;

    //INPUT FORM SUBMIT -------------------------------------------------------------------------------------------------
//    public void inputFormSubmit(String firstName, String lastName, String email, String phoneNo, String address,
//                                String city, String zipCode, String website, String projectDescription) {
//        try{
//            Actions a = new Actions(driver);
//            a.sendKeys(firstNameInput, firstName).build().perform();
//            a.sendKeys(lastNameInput, lastName).build().perform();
//            a.sendKeys(emailInput, email).build().perform();
//            a.sendKeys(phoneInput, phoneNo).build().perform();
//            a.sendKeys(addressInput, address).build().perform();
//            a.sendKeys(cityInput, city).build().perform();
//            Select dropdown = new Select(stateInput);
//            List<WebElement> dropdownList = dropdown.getOptions();
//            for (int i = 0; i < dropdownList.size(); i++) {
//                dropdown.selectByIndex(i);
//            }
//            a.sendKeys(zipCodeInput, zipCode).build().perform();
//            a.sendKeys(websiteInput, website).build().perform();
//            a.click(radioYesInput).build().perform();
//            a.click(radioNoInput).build().perform();
//            a.sendKeys(projectDescriptionInput, projectDescription).build().perform();
//            a.click(submitInputBtn).build().perform();
//        }catch (Exception e){
//            System.out.println("Error Received: " + e.getMessage());
//            throw e;
//        }
//    }

    public void inputFormSubmit(String firstName) {
    try{
        Actions a = new Actions(driver);
        firstNameInput.sendKeys(firstName);
        Assert.assertEquals(firstNameInput.getAttribute("value"),firstName,"Mismatch in comparison");
        System.out.println("Validation Passed!" + firstNameInput.getAttribute("value"));
    }catch (AssertionError e){
        System.out.println("Assertion Test Failed" + e.getMessage());
        System.out.println("Test Branch" + e.getMessage());
        throw e;
    }
  }

}
