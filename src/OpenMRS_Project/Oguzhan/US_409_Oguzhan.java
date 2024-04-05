package OpenMRS_Project.Oguzhan;

import OpenMRS_Project.Nuri.Nuri_POM;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US_409_Oguzhan extends BaseDriver {

    @Test
    public void US_409_Oguzhan() {
        ElementBox2 elementler2 = new ElementBox2();
        Nuri_POM elements = new Nuri_POM();
        elements.login();

        List<String> hastalar=new ArrayList<>();
        elementler2.searchPatient.click();
        elementler2.searchPatientBox.sendKeys("Nuri Er");
        MyFunc.bekle(1);
        elementler2.patientRow.click();
        hastalar.add(elementler2.patientId.getText());
        elementler2.homeButton.click();
        elementler2.searchPatient.click();
        elementler2.searchPatientBox.sendKeys("Oguzhan Aydın");
        MyFunc.bekle(1);
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

}
