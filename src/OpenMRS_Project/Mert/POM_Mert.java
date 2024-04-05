package OpenMRS_Project.Mert;

import Utility.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class POM_Mert {
    public POM_Mert() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[class='zak-header-button zak-header-button--1']>a")
    public WebElement demoButton;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreButton;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[4]")
    public WebElement enterMrsButton;

    @FindBy(xpath = "//input[@class='form-control form-control-sm form-control-lg form-control-md']")
    public WebElement userName;

    @FindBy(xpath = "(//input[@class='form-control form-control-sm form-control-lg form-control-md'])[2]")
    public WebElement password;

    @FindBy(css = "[id='Inpatient Ward']")
    public WebElement location;

    @FindBy(css = "[class='btn confirm']")
    public WebElement logInButton;

    @FindBy(css = "[id='error-message']")
    public WebElement alertDanger;

    @FindBy(css = "[class='col-12 col-sm-12 col-md-12 col-lg-12']>h4")
    public WebElement loginAccount;

    @FindBy(css = "[class='icon-search']")
    public WebElement findPatientRecord;

    @FindBy(xpath = "//tbody[@aria-live='polite']//tr")
    public List<WebElement> hastaList;

    @FindBy(css = "[class='dataTables_info']")
    public WebElement showingEntries;


    JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;

    public static void Login() {
        BaseDriver.driver.navigate().to("https://openmrs.org/demo/");
        POM_Mert elements = new POM_Mert();

        BaseDriver.wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();
        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.exploreButton);
        BaseDriver.wait.until(ExpectedConditions.elementToBeClickable(elements.exploreButton));
        elements.exploreButton.click();
        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.enterMrsButton);
        elements.js.executeScript("arguments[0].click();", elements.enterMrsButton);
        BaseDriver.wait.until(ExpectedConditions.visibilityOf(elements.userName));
        elements.userName.sendKeys("Admin");
        elements.password.sendKeys("Admin123");
        BaseDriver.wait.until(ExpectedConditions.elementToBeClickable(elements.location));
        elements.location.click();
        BaseDriver.wait.until(ExpectedConditions.elementToBeClickable(elements.logInButton));
        elements.logInButton.click();
    }


}
