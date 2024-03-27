package OpenMRS_Project;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenMRS extends BaseDriver {


    @Test(dataProvider = "Sifrelerim")
    public void US_401_Oguzhan(String username, String password) {

        driver.get("https://openmrs.org/demo/");

        ElementBox elementler = new ElementBox();

        elementler.demo.click();

        wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
        elementler.exploreOpenMRS2.click();

        wait.until(ExpectedConditions.elementToBeClickable(elementler.enterOpenMRS2Demo));
        MyFunc.bekle(1);
        elementler.enterOpenMRS2Demo.click();

        wait.until(ExpectedConditions.visibilityOf(elementler.username));
        elementler.username.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(elementler.password));
        elementler.password.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(elementler.loginButton));
        elementler.loginButton.click();

        elementler.locationSelect.click();
        Assert.assertTrue(elementler.locationError.getText().contains("You must choose a location!"));
        elementler.loginButton.click();
        Assert.assertTrue(elementler.usernamePasswordError.getText().contains("Invalid username/password. Please try again."));

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
        POM_Mert elements = new POM_Mert();

        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.exploreButton));
        elements.exploreButton.click();
        MyFunc.bekle(2);
        elements.enterMrsButton.click();
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

    @Test
    public void US_405_Zehra(){
        Zehra_POM elements=new Zehra_POM();
        elements.login();
        new Actions(driver).moveToElement(elements.admin).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(elements.myAccount));
        elements.myAccount.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.passwordLanguages));

        for (WebElement dogrula : elements.passwordLanguages) {
            System.out.println(dogrula.getText());
            Assert.assertTrue(dogrula.isDisplayed(),"Change password ve My Languages bulunamadı.");
        }

        elements.changePassword.click();
        wait.until(ExpectedConditions.urlContains("changePassword"));
        driver.navigate().back();
        elements.myLanguages.click();
        wait.until(ExpectedConditions.urlContains("changeDefaults"));
        driver.navigate().back();

    }
    @Test
    public void US_407_Zehra(){
        Zehra_POM elements=new Zehra_POM();
        elements.login();

        elements.patientRecord.click();
        elements.patientSearch.sendKeys("Nilgun" + Keys.ENTER);
        elements.patientInfo.click();
        wait.until(ExpectedConditions.urlContains("patientId"));





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
