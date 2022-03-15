package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor javascriptExecutor, WebDriverWait waiter) {
		super(driver, javascriptExecutor, waiter);
		// TODO Auto-generated constructor stub
	}
public WebElement getMealsSign() {
	return this.driver.findElement(By.linkText("Meals"));
}
public WebElement getMealsSearch() {
	return this.driver.findElement(By.className("js-search-keywords"));
}
public void searchMeals(String meal) {
	this.getMealsSearch().sendKeys(meal);
	this.getMealsSearch().sendKeys(Keys.ENTER);
}
public void confirmMeal() {
	this.driver.findElement(By.className("product_image")).click();;
}
public void selectMeal(String meal)throws InterruptedException{
	this.getMealsSign().click();
    this.searchMeals(meal);
    Thread.sleep(1000);
    this.confirmMeal();
}
public WebElement getQtyField() {
	return this.driver.findElement(By.name("product_qty"));
}
public WebElement getAddBtn() {
	return this.driver.findElement(By.className("btn--primary"));
}
public void addMeal(String qty) throws InterruptedException{
	this.getQtyField().click();
    this.getQtyField().sendKeys(Keys.BACK_SPACE);
    Thread.sleep(300);
    this.getQtyField().sendKeys(qty);
    this.getAddBtn().click();
}
public WebElement getFavouriteBtn() {
	return this.driver.findElement(By.xpath("//*[@title='Favorite']"));
}
public void setFavourite() {
	this.getFavouriteBtn().click();
}
}

