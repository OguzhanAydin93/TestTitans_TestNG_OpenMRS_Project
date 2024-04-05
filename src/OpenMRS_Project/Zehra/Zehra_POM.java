package OpenMRS_Project.Zehra;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.wait;

public class Zehra_POM {

    public Zehra_POM() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class='zak-header-button zak-header-button--1']>a")
    public WebElement demoButton;
    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2;
    @FindBy(xpath = "(//span[@class='elementor-button-text'])[4]")
    public WebElement enterOpenMRS2Demo;
    @FindBy(xpath = "//input[@placeholder='Enter your username']")
    public WebElement username;
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    public WebElement password;
    @FindBy(xpath = "//ul[@id='sessionLocation']/li")
    public List<WebElement> locationRndm;
    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;
    @FindBy(xpath = "(//i[contains(@class, 'icon-user')])[1]")
    public WebElement admin;
    @FindBy(linkText = "My Account")
    public WebElement myAccount;
    @FindBy(xpath = "(//i[contains(@class, 'icon-lock')])")
    public WebElement changePassword;
    @FindBy(xpath = "(//i[contains(@class, 'icon-cog')])")
    public WebElement myLanguages;
    @FindBy(css = "[class='button app big']")
    public List<WebElement> passwordLanguages;
    @FindBy(xpath = "(//i[contains(@class, 'icon-search')])")
    public WebElement patientRecord;
    @FindBy(css = "[id='patient-search']")
    public WebElement patientSearch;
    @FindBy(css = "[role='alert']")
    public WebElement patientInfo;
    @FindBy(xpath = "(//div[@class='col-11 col-lg-10'])[8]")
    public WebElement patientDelete;
    @FindBy(css = "[id='delete-reason']")
    public WebElement deleteReason;
    @FindBy(xpath = "(//button[text()='Confirm'])[4]")
    public WebElement confirmBtn;
    @FindBy(css = "[aria-relevant='all']")
    public WebElement deleteConfirm;
    @FindBy(css = "[class='col-12 col-sm-12 col-md-12 col-lg-12']>h4")
    public WebElement superUser;
    @FindBy(css = "[class='nav-item logout']>a")
    public WebElement logout;
    @FindBy(xpath = "(//a[@class='btn btn-default btn-lg button app big align-self-center'])[5]")
    public WebElement appoinment;
    @FindBy(xpath = "(//a[@class='btn btn-default btn-lg button app big align-self-center'])[3]")
    public WebElement manageAppoinment;
    @FindBy(css = "[id='patient-search']")
    public WebElement appoinmentSearch;
    @FindBy(xpath = "//div[@class='text']/p")
    public WebElement text;


    public void login() {
        driver.navigate().to("https://openmrs.org/demo/");
        JavascriptExecutor js = (JavascriptExecutor) driver;


        wait.until(ExpectedConditions.elementToBeClickable(demoButton));
        js.executeScript("arguments[0].click();",demoButton);
        js.executeScript("arguments[0].scrollIntoView(true);", exploreOpenMRS2);
        js.executeScript("arguments[0].click();",exploreOpenMRS2);

        js.executeScript("arguments[0].scrollIntoView(true);", enterOpenMRS2Demo);
        js.executeScript("arguments[0].click();",enterOpenMRS2Demo);
        wait.until(ExpectedConditions.urlContains("login"));
        username.sendKeys("admin");
        password.sendKeys("Admin123");

        int rndmLocation = (int) (Math.random() * locationRndm.size());
        WebElement locations = locationRndm.get(rndmLocation);
        System.out.println(locations.getText());
        locations.click();

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

    }


}
