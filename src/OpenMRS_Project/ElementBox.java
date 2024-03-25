package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementBox {

    public ElementBox(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

//    @FindBy(css = "[class='gt_float_switcher-arrow']")
//    public WebElement language;
//
//    @FindBy(css = "[data-gt-lang='en']")
//    public WebElement languageSelect;

    /*******************Us-401****************/

    @FindBy(linkText = "Gösteri")
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
