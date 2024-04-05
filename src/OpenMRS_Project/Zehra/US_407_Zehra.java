package OpenMRS_Project.Zehra;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_407_Zehra extends BaseDriver {

    @Test(dataProvider = "deletedPatient")
    public void US_407_Zehra(String patientDeleted) {
        Zehra_POM elements = new Zehra_POM();
        Actions actionDriver = new Actions(driver);
        elements.login();


        elements.patientRecord.click();
        elements.patientSearch.sendKeys(patientDeleted + Keys.ENTER);
        elements.patientInfo.click();
        wait.until(ExpectedConditions.urlContains("patientId"));
        elements.patientDelete.click();
        wait.until(ExpectedConditions.visibilityOf(elements.deleteReason));

        actionDriver.click(elements.deleteReason).click().build();
        actionDriver.sendKeys("Patient Request").build().perform();
        actionDriver.click(elements.confirmBtn).build().perform();

        wait.until(ExpectedConditions.urlContains("findPatient"));
        elements.patientSearch.sendKeys(patientDeleted + Keys.ENTER);
        Assert.assertTrue(elements.deleteConfirm.isDisplayed(), "Hasta silinemedi.");


    }


    @DataProvider
    Object[] deletedPatient() {
        Object[] dltdPatient = {"zehra"};
        return dltdPatient;

    }
}
