package Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor javascriptExecutor, WebDriverWait waiter) {
		super(driver, javascriptExecutor, waiter);
		// TODO Auto-generated constructor stub
	}

	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.name("user_email"));
	}

	public WebElement getPhoneNo() {
		return this.driver.findElement(By.name("user_phone"));
	}

	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}

	public Select getCountry() {
		WebElement country = this.driver.findElement(By.name("user_country_id"));
		return new Select(country);
	}

	public Select getState() {
		WebElement state = this.driver.findElement(By.name("user_state_id"));
		return new Select(state);
	}

	public Select getCity() {
		WebElement city = this.driver.findElement(By.name("user_city"));
		return new Select(city);
	}

	public WebElement getGeneralSaveBtn() {
		return this.driver.findElement(By.xpath("//div[1][contains(@class, 'col-sm-12')]//*[@name='btn_submit']"));
	}

	public WebElement getCurrentPassword() {
		return this.driver.findElement(By.name("current_password"));
	}

	public WebElement getConfirmPassword() {
		return this.driver.findElement(By.name("conf_new_password"));
	}

	public WebElement getPassSaveBtn() {
		return this.driver.findElement(By.xpath("//*[@id=\\\"frm_fat_id_changePwdFrm\\\"]/div/div[4]/fieldset/input"));
	}

	public WebElement getUploadProfilePic() {
		return this.driver.findElement(By.xpath("//*[@title='Upload']"));
	}

public WebElement getRemoveProfilePic() {
	return this.driver.findElement(By.xpath("//*[@title='Remove']"));

}
public void UploadProfilePic(String picPath) throws InterruptedException {
	javascriptExecutor = (JavascriptExecutor) driver;
	javascriptExecutor.executeScript("arguments[0].click();", this.getUploadProfilePic());
	Thread.sleep(1000);
	WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
	upload.sendKeys(picPath);
	}
	

public void RemoveProfilePic() {
	javascriptExecutor=(JavascriptExecutor) driver;
	javascriptExecutor.executeScript("arguments[0].click();",this.getRemoveProfilePic());
}
public void ChangePersonalInfo(String firstName,String lastName,String address, String phoneNo, String zipCode,String country, String state, String city) 
	                            throws InterruptedException {
		this.getFirstName().clear();
        this.getFirstName().sendKeys(firstName);
        this.getLastName().clear();
        this.getLastName().sendKeys(lastName);
        this.getAddress().clear();
        this.getAddress().sendKeys(address);
        this.getPhoneNo().clear();
        this.getPhoneNo().sendKeys(phoneNo);
        this.getZipCode().clear();
        this.getZipCode().sendKeys(zipCode);
        Thread.sleep(500);
        this.getCountry().selectByVisibleText(country);
        Thread.sleep(500);
        this.getState().selectByVisibleText(state);
        Thread.sleep(500);
        this.getCity().selectByVisibleText(city);
        Thread.sleep(500);
        this.getGeneralSaveBtn().click();
	}
	
}
	


