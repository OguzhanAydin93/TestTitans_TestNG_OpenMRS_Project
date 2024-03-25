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

    @FindBy (css = "[name='username']")
    public WebElement userName;

    @FindBy (css = "[name='password']")
    public WebElement password;

    @FindBy (css = "[class='select']")
    public WebElement location;

    @FindBy (css = "[class='btn confirm']")
    public WebElement logInButton;

    @FindBy (css = "[class='alert alert-danger']")
    public WebElement alertDanger;



}
