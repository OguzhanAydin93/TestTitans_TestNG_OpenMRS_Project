package OpenMRS_Project.Oguzhan;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_401_Oguzhan extends BaseDriver {
    @Test(dataProvider = "Sifrelerim")
    public void US_401_Oguzhan(String username, String password) {

        driver.get("https://openmrs.org/demo/");

        ElementBox elementler = new ElementBox();

        elementler.demo.click();
        wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
        elementler.js.executeScript("arguments[0].scrollIntoView(true);", elementler.exploreOpenMRS2);
        elementler.exploreOpenMRS2.click();
        wait.until(ExpectedConditions.elementToBeClickable(elementler.enterOpenMRS2Demo));
        elementler.js.executeScript("arguments[0].scrollIntoView(true);", elementler.enterOpenMRS2Demo);
        elementler.js.executeScript("arguments[0].click();", elementler.enterOpenMRS2Demo);
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
}
