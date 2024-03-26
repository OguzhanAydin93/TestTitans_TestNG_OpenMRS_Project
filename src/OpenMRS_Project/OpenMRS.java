package OpenMRS_Project;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.apache.logging.log4j.core.jmx.AppenderAdmin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenMRS extends BaseDriver {



    @Test(dataProvider = "Sifrelerim")
    public void US_401_Oguzhan(String username, String password) {

        driver.get("https://openmrs.org/demo/");

        ElementBox elementler = new ElementBox();

        elementler.demo.click();

        wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
        elementler.exploreOpenMRS2.click();

        wait.until(ExpectedConditions.elementToBeClickable(elementler.enterOpenMRS2Demo));
        elementler.enterOpenMRS2Demo.click();

        wait.until(ExpectedConditions.visibilityOf(elementler.username));
        elementler.username.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(elementler.password));
        elementler.password.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(elementler.loginButton));
        elementler.loginButton.click();

        elementler.locationSelect.click();
        Assert.assertTrue(elementler.locationError.getText().contains("You must choose a location!"));
        elementler.loginButton.click();
        Assert.assertTrue(elementler.usernamePasswordError.getText().contains("Invalid username/password. Please try again."));

    }
    @DataProvider
    Object[][] Sifrelerim() {
        Object[][] kullaniciVeSifre =
                {
                        {"null1", "null1"},
                        {"null2", "null1"},
                        {"null3", "null1"},
                        {"null4", "null1"},
                        {"null5", "null1"},
                        {"null6", "null1"},

                };

        return kullaniciVeSifre;

    }

    @Test(dataProvider = "notSuccessfully")
    public void US_402_Mert(String userName, String password) {
        driver.get("https://openmrs.org/demo/");
        POM_Mert elements = new POM_Mert();

        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.exploreButton));
        elements.exploreButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.enterMrsButton));
        elements.enterMrsButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.userName));
        elements.userName.sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(elements.password));
        elements.password.sendKeys(password);
        elements.location.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.logInButton));
        elements.logInButton.click();

        if (
                ((elements.userName.equals("admin")) ||
                        (elements.userName.equals("admin1")) ||
                        (elements.userName.equals("admin3")) ||
                        (elements.userName.equals("admin5")) ||
                        (elements.userName.equals("admin7")) ||
                        (elements.userName.equals("admin9")))
                        &&
                        elements.password.equals("admin1")) {
            Assert.assertTrue(elements.alertDanger.getText().toLowerCase().contains("invalid"));
        } else if (elements.userName.equals("Admin") && elements.password.equals("Admin123")) {
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("home.page"));

        }

    }

    @DataProvider
    Object[][] notSuccessfully() {
        Object[][] usernameAndPassword =
                {
                        {"admin", "admin1"},
                        {"admin1", "admin1"},
                        {"admin3", "admin1"},
                        {"admin5", "admin1"},
                        {"admin7", "admin1"},
                        {"admin9", "admin1"},
                        {"Admin","Admin123"}
                };
        return usernameAndPassword;
    }

}
