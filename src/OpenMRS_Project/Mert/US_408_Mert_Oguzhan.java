package OpenMRS_Project.Mert;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_408_Mert_Oguzhan extends BaseDriver {
    @Test()
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

}
