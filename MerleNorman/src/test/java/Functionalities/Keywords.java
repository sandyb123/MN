package Functionalities;

import org.apache.commons.math3.analysis.function.Constant;
import org.omg.CORBA.ORB;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import GeneralUtilities.Constants;

import static Functionalities.BaseTest.Config;
import static Functionalities.BaseTest.OR;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;



public class Keywords  {
	
	public WebDriver driver;
	
	public  String click(String Object, String data) {
		try {
		driver.findElement(By.xpath(OR.getProperty(Object))).click();
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to click"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public  String hover(String Object, String data) {
		try {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(OR.getProperty(Object)))).build().perform();
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to hover"+e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public  String navigate(String Object, String data) {
		try {
		driver.get(Config.getProperty(data));
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to navigate"+e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public  String selectByIndex(String Object, String data) {
		try {
		Select dropdownIndex = new Select(driver.findElement(By.xpath(OR.getProperty(Object))));
		dropdownIndex.selectByIndex(4);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to select from dropdown"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public  String scroll(String Object, String data) {
		try {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to scrolldown"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public  String sendKey(String Object, String data) {
		try
		{
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys(Config.getProperty(data));
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to enter the value in field"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public  String selectByValue(String Object,String data) {
		try {
		Select dropdownValue = new Select(driver.findElement(By.xpath(OR.getProperty(Object))));
		dropdownValue.selectByValue(Config.getProperty(data));
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able select the dropdown value by index"+e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public  String getText(String Object, String data) {
		try {
		String Text = driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		System.out.println(Object + ":" + Text);
		return Text;
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able get the text from element"+e.getMessage();
		}
	}
	
	public String accptCookie(String Object, String data) {
		try {
			
			boolean actCookie = driver.findElement(By.xpath(OR.getProperty(Object))).isDisplayed();
			if(actCookie) {
				driver.findElement(By.xpath(OR.getProperty(Object))).click();
			}
		}
			catch (Exception e) {
				return Constants.Keyword_Fail+"not able accept the cookie"+e.getMessage();
			}
		return Constants.Keyword_Pass;
		}
	
	public  String sleep(String Object, String data) throws InterruptedException {
		try {
		Thread.sleep(2000);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"wait not working"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public  String sleep4000(String Object, String data) throws InterruptedException {
		try {
			Thread.sleep(4000);
			}
			catch (Exception e) {
				return Constants.Keyword_Fail+"wait not working"+e.getMessage();
			}
			return Constants.Keyword_Pass;
	}
	
	public  String maxwindow(String Object, String data) throws InterruptedException {
		try {
		driver.manage().window().maximize();
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"maximise window not working"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public String openBrowser(String Object, String data) {
		try {
		String chromePath = "\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromePath);
		driver = new ChromeDriver();
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"Browser not opening"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public String implicitWait(String Object, String data) {
		try {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"Implicit wait not working"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	
	
	public String asserion(String Object, String data) {
		try {
		String actual = driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		String expected = Config.getProperty(data);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"actual and expected results are not matching"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public String isVisible(String Object, String data) {
		try {  
		int element = driver.findElements(By.xpath(OR.getProperty(Object))).size();
		if(element>0) {
			System.out.println("Element visible");
			
		}
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"element not visible"+e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public String tabOut(String Object, String data) {
		try {
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys(Keys.TAB);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"not able to taab out"+e.getMessage();
		}
		return Constants.Keyword_Pass;
	}


}
