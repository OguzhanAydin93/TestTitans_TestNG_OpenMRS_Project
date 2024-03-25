package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Zehra_POM {
    public Zehra_POM() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demoButton;
    @FindBy(xpath = "//*[text()='Explore OpenMRS 2']")
    public WebElement exploreOpenMRS2;
    @FindBy(xpath = "//*[text()='Enter the OpenMRS 2 Demo']")
    public WebElement enterOpenMRS2Demo;
    @FindBy(xpath = "//input[@placeholder='Enter your username']")
    public WebElement username;
    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    public WebElement password;
    @FindBy(xpath = "//ul[@id='sessionLocation']/li")
    public List<WebElement> locationRndm;
    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;
}
