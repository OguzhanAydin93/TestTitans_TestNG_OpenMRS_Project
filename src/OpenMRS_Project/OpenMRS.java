package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenMRS extends BaseDriver {
    ElementBox elementler = new ElementBox();
    POM_Mert elements = new POM_Mert();

    @Test(dataProvider = "Sifrelerim")
    public void US_401_Oguzhan(String username, String password) {

        driver.get("https://openmrs.org/demo/");

        for (int i = 0; i < 6; i++) {


            elementler.demo.click();
            wait.until(ExpectedConditions.visibilityOf(elementler.demo));

            wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
            elementler.exploreOpenMRS2.click();

            wait.until(ExpectedConditions.elementToBeClickable(elementler.enterOpenMRS2Demo));
            elementler.enterOpenMRS2Demo.click();

            elementler.username.clear();
            elementler.password.clear();
            elementler.username.sendKeys(username + Keys.ENTER);
            elementler.password.sendKeys(password + Keys.ENTER);

            elementler.loginButton.click();

            System.out.println(elementler.locationError.getText());
            Assert.assertEquals(elementler.locationError.getText(), "You must choose a location!", "Bu Uyarı Bulunamadı");

            elementler.locationSelect.click();

            elementler.loginButton.click();

            System.out.println(elementler.usernamePasswordError.getText());
            Assert.assertEquals(elementler.usernamePasswordError.getText(), "Invalid username/password. Please try again.", "Bu Uyarı Bulunamadı");

        }

    }

    @DataProvider
    Object[][] Sifrelerim() {
        Object[][] kullaniciVeSifre =
                {
                        {"null1", "null2"},
                        {"null2", "null2"},
                        {"null3", "null3"},
                        {"null4", "null4"},
                        {"null5", "null5"},
                        {"null6", "null6"},

                };

        return kullaniciVeSifre;

    }

    @Test(dataProvider = "notSuccessfully")
    public void US_402_Mert(String userName, String password) {
        driver.get("https://openmrs.org/demo/");

        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.exploreButton));
        elements.exploreButton.click();
        elements.enterMrsButton.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        Select choose = new Select(elements.location);
        choose.selectByValue("6");
        elements.userName.sendKeys(userName);
        elements.password.sendKeys(password);
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
                        {"admin9", "admin1"}
                };
        return usernameAndPassword;
    }


}
