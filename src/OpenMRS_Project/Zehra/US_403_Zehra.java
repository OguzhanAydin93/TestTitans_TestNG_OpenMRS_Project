package OpenMRS_Project.Zehra;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_403_Zehra extends BaseDriver {

    @Test()
    public void US_403_Zehra() {
        Zehra_POM elements = new Zehra_POM();
        elements.login();

        Assert.assertTrue(elements.superUser.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(elements.logout));
        elements.logout.click();
        wait.until(ExpectedConditions.urlContains("login"));

    }
}
