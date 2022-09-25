package actitime.testcases;

import SQAAssignment.base.TestBase;
import SQAAssignment.pages.HomePage;
import SQAAssignment.pages.LoginPage;
import SQAAssignment.pages.TimesheetPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TimesheetPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	TimesheetPage timesheetPage;

	public TimesheetPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		timesheetPage = homePage.clickOnTimeTrackingLink();
	}

	@Test(priority = 1)
	public void timeTrackingPageTest() {
		boolean flag = timesheetPage.validateTimeTrackingPage();
		Assert.assertTrue(flag, "Cannot find Page Header");
	}

	@Test(priority = 2)
	public boolean approveTimeSheet() {
		return timesheetPage.isReadyForApproval();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}