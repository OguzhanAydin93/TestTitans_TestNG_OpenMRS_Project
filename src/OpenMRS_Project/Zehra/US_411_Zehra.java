package OpenMRS_Project.Zehra;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_411_Zehra extends BaseDriver {

    @Test
    public void US_411_Zehra(){
        Zehra_POM elements = new Zehra_POM();
        elements.login();

        elements.appoinment.click();
        elements.manageAppoinment.click();
        wait.until(ExpectedConditions.urlContains("findPatient"));
        elements.appoinmentSearch.sendKeys("zehra");
        wait.until(ExpectedConditions.visibilityOf(elements.patientInfo));
        elements.patientInfo.click();
        wait.until(ExpectedConditions.urlContains("appointmentschedulingui"));
        Assert.assertFalse(elements.text.isDisplayed(),"Hata mesajı görüntülenemedi.");

    }

}
