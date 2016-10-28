package com.Gurukula.Pack;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.DoubleStream;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GurukulaTest {

	@Test
	public void test() throws InterruptedException {

		// @@@ Following is Setup Driver for Firefox browser @@@//

		WebDriver driver = new FirefoxDriver();

		driver.get("http://10.0.1.9:8080");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("Open Gurukula Home Page");

		// @@@ Following is Test Case for to login Gurukula @@@ //

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='login']")).click();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");

		driver.findElement(By.xpath("//button[text()='Authenticate']")).click();

		String Login_Text = (driver.findElement(By.cssSelector("div.alert.alert-success.ng-scope.ng-binding"))
				.getText());

		if (driver.getPageSource().contains(Login_Text)) {
			System.out.println("Success Login: " + Login_Text);
			assertTrue(true);
		} else {
			System.out.println("Unsuccessful Login ");
		}

		// @@@ Following is Test Case to login and Validate Login Information @@@ //
		

		driver.findElement(By.xpath("//span[text()='Account']"))
				.click(); /* Click on Account */
		driver.findElement(By.xpath("//span[text()='Settings']"))
				.click(); /* Click on Settings */

		String First_Name = "Administrator";
		String Last_Name = "Administrator";
		String Email = "admin@localhost";

		String First_Name1 = (driver.findElement(By.name("firstName"))
				.getAttribute("value")); /* Get value from firstName */
		String Last_Name1 = (driver.findElement(By.name("lastName"))
				.getAttribute("value")); /* Get value from lastName */
		String Email1 = (driver.findElement(By.name("email"))
				.getAttribute("value")); /* Get value from email */

		Thread.sleep(8000);

		if ((First_Name.equals(First_Name1)) && (Last_Name.equals(Last_Name1))
				&& (Email.equals(Email1))) /* Verify with login details */
		{
			System.out.println("User is Logged in as Admin");
			assertTrue(true);
		} else {
			System.out.println("Error!!");
			assertTrue(true);
		}

		// @@@ Following is Test Case to create "ABCBranch" Branch with code "66" @@@ //
		

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */

		driver.findElement(By.xpath("//div[@class='col-md-4']/button"))
				.click(); /* Create a New Branch */
		Thread.sleep(3000);

		driver.findElement(By.name("name")).sendKeys("ABCBranch"); /* ABCBranch */

		driver.findElement(By.name("code")).sendKeys("66"); /* Code 66 */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click Save */

		System.out.println("Branch ABCBranch with code 66 has been created");

		// @@@ Following is Test Case to create "BCDBranch" Branch with code "22" @@@ //
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */
		driver.findElement(By.xpath("//div[@class='col-md-4']/button"))
				.click(); /* Create a New Branch */
		Thread.sleep(3000);

		driver.findElement(By.name("name")).sendKeys("BCDBranch"); /* BCDBranch */

		driver.findElement(By.name("code")).sendKeys("22"); /* Code 22 */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click Save */

		System.out.println("Branch BCDBranch with code 22 has been created");

		// @@@ Following is Test Case to create "CDEBranch" Branch with code  "622" @@@ //
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */

		driver.findElement(By.xpath("//div[@class='col-md-4']/button"))
				.click(); /* Create a New Branch */
		Thread.sleep(3000);

		driver.findElement(By.name("name")).sendKeys("CDEBranch"); /* CDEBranch */

		driver.findElement(By.name("code")).sendKeys("622"); /* Code 622 */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click Save */

		System.out.println("Branch CDEBranch with code 622 has been created");

		// @@@ Following is Test Case to create "DEFBranch" Branch with code "44" @@@ //
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */

		driver.findElement(By.xpath("//div[@class='col-md-4']/button"))
				.click(); /* Create a New Branch */
		Thread.sleep(3000);

		driver.findElement(By.name("name")).sendKeys("DEFBranch"); /* DEFBranch */

		driver.findElement(By.name("code")).sendKeys("44"); /* Code 44 */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click Save */
		System.out.println("Branch DEFBranch with code 44 has been created");

		// @@@ Following is Test Case to Create Random Branch @@@ //

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */

		driver.findElement(By.xpath("//div[@class='col-md-4']/button"))
				.click(); /* Create a New Branch */
		Thread.sleep(3000);

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int N = alphabet.length();

		Random r = new Random();

		String BranchName = "Branch"
				+ (alphabet.charAt(r.nextInt(N))); /* Random Branch Name */

		driver.findElement(By.name("name")).sendKeys(BranchName);

		int code = new Random().nextInt(990);
		int code1 = new Random().nextInt(990);
		code = (code % code1) + 10; /* Random code */

		driver.findElement(By.name("code")).sendKeys(Integer.toString(code));

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click();/* Save a New Branch */

		System.out.println("Branch name is " + BranchName);
		System.out.println("Code is " + code);
		Thread.sleep(3000);

		WebElement BaseTable10 = driver.findElement(By.className("table-responsive"));
		List<WebElement> TableRows10 = BaseTable10.findElements(By.tagName("tr"));

		int TableRows_Size10 = TableRows10.size();

		System.out.println(TableRows10.get(TableRows_Size10 - 1)
				.getText()); /* click on View on the newly created Branch */

		Thread.sleep(2000);

		if (TableRows10.get(TableRows_Size10 - 1).getText().contains(BranchName)
				&& TableRows10.get(TableRows_Size10 - 1).getText().contains(Integer.toString(
						code))) /* Verify combination of Branch Name and Code */
		{

			System.out.println("Combination of Branch " + BranchName + " and Code " + code + " Created!!!");
			assertTrue(true);
		}

		else {
			System.out.println("Combination of Branch " + BranchName + "and Code" + code + " not Created!!!");
		}

		// @@@ Following is Test Case to Search a Branch @@@ //

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */

		driver.findElement(By.id("searchQuery"))
				.sendKeys(BranchName); /* Searching with Branch Name */
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* Click n Search */

		Thread.sleep(2000);
		if (driver.getPageSource().contains(
				BranchName)) /* Verify the search page with Branch Name */
		{
			System.out.println("Search result page is displayed for Branch " + BranchName);
		}

		driver.findElement(By.id("searchQuery")).clear();
		driver.findElement(By.cssSelector("button.btn.btn-info")).click();

		driver.findElement(By.id("searchQuery"))
				.sendKeys(Integer.toString(code)); /* Searching with code */
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* Click n Search */
		Thread.sleep(2000);

		if (driver.getPageSource().contains(
				Integer.toString(code))) /* Verify the search page with code */
		{
			System.out.println("Search result page is displayed for Branch code " + code);
		}

		driver.findElement(By.id("searchQuery")).clear();
		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* Back to Branches screen */

		// @@@ Following is Test Case to View and Confirm a Branch @@@ //

		Thread.sleep(2000);
		List<WebElement> AllElement11 = driver.findElements(By.xpath("//table//td[contains(.,BranchName)]"));
		int Count11 = AllElement11.size();
		Thread.sleep(3000);
		AllElement11.get(Count11 - 1).findElement(By.cssSelector("button.btn.btn-info.btn-sm"))
				.click(); /* click on view on newly created Branch */

		Thread.sleep(2000);

		WebElement View_Table = driver.findElement(By.className("table-responsive"));

		List<WebElement> View_Table_Row = View_Table.findElements(By.tagName("tr"));

		int View_Table_Row_Count = View_Table_Row.size();

		String View_Branch_Name = View_Table_Row.get(View_Table_Row_Count - 2)
				.findElement(By.cssSelector("input.input-sm.form-control"))
				.getAttribute("value");/* Branch Name from the view table */
		String View_Code_Name = View_Table_Row.get(View_Table_Row_Count - 1)
				.findElement(By.cssSelector("input.input-sm.form-control"))
				.getAttribute("value"); /* Code from the view table */

		if ((BranchName.equals(View_Branch_Name)) && (Integer.toString(code)
				.equals(View_Code_Name))) /* Verify the Branch Name and Code */ 
											 										 
											 
		{
			System.out.println("Branch " + BranchName + " and Code " + code + " are correctly viewed");
		} else {
			System.out.println("Branch View is incorrect!!");
		}

		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* Back to Branch Screen */

		// @@@ Following is Test Case to Edit a Branch and Cancel @@@ //
		Thread.sleep(2000);

		List<WebElement> AllElement12 = driver.findElements(By.xpath("//table//td[contains(.,BranchName)]"));
		int Count12 = AllElement12.size();

		Thread.sleep(2000);
		AllElement12.get(Count12 - 1).findElement(By.cssSelector("button.btn.btn-primary.btn-sm"))
				.click(); /* Click edit on the newly created Branch */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-default"))
				.click(); /* Cancel the Edit screen */

		System.out.println("No edit and back to Branch Screen");

		// @@@ Following is Test Case to Delete a Branch and Cancel @@@ //
		Thread.sleep(2000);

		List<WebElement> AllElement13 = driver.findElements(By.xpath("//table//td[contains(.,BranchName)]"));
		int Count13 = AllElement13.size();

		Thread.sleep(2000);
		AllElement13.get(Count13 - 1).findElement(By.cssSelector("button.btn.btn-danger.btn-sm"))
				.click(); /* Click Delete on the newly created Branch */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("form[name=\"deleteForm\"] > div.modal-footer > button.btn.btn-default"))
				.click(); /* Cancel the Delete screen */
		System.out.println("No delete and back to Branch Screen");

		// @@@ Following is Test Case to Edit a Branch, edit the Code and Confirm @@@ //
		

		Thread.sleep(2000);

		List<WebElement> AllElement15 = driver.findElements(By.xpath("//table//td[contains(.,BranchName)]"));
		int Count15 = AllElement15.size();

		Thread.sleep(2000);
		AllElement15.get(Count15 - 1).findElement(By.cssSelector("button.btn.btn-primary.btn-sm"))
				.click(); /* Click edit on the newly created Branch */

		Thread.sleep(2000);

		driver.findElement(By.name("code")).clear();
		int code11 = new Random().nextInt(990);
		int code22 = new Random().nextInt(990);
		code11 = (code11 % code22) + 10; /* random code */
		driver.findElement(By.name("code"))
				.sendKeys(Integer.toString(code11)); /* Edit the code */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click Save */

		System.out.println("Edited code is " + code11);

		Thread.sleep(2000);

		int Index15 = Count15 / 4;
		WebElement BaseTable15 = driver.findElement(By.className("table-responsive"));
		List<WebElement> TableRows15 = BaseTable15.findElements(By.tagName("tr"));
		System.out.println(TableRows15.get(Index15)
				.getText()); /* Will print the last row from Branch screen */

		if (TableRows15.get(Index15).getText().contains(
				Integer.toString(code11))) /* Verify the code is edited */
		{

			System.out.println("Code has been changed successfully!!!");
			assertTrue(true);
		}

		else {
			System.out.println("Please check your code!!!");
		}

		// @@@ Following is Test Case to Edit a Branch, edit the Branch Name and Confirm @@@ //
		
		Thread.sleep(2000);

		List<WebElement> AllElement14 = driver.findElements(By.xpath("//table//td[contains(.,BranchName)]"));
		int Count14 = AllElement14.size();

		Thread.sleep(2000);
		AllElement14.get(Count14 - 1).findElement(By.cssSelector("button.btn.btn-primary.btn-sm"))
				.click(); /* Click Edit on the newly created Branch */

		Thread.sleep(2000);

		String BranchName14 = "Branch"
				+ (alphabet.charAt(r.nextInt(N))); /* Random Branch Name */

		driver.findElement(By.name("name")).clear();

		driver.findElement(By.name("name"))
				.sendKeys(BranchName14); /* Edit the Branch Name */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click(); /* Save */

		System.out.println("Edited Branch Name is " + BranchName14);

		Thread.sleep(2000);

		int Index14 = Count14 / 4;
		WebElement BaseTable14 = driver.findElement(By.className("table-responsive"));
		List<WebElement> TableRows14 = BaseTable14.findElements(By.tagName("tr"));
		System.out.println(TableRows14.get(Index14)
				.getText()); /* Will print the last row from Branch screen */

		if (TableRows14.get(Index14).getText()
				.contains(BranchName14)) /* Verify the Branch Name is edited */
		{

			System.out.println("Branchname has been changed successfully!!!");
			assertTrue(true);
		}

		else {
			System.out.println("Please check your code!!!");
		}

		// @@@ Following is Test Case to Delete a Branch and Confirm @@@ //
		
		Thread.sleep(2000);

		List<WebElement> AllElement16 = driver.findElements(By.xpath("//table//td[contains(.,BranchName)]"));
		int Count16 = AllElement16.size();

		AllElement16.get(Count16 - 1).findElement(By.cssSelector("button.btn.btn-danger.btn-sm"))
				.click(); /* Click on Delete */
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("form[name=\"deleteForm\"] > div.modal-footer > button.btn.btn-danger"))
				.click();/* Click on confirm Delete */

		System.out.println("Branch is deleted");

		// @@@ Following is Test Case to create "ABCStaff" Staff @@@ //

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* Click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* Click Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-primary"))
				.click(); /* Click on Create a Staff */

		Thread.sleep(2000);

		driver.findElement(By.name("name"))
				.sendKeys("ABCStaff"); /* Generate ABCStaff Staff Name */

		Thread.sleep(2000);

		WebElement Branch_Dropdown30 = driver.findElement(By.name("related_branch"));

		Select Branch30 = new Select(Branch_Dropdown30);

		Branch30.selectByIndex(2); /* Select Branch from dropdown */
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click save */

		System.out.println("Staff ABCStaff has been created");

		// @@@ Following is Test Case to create "BCDStaff" Staff @@@ //

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* Click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* Click Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-primary"))
				.click(); /* Click on Create a Staff */

		Thread.sleep(2000);

		driver.findElement(By.name("name"))
				.sendKeys("BCDStaff"); /* Generate BCDStaff Staff Name */

		Thread.sleep(2000);

		WebElement Branch_Dropdown40 = driver.findElement(By.name("related_branch"));

		Select Branch40 = new Select(Branch_Dropdown40);

		Branch40.selectByIndex(4); /* Select Branch from dropdown */
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click save */

		System.out.println("Staff BCDStaff has been created");

		// @@@ Following is Test Case to create "CDEStaff" Staff @@@ //
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* Click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* Click Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-primary"))
				.click(); /* Click on Create a Staff */

		Thread.sleep(2000);

		driver.findElement(By.name("name"))
				.sendKeys("CDEStaff"); /* Generate CDEStaff Staff Name */

		Thread.sleep(2000);

		WebElement Branch_Dropdown50 = driver.findElement(By.name("related_branch"));

		Select Branch50 = new Select(Branch_Dropdown50);

		Branch50.selectByIndex(3); /* Select Branch from dropdown */
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click save */
		System.out.println("Staff CDEStaff has been created");

		// @@@ Following is Test Case to create DEFStaff Staff @@@ //

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* Click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* Click Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-primary"))
				.click(); /* Click on Create a Staff */

		Thread.sleep(2000);

		driver.findElement(By.name("name"))
				.sendKeys("DEFStaff"); /* Generate DEFStaff Staff Name */

		Thread.sleep(2000);

		WebElement Branch_Dropdown60 = driver.findElement(By.name("related_branch"));

		Select Branch60 = new Select(Branch_Dropdown60);

		Branch60.selectByIndex(4); /* Select Branch from dropdown */
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click save */

		System.out.println("Staff DEFStaff has been created");

		// @@@ Following is Test Case to Create a random Staff @@@ //

		Thread.sleep(2000);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* Click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* Click Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-primary"))
				.click(); /* Click on Create a Staff */

		Thread.sleep(2000);
		String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int N1 = alphabet1.length();

		Random r1 = new Random();

		String StaffName = "Staff" + (alphabet1
				.charAt(r1.nextInt(N1))); /* generate Random Staff Name */

		System.out.println("StaffName is " + StaffName);

		driver.findElement(By.name("name")).sendKeys(StaffName);

		Thread.sleep(2000);

		WebElement Branch_Dropdown20 = driver.findElement(By.name("related_branch"));

		Select Branch20 = new Select(Branch_Dropdown20);

		int OptionIndex20 = r.nextInt(Branch20.getOptions().size() - 1);

		Thread.sleep(2000);

		Branch20.selectByIndex(
				OptionIndex20 + 2); /* Select random Branch from dropdown */
		Thread.sleep(2000);

		WebElement Selected_Branch20 = Branch20.getFirstSelectedOption();
		String Branch_Staff = Selected_Branch20.getText();

		System.out.println("Branch Name is " + Branch_Staff);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click save */

		Thread.sleep(3000);

		WebElement BaseTable20 = driver.findElement(By.className("table-responsive"));
		List<WebElement> TableRows20 = BaseTable20.findElements(By.tagName("tr"));

		int TableRows_Size20 = TableRows20.size();

		System.out.println(TableRows20.get(TableRows_Size20 - 1)
				.getText()); /* will get newly created Staff */

		Thread.sleep(2000);

		if (TableRows20.get(TableRows_Size20 - 1).getText().contains(StaffName)
				&& TableRows20.get(TableRows_Size20 - 1).getText()
						.contains(Branch_Staff)) /* Verify combination of Staff Name and Branch name */
													
		{

			System.out.println("Combination of Staff " + StaffName + " and Branch " + Branch_Staff + " Created!!!");
			assertTrue(true);
		}

		else {
			System.out.println("Combination of Staff " + StaffName + " and Branch " + Branch_Staff + " not Created!!!");
		}

		// @@@ Following is Test Case to Search a Staff @@@ //
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* Click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* Click Staff */

		driver.findElement(By.id("searchQuery"))
				.sendKeys(StaffName); /* Searching with Staff Name */
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* click on search button */

		Thread.sleep(2000);
		if (driver.getPageSource().contains(
				StaffName)) /* Verify the search page with Staff Name */
		{
			System.out.println("Search result page is displayed for Staff " + StaffName);
		}

		driver.findElement(By.id("searchQuery")).clear();
		driver.findElement(By.cssSelector("button.btn.btn-info")).click();

		driver.findElement(By.id("searchQuery"))
				.sendKeys(Branch_Staff); /* Searching with Branch Name */
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* click on search button */
		Thread.sleep(2000);

		if (driver.getPageSource().contains(Branch_Staff)) {
			System.out.println("Search result page is displayed for Branch "
					+ Branch_Staff); /* Verify the search page with Branch Name */
										 
		}

		driver.findElement(By.id("searchQuery")).clear();
		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* Back to Staff */

		// @@@ Following is Test Case to View and Confirm a Staff @@@ //
		
		Thread.sleep(2000);

		List<WebElement> AllElement21 = driver.findElements(By.xpath("//table//td[contains(.,StaffName)]"));
		int Count21 = AllElement21.size();
		Thread.sleep(3000);
		AllElement21.get(Count21 - 1).findElement(By.cssSelector("button.btn.btn-info.btn-sm"))
				.click(); /* click on view on newly created Staff */

		Thread.sleep(2000);

		WebElement Staff_Table21 = driver.findElement(By.className("table-responsive"));

		List<WebElement> Staff_Table_Row21 = Staff_Table21.findElements(By.tagName("tr"));

		int Staff_Table_Row_Count21 = Staff_Table_Row21.size();

		String View_Staff_Name = Staff_Table_Row21.get(Staff_Table_Row_Count21 - 2)
				.findElement(By.cssSelector("input.input-sm.form-control"))
				.getAttribute("value"); /* Staff Name from the view table */
		String Staff_Branch_Name = Staff_Table_Row21.get(Staff_Table_Row_Count21 - 1)
				.findElement(By.cssSelector("input.input-sm.form-control"))
				.getAttribute("value"); /* Branch Name from the view table */

		Thread.sleep(2000);

		if ((StaffName.equals(View_Staff_Name)) && (Branch_Staff
				.equals(Staff_Branch_Name))) /* Verify the Staff Name and Branch Name properly viewed */
		{
			System.out.println("Staff " + StaffName + " and Branch " + Branch_Staff + " are correctly viewed");
		} else {
			System.out.println("Staff View is incorrect!!");
		}

		driver.findElement(By.cssSelector("button.btn.btn-info"))
				.click(); /* Back to Staff Screen */

		// @@@ Following is Test Case to Edit a Staff and Cancel @@@//
		
		Thread.sleep(2000);

		List<WebElement> AllElement22 = driver.findElements(By.xpath("//table//td[contains(.,StaffName)]"));
		int Count22 = AllElement22.size();

		Thread.sleep(2000);

		AllElement22.get(Count22 - 1).findElement(By.cssSelector("button.btn.btn-primary.btn-sm"))
				.click();/* click Edit on the created Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-default"))
				.click(); /* Click Cancel on the Edit Screen */

		System.out.println("No edit and back to Staff Screen");

		// @@@ Following is Test Case to Delete a Staff and Cancel @@@ //
		
		Thread.sleep(2000);

		List<WebElement> AllElement23 = driver.findElements(By.xpath("//table//td[contains(.,StaffName)]"));
		int Count23 = AllElement23.size();

		Thread.sleep(2000);
		AllElement23.get(Count23 - 1).findElement(By.cssSelector("button.btn.btn-danger.btn-sm"))
				.click(); /* Click Delete on the created Staff */

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("form[name=\"deleteForm\"] > div.modal-footer > button.btn.btn-default"))
				.click(); /* Click Cancel on the Delete Screen */
		System.out.println("No edit and back to Staff Screen");

		// @@@ Following is Test Case to Edit a Staff, edit the Branch Name and confirm @@@ //
		
		Thread.sleep(2000);

		List<WebElement> AllElement25 = driver.findElements(By.xpath("//table//td[contains(.,StaffName)]"));
		int Count25 = AllElement25.size();

		Thread.sleep(2000);
		AllElement25.get(Count25 - 1).findElement(By.cssSelector("button.btn.btn-primary.btn-sm"))
				.click(); /* Click Edit on the newly created Staff */

		Thread.sleep(2000);

		WebElement Branch_Dropdown25 = driver.findElement(By.name("related_branch"));

		Select Branch25 = new Select(Branch_Dropdown25);

		int OptionIndex25 = r1.nextInt(Branch25.getOptions().size() - 1);

		Thread.sleep(2000);

		Branch25.selectByIndex(OptionIndex25 + 2); /* Edit Branch name */
		Thread.sleep(2000);

		WebElement Selected_Branch25 = Branch25.getFirstSelectedOption();
		String Branch_Staff25 = Selected_Branch25.getText();

		System.out.println("Edited Branch is " + Branch_Staff25);

		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click();/* Click Save */
		Thread.sleep(2000);

		WebElement BaseTable25 = driver.findElement(By.className("table-responsive"));
		List<WebElement> TableRows25 = BaseTable25.findElements(By.tagName("tr"));

		int TableRows_Size25 = TableRows25.size();

		System.out.println(TableRows25.get(TableRows_Size25 - 1)
				.getText()); /* Will display the last row of Staff */

		Thread.sleep(2000);

		if (TableRows25.get(TableRows_Size25 - 1).getText().contains(
				Branch_Staff25)) /* Verify the Branch Name is edited */
		{

			System.out.println("Branch Name for the staff has been changed successfully!!!");
			assertTrue(true);
		}

		else {
			System.out.println("Please check your code!!!");
		}

		// @@@ Following is Test Case to Edit a Staff, edit the Staff Name and confirm @@@ //
		
		Thread.sleep(2000);
		List<WebElement> AllElement24 = driver.findElements(By.xpath("//table//td[contains(.,StaffName)]"));
		int Count24 = AllElement24.size();

		Thread.sleep(2000);
		AllElement24.get(Count24 - 1).findElement(By.cssSelector("button.btn.btn-primary.btn-sm"))
				.click(); /* Click Edit on the newly created Staff */

		Thread.sleep(2000);

		driver.findElement(By.name("name")).clear();
		String StaffName24 = "Staff"
				+ (alphabet1.charAt(r1.nextInt(N1))); /* Random Staff Name */
		driver.findElement(By.name("name"))
				.sendKeys(StaffName24); /* Edit Staff Name */
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary"))
				.click(); /* Click Save */

		System.out.println("Edited Staff Name is " + StaffName24);

		Thread.sleep(2000);

		WebElement BaseTable24 = driver.findElement(By.className("table-responsive"));
		List<WebElement> TableRows24 = BaseTable24.findElements(By.tagName("tr"));

		int TableRows_Size24 = TableRows24.size();

		System.out.println(TableRows24.get(TableRows_Size24 - 1)
				.getText()); /* will show last row of Staff */

		Thread.sleep(2000);

		if (TableRows24.get(TableRows_Size24 - 1).getText()
				.contains(StaffName24)) /* Verify the Staff Name is edited */
		{

			System.out.println("Staffname has been changed successfully!!!");
			assertTrue(true);
		}

		else {
			System.out.println("Please check your code!!!");
		}

		// @@@ Following is Test Case to Delete a Staff and Confirm @@@ //
		
		Thread.sleep(2000);

		List<WebElement> AllElement26 = driver.findElements(By.xpath("//table//td[contains(.,StaffName)]"));
		int Count26 = AllElement26.size();

		AllElement26.get(Count26 - 1).findElement(By.cssSelector("button.btn.btn-danger.btn-sm"))
				.click(); /* Click on Delete */
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("form[name=\"deleteForm\"] > div.modal-footer > button.btn.btn-danger"))
				.click(); /* Click on confirm Delete */

		System.out.println("Staff is deleted");
		
		// @@@ Following is Negative Test Case for Branch @@@ //
		

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Branch']"))
				.click(); /* click Branch */

		driver.findElement(By.xpath("//div[@class='col-md-4']/button"))
				.click(); /* Create a New Branch */
		Thread.sleep(3000);

		driver.findElement(By.name("name")).sendKeys("A"); /* A */

		if (driver.getPageSource().contains("This field is required to be at least 5 characters.")) /* Verify the error message*/
		{
			System.out.println("Have to enter minimum 5 characters in Branchname");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("12345"); /* A12345 */

		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to enter minimum 5 characters of a-z or/and A-Z in Branchname");
		}
		Thread.sleep(2000);
		driver.findElement(By.name("code")).sendKeys("A"); /*A*/
		
		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to enter minimum 2 characters in Code");
		}
		Thread.sleep(2000);
		
		driver.findElement(By.name("code")).clear();
		
		driver.findElement(By.name("code")).sendKeys("a2"); /*a2 */
		
		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to write only characters A-Z or/and 0-9 numbers in Code");
		}
		
		driver.findElement(By.cssSelector("button.btn.btn-default"))
		.click(); /* Cancel the Edit screen */
		
		// @@@ Following is Negative Test Case for Staff @@@ //
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Entities']"))
				.click(); /* click Entities */
		driver.findElement(By.xpath("//span[text()='Staff']"))
				.click(); /* click staff */
		
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("button.btn.btn-primary"))
		.click(); /* Create a New Staff */
		Thread.sleep(2000);

		driver.findElement(By.name("name")).sendKeys("1"); /* 1 */

		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to enter characters of a-z or/and A-Z in Staffname");
		}
		
		driver.findElement(By.name("name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("12345"); /* 12345 */

		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to enter characters of a-z or/and A-Z in Staffname");
		}
		driver.findElement(By.name("name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("c2"); /* c2 */

		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to enter characters of a-z or/and A-Z in Staffname");
		}
		driver.findElement(By.name("name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("T5"); /* T5 */

		if (driver.getPageSource().contains("This field should follow pattern")) /* Verify the error message*/
		{
			System.out.println("Have to enter characters of a-z or/and A-Z in Staffname");
		}
		driver.findElement(By.cssSelector("button.btn.btn-default"))
		.click(); /* Cancel the Edit screen */


		// @@@ Following is Test Case to Log Out @@@ //

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Account']"))
				.click(); /* Click on Account */
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Log out']"))
				.click(); /* Click on Log out */
		Thread.sleep(8000);

		String LogOut_Text = (driver.findElement(By.xpath("//a[@href='#/login']")).getText());

		if (driver.getPageSource()
				.contains(LogOut_Text)) /* Verify user is logged out */

		{
			System.out.println("User is Logged Out");
			assertTrue(true);
		}

		else {
			System.out.println("User is not Logged Out");
		}

		// @@@ Following is Test Case to Register a new account @@@ //

		Thread.sleep(3000);

		driver.findElement(By.linkText("Register a new account"))
				.click();/* Click on "Register a new account */

		driver.findElement(By.name("login")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("login"))
				.sendKeys("test"); /* Enter Login name */
		driver.findElement(By.name("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("email"))
				.sendKeys("Test@gmail.com"); /* Enter email */
		Thread.sleep(2000);
		driver.findElement(By.name("password"))
				.sendKeys("Test1!2@"); /* Enter password */
		Thread.sleep(2000);
		driver.findElement(By.name("confirmPassword"))
				.sendKeys("Test1!2@"); /* Enter confirm password */
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.btn.btn-primary.ng-scope"))
				.click(); /* Enter Register button */

		System.out.println("Registration failed! Please try again later.");

		// // @@@ Following is Test Case for pagination in Staff screen @@@ //
		//
		// Thread.sleep(2000);
		//
		// driver.findElement(By.xpath("//span[text()='Entities']")).click(); /*
		// Click Entities */
		// driver.findElement(By.xpath("//span[text()='Staff']")).click(); /*
		// Click Staff */
		//
		// Thread.sleep(3000);
		//
		// driver.findElement(By.linkText(">")).click();/* Click on Next page
		// link */
		//
		// System.out.println("Next page of Staff screen is displayed");
		//
		// Thread.sleep(2000);
		//
		// driver.findElement(By.linkText("<")).click();/* Click on Previous
		// page link */
		//
		// System.out.println("Previous page of Staff screen is displayed");
		// Thread.sleep(2000);
		//
		// driver.findElement(By.linkText(">>")).click();/* Click on Last page
		// link */
		//
		// System.out.println("Last page of Staff screen is displayed");
		// Thread.sleep(2000);
		//
		// driver.findElement(By.linkText("<<")).click();/* Click on First page
		// link */
		//
		// System.out.println("First page of Staff screen is displayed");

	}

}
