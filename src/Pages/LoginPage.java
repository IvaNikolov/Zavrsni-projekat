package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor javascriptExecutor, WebDriverWait waiter) {
		super(driver, javascriptExecutor, waiter);
		// TODO Auto-generated constructor stub
	}

	public void getLoginPage() {
		this.driver.findElement(By.linkText("Login")).click();
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.name("username"));

	}

	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}

	public WebElement rememberMe() {
		return this.driver.findElement(By.name("checkbox"));
	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	public void login(String email, String password) throws InterruptedException {
		this.getEmail().clear();
		Thread.sleep(500);
		this.getEmail().sendKeys(email);
		this.getPassword().clear();
		Thread.sleep(500);
		this.getPassword().sendKeys(password);
		this.getLoginBtn().click();
	}
}
