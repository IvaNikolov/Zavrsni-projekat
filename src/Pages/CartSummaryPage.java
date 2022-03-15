package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver, JavascriptExecutor javascriptExecutor, WebDriverWait waiter) {
		super(driver, javascriptExecutor, waiter);
		// TODO Auto-generated constructor stub
	}
public WebElement getClearAllBtn() {
	return this.driver.findElement(By.xpath("//*[@class='cart-head']/a[2]"));
}
public void ClearCart() {
	this.getClearAllBtn().click();
}
}
