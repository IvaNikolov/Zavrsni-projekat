package Tests;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class MealItemTest extends BasicTest{

	
	@Test (priority = 1)
	public void addMealToCartTest() throws InterruptedException{
		driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPopUpPage.closePopup();
        mealPage.addMeal("4");
        Assert.assertTrue(notificationPage.getMessageText().contains("The Following Errors Occurred:"),"Expected notification error");
        
        
        Assert.assertTrue(notificationPage.getMessageText().contains("Please Select Location"),"Expected notification error");
        
		notificationPage.waitTillMessageGone();
		locationPopUpPage.getLocationForm();
        locationPopUpPage.setLocation("City Center - Albany");
        Thread.sleep(500);
        mealPage.addMeal("4");
        
        Assert.assertTrue(notificationPage.getMessageText().contains("Meal Add To Cart"),"Add meal ERROR");
        
	}
      @Test (priority = 2) 
      public void addMealToFavoriteTest() throws InterruptedException{
    	  driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
    	  locationPopUpPage.closePopup();
          mealPage.setFavourite();
          Assert.assertTrue(notificationPage.getMessageText().contains("Please login first!"),"Login notification ERROR");
          
          
          loginPage.getLoginPage();
          loginPage.login(email, password);
          driver.get(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
          mealPage.setFavourite();
          Thread.sleep(500);
          Assert.assertTrue(notificationPage.getMessageText().contains("Product has been added to your favorites"),"Add meal ERROR");
          
          
      }
      @Test (priority = 3) 
      public void clearCartTest() throws InterruptedException, IOException{
   	  SoftAssert sa =new SoftAssert();
  	  driver.get(baseUrl +"/meals");
   	  locationPopUpPage.setLocation("City Center - Albany");
    	  
    	  File file = new File("C:\\Projekti\\Zavrsni-projekat\\data\\Data.xlsx"); 
    	  
     	  FileInputStream fis= new FileInputStream(file);
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);
     	  XSSFSheet sheet=wb.getSheet("Melas");
     	 // DataFormatter formatter = new DataFormatter();
    	  
    	  for (int i = 0; i < 5; i++) {
          driver.get(sheet.getRow(i).getCell(0).getStringCellValue());
          double qty=sheet.getRow(i).getCell(1).getNumericCellValue();
          
          int intValue=(int)qty;
          String stringValue=Integer.toString(intValue);
          mealPage.addMeal(stringValue);
          sa.assertTrue(notificationPage.getMessageText().contains("Meal Add To Cart"), "Add meal ERROR");
		}
    	  cartSummaryPage.ClearCart();
    	  sa.assertAll();
    	  Assert.assertTrue(notificationPage.getMessageText().contains("All meals removed from Cart succsessfully"), "Clear cart ERROR");
      }}
	

