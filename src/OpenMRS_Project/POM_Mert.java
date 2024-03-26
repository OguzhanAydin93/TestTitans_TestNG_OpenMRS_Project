package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Mert {
    public POM_Mert(){PageFactory.initElements(BaseDriver.driver, this);}

    @FindBy (css = "[class='zak-header-button zak-header-button--1']>a")
    public WebElement demoButton;

    @FindBy (xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreButton;

    @FindBy (xpath = "(//span[@class='elementor-button-text'])[4]")
    public WebElement enterMrsButton;

    @FindBy (xpath = "//input[@class='form-control form-control-sm form-control-lg form-control-md']")
    public WebElement userName;

    @FindBy (xpath = "(//input[@class='form-control form-control-sm form-control-lg form-control-md'])[2]")
    public WebElement password;

    @FindBy (css = "[id='Inpatient Ward']")
    public WebElement location;

    @FindBy (css = "[class='btn confirm']")
    public WebElement logInButton;

    @FindBy (css = "[class='alert alert-danger']")
    public WebElement alertDanger;



}
