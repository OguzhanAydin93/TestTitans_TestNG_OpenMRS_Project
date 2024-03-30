package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import static Utility.BaseDriver.driver;

public class Nuri_POM {
    public Nuri_POM() {
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

    @FindBy(css = "#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension > .icon-user")
    public WebElement registerButton;

    @FindBy(css = "[name='givenName']")
    public WebElement givenName;

    @FindBy(css = "[name='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='familyName']")
    public WebElement familyName;

    @FindBy(xpath = "//span[@id='genderLabel']")
    public WebElement genderLabel;

    @FindBy(xpath = "//option[.='Male']")
    public WebElement male;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    public WebElement birthdayLabel;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    public WebElement birthdayDay;
    @FindBy(css = "select[name='birthdateMonth']")
    public WebElement birthdayMonth;

    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    public WebElement birthdayYear;

    @FindBy(xpath = "//span[.='Address']")
    public WebElement adress;

    @FindBy(css = ".requireOne > p:nth-of-type(2) > [type='text']")
    public WebElement adressName;

    @FindBy(id = "next-button")
    public WebElement clickButton;

    @FindBy(xpath = "//input[@id='submit']")
    public WebElement confirmBt;

    @FindBy(css = "div[class='float-sm-right']>span")
    public WebElement patientID;

    JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;

}
