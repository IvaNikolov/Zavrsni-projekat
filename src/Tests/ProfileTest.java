package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProfilePage;

public class ProfileTest extends BasicTest {

	@Test(priority = 1)
	public void editProfileTest() throws InterruptedException {
		driver.get(baseUrl + "/guest-user/login-form");
		locationPopUpPage.closePopup();
		loginPage.login(email, password);
		Assert.assertTrue(notificationPage.getMessageText().contains("Login Successfull"), "Login ERROR");

		driver.get(baseUrl + "/member/profile");
		profilepage.ChangePersonalInfo("Pera", "Peric", "Milojka Lijesanina", "123456789", "18000", "India", "Delhi",
				"New Delhi");
		Thread.sleep(500);
		Assert.assertTrue(notificationPage.getMessageText().contains("SetUp Succesful"), "Setup ERROR");

		authPage.logout();
		Assert.assertTrue(notificationPage.getMessageText().contains("Logout Succesfull"), "Logout ERROR");
	}

	@Test(priority = 2)
	public void changeProfileImageTest() throws InterruptedException, IOException {
		this.driver.get(baseUrl + "/guest-user/login-form");
		locationPopUpPage.closePopup();
		loginPage.login(email, password);
		Assert.assertTrue(notificationPage.getMessageText().contains("Login Successfull"), "Login ERROR");

		driver.get(baseUrl + "/member/profile");
		String imgPath = new File("img/aurora-gd3399f207_640.jpg").getCanonicalPath();
	//	String imgPath = new File("C:\\Projekti\\Zavrsni-projekat\\img\\aurora-gd3399f207_640.jpg").getPath();
		profilepage.UploadProfilePic(imgPath);
		Thread.sleep(500);
		Assert.assertTrue(notificationPage.getMessageText().contains("Profile Image Uploaded Successfully"),
				"Profile picture upload ERROR");

		notificationPage.waitTillMessageGone();
		profilepage.RemoveProfilePic();
		Assert.assertTrue(notificationPage.getMessageText().contains("Profile Image Deleteded Successfully "),
				"Profile picture uploud ERROR");

		notificationPage.waitTillMessageGone();
		authPage.logout();
		Assert.assertTrue(notificationPage.getMessageText().contains("Logout Successfully!!! "), "Logout ERROR");

	}
}
