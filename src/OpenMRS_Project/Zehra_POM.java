package OpenMRS_Project;

import Utility.BaseDriver;
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
        PageFactory.initElements(driver,this);
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

    public void login(){
        driver.get("https://openmrs.org/demo/");


        demoButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", exploreOpenMRS2);

        exploreOpenMRS2.click();
        enterOpenMRS2Demo.click();
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