package OpenMRS_Project.Oguzhan;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementBox2 {

    public ElementBox2(){
        PageFactory.initElements(BaseDriver.driver, this);
    }


    @FindBy(id = "coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")
    public WebElement dataManagementButton;
    @FindBy(id = "coreapps-mergePatientsHomepageLink-app")
    public WebElement mergeButton;
    @FindBy(id = "patient1-text")
    public WebElement patient1;
    @FindBy(id = "patient2-text")
    public WebElement patient2;
    @FindBy(id = "confirm-button")
    public WebElement continueButton;
    @FindBy(xpath = "//div[@id='apps']//a[1]")
    public WebElement searchPatient;
    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement searchPatientBox;
    @FindBy(xpath = "(//tr[@class='odd'])[1]")
    public WebElement patientRow;
    @FindBy(xpath = "//div[@class='float-sm-right']/span")
    public WebElement patientId;
    @FindBy(xpath = "//i[@class='icon-home small']")
    public WebElement homeButton;
    @FindBy(xpath = "//h1[contains(text(),'Merging cannot be undone!')]")
    public WebElement mergindSuccess;
    @FindBy(css = "[id='first-patient']")
    public WebElement preferredRecord;




}






