package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor javascriptExecutor, WebDriverWait waiter) {
		super(driver, javascriptExecutor, waiter);
		// TODO Auto-generated constructor stub
	}
	public WebElement getUserDropdown() {
		return this.driver.findElement(By.xpath("//*[@class='filled ']/a"));
	}
	public WebElement getMyAccountBtn() {
		return this.driver.findElement(By.linkText("My Account"));
	}
	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.linkText("Logout"));
	}
	public void logout() {
		this.getUserDropdown().click();
        this.getLogoutBtn().click();
	}
}
