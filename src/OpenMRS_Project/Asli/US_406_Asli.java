package OpenMRS_Project.Asli;

import Utility.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_406_Asli extends BaseDriver {

    @Test
    public void US_406_Asli() {



        driver.get("https://openmrs.org/demo/");
        Asli_POM elements = new Asli_POM();
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;


        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.OpenMRS2Button));
        elements.OpenMRS2Button.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.enterOpenMrs2Button));
        js.executeScript("arguments[0].scrollIntoView(true);", elements.enterOpenMrs2Button);
        js.executeScript("arguments[0].click();", elements.enterOpenMrs2Button);

        wait.until(ExpectedConditions.elementToBeClickable(elements.usernameInput));
        elements.usernameInput.sendKeys("admin");

        wait.until(ExpectedConditions.elementToBeClickable(elements.passwordInput));
        elements.passwordInput.sendKeys("Admin123");

        wait.until(ExpectedConditions.elementToBeClickable(elements.inpatientWard));
        elements.inpatientWard.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.loginButton));
        elements.loginButton.click();

        Assert.assertEquals(elements.assert1.getText(), "Logged in as Super User (admin) at Inpatient Ward.", "Oluşan Mesajlar Eşleşmiyor");

        wait.until(ExpectedConditions.elementToBeClickable(elements.findPatientRecord));
        elements.findPatientRecord.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.hastaArama));
        elements.hastaArama.sendKeys("100HNY");
        elements.patientRow.click();



        Assert.assertTrue(driver.getCurrentUrl().contains("patientId"));


        driver.navigate().back();

        wait.until(ExpectedConditions.elementToBeClickable(elements.hastaArama));
        elements.hastaArama.sendKeys("Asli", Keys.ENTER);

        Assert.assertTrue(elements.no.isDisplayed(), "Ulaşılmadı");


    }

}
