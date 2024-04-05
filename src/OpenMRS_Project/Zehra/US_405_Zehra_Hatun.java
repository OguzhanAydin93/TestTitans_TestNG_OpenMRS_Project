package OpenMRS_Project.Zehra;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_405_Zehra_Hatun extends BaseDriver {

    @Test(groups = {"Smoke"})
    public void US_405_Zehra_Hatun() {
        Zehra_POM elements = new Zehra_POM();
        elements.login();

        new Actions(driver).moveToElement(elements.admin).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(elements.myAccount));
        elements.myAccount.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.passwordLanguages));

        for (WebElement dogrula : elements.passwordLanguages) {
            System.out.println(dogrula.getText());
            Assert.assertTrue(dogrula.isDisplayed(), "Change password ve My Languages bulunamadı.");
        }

        elements.changePassword.click();
        wait.until(ExpectedConditions.urlContains("changePassword"));
        driver.navigate().back();
        elements.myLanguages.click();
        wait.until(ExpectedConditions.urlContains("changeDefaults"));
        driver.navigate().back();

    }

}
