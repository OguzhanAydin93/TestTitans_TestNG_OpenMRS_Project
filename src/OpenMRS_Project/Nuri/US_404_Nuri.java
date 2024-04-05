package OpenMRS_Project.Nuri;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_404_Nuri extends BaseDriver {

    @Test(dataProvider = "hastaKayit")
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

}
