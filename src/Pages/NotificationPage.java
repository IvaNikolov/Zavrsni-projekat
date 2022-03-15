package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage extends BasicPage {

	public NotificationPage(WebDriver driver, JavascriptExecutor javascriptExecutor, WebDriverWait waiter) {
		super(driver, javascriptExecutor, waiter);
		// TODO Auto-generated constructor stub
	}
public WebElement getMessage() {
	return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]\r\n" + 
			""));
}
public String getMessageText() {
	return this.getMessage().getText();
}
public void waitTillMessageGone() {
	this.waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'system_message')][contains(@style,'display: none;')]")));
}
}
