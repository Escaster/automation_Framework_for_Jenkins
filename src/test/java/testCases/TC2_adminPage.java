package testCases;

import baseClass.driverInstance;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.adminPage;
import utilities.commonMethods;
import utilities.excelUtility;

import java.io.IOException;

public class TC2_adminPage extends driverInstance
{

    @Test(dataProvider = "addnewuser")
    public void toadminsection(String username, String password, String newusername, String newpassword) throws IOException, InterruptedException
    {
        commonMethods cm = new commonMethods(driver);
        cm.loginactions(username, password);
        Thread.sleep(2000);
        adminPage ap = new adminPage(driver);
        ap.adminpage_usrmgm();
        ap.enternewUsername(newusername);
        ap.enternewpassword(newpassword);
        ap.enterconfirmpassword(newpassword);
        ap.tosavenewuser();
        Thread.sleep(2000);
        ap.searchcreateduser(newusername);
    }
    @DataProvider
    public Object[][] addnewuser() throws IOException {
        //Object[][] sample = new Object[][]{{"good jack","super@123"}};
        //return sample;
        Object[][] sample;
            excelUtility.setExcelfile("./src/test/resources/testData/Testdata.xlsx", "dataSheet");
            String testcaseName=this.getClass().getSimpleName();
            int startingTestcaseRow = excelUtility.getrowcontains(testcaseName,0);
            sample = excelUtility.getTableData(startingTestcaseRow);
        return (sample);
    }
}
