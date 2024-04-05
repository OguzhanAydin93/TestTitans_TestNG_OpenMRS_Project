package OpenMRS_Project.Mert;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_402_Mert extends BaseDriver {

    @Test(dataProvider = "notSuccessfully")
    public void US_402_Mert(String userName, String password) {
        driver.get("https://openmrs.org/demo/");
        POM_Mert elements = new POM_Mert();

        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();

        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.exploreButton);
        wait.until(ExpectedConditions.elementToBeClickable(elements.exploreButton));
        elements.exploreButton.click();

        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.enterMrsButton);
        elements.js.executeScript("arguments[0].click();", elements.enterMrsButton);

        wait.until(ExpectedConditions.visibilityOf(elements.userName));
        elements.userName.sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(elements.password));
        elements.password.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(elements.location));
        elements.location.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.logInButton));
        elements.logInButton.click();

        if (
                ((userName.equals("admin")) ||
                        (userName.equals("admin1")) ||
                        (userName.equals("admin3")) ||
                        (userName.equals("admin5")) ||
                        (userName.equals("admin7")) ||
                        (userName.equals("admin9")))
                        &&
                        password.equals("admin1")) {
            Assert.assertTrue(elements.alertDanger.getText().toLowerCase().contains("ınvalid"));
        } else if (userName.equals("Admin") && password.equals("Admin123")) {
            Assert.assertTrue(elements.loginAccount.getText().contains("Logged"));


        }
    }

    @DataProvider
    Object[][] notSuccessfully() {
        Object[][] usernameAndPasswordd =
                {
                        {"admin", "admin1"},
                        {"admin1", "admin1"},
                        {"admin3", "admin1"},
                        {"admin5", "admin1"},
                        {"admin7", "admin1"},
                        {"admin9", "admin1"},
                        {"Admin", "Admin123"}
                };
        return usernameAndPasswordd;
    }
}
