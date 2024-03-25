package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenMRS extends BaseDriver {
    ElementBox elementler = new ElementBox();

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

    @Test
    public void US_402_Mert() {
        driver.get("https://openmrs.org/demo/");


    }

    @Test
    public void US_405_Zehra(){
        driver.get("https://openmrs.org/demo/");
    }


}
