package testCases;

import baseClass.driverInstance;
import org.testng.annotations.Test;
import page.leaveSection;
import utilities.commonMethods;

import java.io.IOException;

public class TC3_leaveList extends driverInstance
{
    @Test
    public void leavedates () throws IOException, InterruptedException {
        commonMethods cm = new commonMethods(driver);
        cm.loginactions("Admin", "admin123");
        leaveSection ls = new leaveSection();
        ls.selectleavesection();
        ls.selectfromdate("15","Jul");
        ls.selecttodate("30", "Oct");
        ls.testngdropdown("Finance");
        ls.selectcheckbox();
        ls.pastemployeecb();
        ls.tosearchleavepage();
    }
}
