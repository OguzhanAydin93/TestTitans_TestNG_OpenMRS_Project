package OpenMRS_Project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.BaseDriver.driver;

public class Asli_POM {

    public Asli_POM() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[class='zak-button']")
    public WebElement demoButton;

    @FindBy(xpath="(//span[@class='elementor-button-text'])[2]")
    public WebElement OpenMRS2Button;

    @FindBy(xpath="(//span[@class='elementor-button-text'])[4]")
    public WebElement enterOpenMrs2Button;

    @FindBy(xpath="//input[@name='username']")
    public WebElement usernameInput;


    @FindBy(xpath="//input[@name='password']")
    public WebElement passwordInput;


    @FindBy(xpath="//li[@id='Inpatient Ward']")
    public WebElement inpatientWard;


    @FindBy(xpath="//input[@id='loginButton']")
    public WebElement loginButton;


    @FindBy(xpath="//i[@class='icon-search']")
    public WebElement findPatientRecord;

    @FindBy(css="[placeholder='Search by ID or Name']")
    public WebElement hastaArama;

    @FindBy(css = "[class='col-12 col-sm-12 col-md-12 col-lg-12']")
    public WebElement assert1;


    @FindBy(linkText = "https://demo.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId=25320bb4-a206-4fc6-aee9-f6d74f6fd851")
        public WebElement assert2;

    @FindBy(css = "[class='dataTables_empty']")
    public WebElement no;



       @FindBy(linkText = "Find Patient Record")
    public WebElement findPatient;


}
