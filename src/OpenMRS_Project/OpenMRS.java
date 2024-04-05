package OpenMRS_Project;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class OpenMRS extends BaseDriver {


    @Test(dataProvider = "Sifrelerim", priority = 1)
    public void US_401_Oguzhan(String username, String password) {

        driver.get("https://openmrs.org/demo/");

        ElementBox elementler = new ElementBox();

        elementler.demo.click();
        wait.until(ExpectedConditions.elementToBeClickable(elementler.exploreOpenMRS2));
        elementler.js.executeScript("arguments[0].scrollIntoView(true);", elementler.exploreOpenMRS2);
        elementler.exploreOpenMRS2.click();
        wait.until(ExpectedConditions.elementToBeClickable(elementler.enterOpenMRS2Demo));
        elementler.js.executeScript("arguments[0].scrollIntoView(true);", elementler.enterOpenMRS2Demo);
        elementler.js.executeScript("arguments[0].click();", elementler.enterOpenMRS2Demo);
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

    @Test(dataProvider = "notSuccessfully", priority = 2)
    public void US_402_Mert(String userName, String password) {
        driver.get("https://openmrs.org/demo/");
        POM_Mert elements = new POM_Mert();

        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();

        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.exploreButton);
        wait.until(ExpectedConditions.elementToBeClickable(elements.exploreButton));
        elements.exploreButton.click();

        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.enterMrsButton);
        elements.js.executeScript("arguments[0].click();", elements.enterMrsButton);

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

    @Test(priority = 3)
    public void US_403_Zehra() {
        Zehra_POM elements = new Zehra_POM();
        elements.login();

        Assert.assertTrue(elements.superUser.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(elements.logout));
        elements.logout.click();
        wait.until(ExpectedConditions.urlContains("login"));

    }

    @Test(dataProvider = "hastaKayit", priority = 4)
    public void US_404_Nuri(String givenname, String middlename, String familyname, String birthday, String birthmounth, String birthyear, String addressname) {
        driver.get("https://openmrs.org/demo/");
        Nuri_POM elements = new Nuri_POM();
        elements.login();
        elements.js.executeScript("arguments[0].scrollIntoView(true);", elements.registerButton);
        elements.js.executeScript("arguments[0].click();", elements.registerButton);
        elements.givenName.sendKeys(givenname);
        elements.middleName.sendKeys(middlename);
        elements.familyName.sendKeys(familyname);
        elements.genderLabel.click();
        elements.male.click();
        elements.birthdayLabel.click();
        elements.birthdayDay.sendKeys(birthday);
        Select select = new Select(elements.birthdayMonth);
        select.selectByValue(birthmounth);
        elements.birthdayYear.sendKeys(birthyear);
        elements.adress.click();
        elements.adressName.sendKeys(addressname);
        elements.clickButton.click();
        elements.clickButton.click();
        elements.clickButton.click();
        elements.confirmBt.click();
        elements.homeButton.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("givenName")));
            System.out.println("Kayıt başarısız!");
        } catch (TimeoutException e) {
            System.out.println("Kayıt başarılı!");
        }


    }

    @DataProvider
    Object[][] hastaKayit() {
        Object[][] datalarim =
                {
                        {"Nuri", "Er", "technooo", "20", "5", "1991", "66628 Uluyol"},

                };

        return datalarim;

    }


    @Test(priority = 5)
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

    @Test(dataProvider = "deletedPatient", priority = 7)
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

    @Test(priority = 8)
    public void US_408_Mert_Oguzhan() {

        POM_Mert elements = new POM_Mert();
        POM_Mert.Login();
        elements.findPatientRecord.click();
        int indexOfF = (elements.showingEntries.getText().toLowerCase().lastIndexOf("f"));
        int indexOfE = (elements.showingEntries.getText().toLowerCase().indexOf("e"));
        String text = elements.showingEntries.getText().substring(indexOfF + 1, indexOfE).trim();
        int value = Integer.parseInt(text);
        int hastaSayisi = elements.hastaList.size();

        Assert.assertTrue(value == hastaSayisi, "Sayılar birbirine eşit değil.");

    }

    @Test
    public void US_406_Asli() {

        driver.get("https://openmrs.org/demo/");
        Asli_POM elements = new Asli_POM();


        wait.until(ExpectedConditions.elementToBeClickable(elements.demoButton));
        elements.demoButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.OpenMRS2Button));
        elements.OpenMRS2Button.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.enterOpenMrs2Button));
        elements.enterOpenMrs2Button.click();

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
        elements.hastaArama.sendKeys("100HNY", Keys.ENTER);


        Assert.assertTrue(driver.getCurrentUrl().contains("patientId"));


        driver.navigate().back();

        wait.until(ExpectedConditions.elementToBeClickable(elements.hastaArama));
        elements.hastaArama.sendKeys("Asli", Keys.ENTER);

        Assert.assertTrue(elements.no.isDisplayed(), "Ulaşılmadı");


    }

    @Test
    public void US_409_Oguzhan() {
        ElementBox2 elementler2 = new ElementBox2();
        Nuri_POM elements = new Nuri_POM();

        List<String> hastalar=new ArrayList<>();
        elements.login();
        elementler2.searchPatient.click();
        elementler2.searchPatientBox.sendKeys("Nuri Er");
//        MyFunc.bekle(1);
        wait.until(ExpectedConditions.stalenessOf(elementler2.searchPatientBox));
        wait.until(ExpectedConditions.elementToBeClickable(elementler2.patientRow));
        elementler2.patientRow.click();
        hastalar.add(elementler2.patientId.getText());
        elementler2.homeButton.click();
        elementler2.searchPatient.click();
        elementler2.searchPatientBox.sendKeys("Oguzhan Aydın");
//        MyFunc.bekle(1);
        wait.until(ExpectedConditions.stalenessOf(elementler2.searchPatientBox));
        wait.until(ExpectedConditions.elementToBeClickable(elementler2.patientRow));
        elementler2.patientRow.click();
        hastalar.add(elementler2.patientId.getText());
        elementler2.homeButton.click();
        elementler2.dataManagementButton.click();
        elementler2.mergeButton.click();
        elementler2.patient1.sendKeys(hastalar.get(0));
        elementler2.patient2.sendKeys(hastalar.get(1),Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(elementler2.continueButton));
        elementler2.continueButton.click();
        Assert.assertTrue(elementler2.mergindSuccess.getText().contains("Merging cannot be undone"));
        elementler2.preferredRecord.click();
        elementler2.continueButton.click();


    }

    @Test
    public void US_410_Zehra() {
        Zehra_POM elements = new Zehra_POM();
        elements.login();

        elements.appoinment.click();
        elements.manageAppoinment.click();
        wait.until(ExpectedConditions.urlContains("findPatient"));
        elements.appoinmentSearch.sendKeys("zehra");
        wait.until(ExpectedConditions.visibilityOf(elements.patientInfo));
        elements.patientInfo.click();
        wait.until(ExpectedConditions.urlContains("appointmentschedulingui"));
        Assert.assertTrue(elements.text.isDisplayed(),"Hata mesajı görüntülenemedi.");

    }
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





