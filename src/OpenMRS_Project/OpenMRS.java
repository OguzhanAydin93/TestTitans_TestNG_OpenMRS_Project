package OpenMRS_Project;

import Utility.BaseDriver;
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

        wait.until(ExpectedConditions.elementToBeClickable(elementler.demo));
        elementler.demo.click();

        wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
        elementler.exploreOpenMRS2.click();

        wait.until(ExpectedConditions.elementToBeClickable(elementler.enterOpenMRS2Demo));
        elementler.enterOpenMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elementler.username.clear();
        elementler.password.clear();
        elementler.username.sendKeys(username);
        elementler.password.sendKeys(password);

        elementler.loginButton.click();

//        Assert.assertEquals(elementler.locationError.getText(), "You must choose a location!", "Bu Uyarı Bulunamadı");
        elementler.locationSelect.click();
        elementler.loginButton.click();
//        Assert.assertEquals(elementler.usernamePasswordError.getText(), "Invalid username/password. Please try again.", "Bu Uyarı Bulunamadı");

        if (
                ((elements.userName.equals("null1")) ||
                        (elements.userName.equals("null2")) ||
                        (elements.userName.equals("null3")) ||
                        (elements.userName.equals("null4")) ||
                        (elements.userName.equals("null5")) ||
                        (elements.userName.equals("null6")))
                        &&
                        elements.password.equals("null1")) {
            Assert.assertEquals(elementler.locationError.getText(), "You must choose a location!", "Bu Uyarı Bulunamadı");
            Assert.assertEquals(elementler.usernamePasswordError.getText(), "Invalid username/password. Please try again.", "Bu Uyarı Bulunamadı");
        }

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
