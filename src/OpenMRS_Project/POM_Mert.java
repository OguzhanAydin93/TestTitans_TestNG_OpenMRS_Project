package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Mert {
    public POM_Mert(){PageFactory.initElements(BaseDriver.driver, this);}

    @FindBy (css = "[class='zak-header-button zak-header-button--1']")
    public WebElement demoButton;



}
