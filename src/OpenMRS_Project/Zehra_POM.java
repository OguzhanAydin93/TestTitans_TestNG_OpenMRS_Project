package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zehra_POM {
    public Zehra_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demoButton;
}
