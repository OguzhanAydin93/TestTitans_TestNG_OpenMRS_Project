package OpenMRS_Project.Oguzhan;

import Utility.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementBox {

    public ElementBox(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    JavascriptExecutor js=(JavascriptExecutor) BaseDriver.driver;

    /*******************Us-401****************/

    @FindBy(css = "[class='zak-header-button zak-header-button--1']>a")
    public WebElement demo;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[4]")
    public WebElement enterOpenMRS2Demo;

    @FindBy(xpath = "//input[@class='form-control form-control-sm form-control-lg form-control-md']")
    public WebElement username;

    @FindBy(xpath = "(//input[@class='form-control form-control-sm form-control-lg form-control-md'])[2]")
    public WebElement password;

    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;

    @FindBy(css = "[id='Inpatient Ward']")
    public WebElement locationSelect;

    @FindBy(css = "[id='sessionLocationError']")
    public WebElement locationError;

    @FindBy(css = "[id='error-message']")
    public WebElement usernamePasswordError;

    /*******************Us-401****************/



}
