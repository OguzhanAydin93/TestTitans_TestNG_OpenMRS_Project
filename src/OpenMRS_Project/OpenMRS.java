package OpenMRS_Project;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenMRS extends BaseDriver {

    @Test()
    public void US_401_Oguzhan() {

        driver.get("https://openmrs.org/demo/");

        ElementBox elementler = new ElementBox();

        elementler.demo.click();
        wait.until(ExpectedConditions.visibilityOf(elementler.demo));

        wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
        elementler.exploreOpenMRS2.click();

        elementler.enterOpenMRS2Demo.click();

        elementler.username.sendKeys("null");

        elementler.password.sendKeys("null");

        elementler.loginButton.click();

        elementler.locationError.getText();
        Assert.assertEquals(elementler.locationError.getText(), "You must choose a location!", "Bu Uyarı Bulunamadı");

        elementler.locationSelect.click();

        elementler.loginButton.click();

        elementler.usernamePasswordError.getText();
        Assert.assertEquals(elementler.usernamePasswordError.getText(), "Invalid username/password. Please try again.", "Bu Uyarı Bulunamadı");


    }

    @Test
    public void US_402_Mert(){

    }
}
