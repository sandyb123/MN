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
			return Constants.Keyword_Fail+ "FR:Message: "+ "not able to click "+ "FR:Reason: " + e.getMessage();
			
		}
		return Constants.Keyword_Pass;
		
	}
	
	public  String hover(String Object, String data) {
		try {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(OR.getProperty(Object)))).build().perform();
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+ " not able to hover "+ "FR:Reason:" +e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public  String navigate(String Object, String data) {
		try {
		driver.get(Config.getProperty(data));
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able to navigate"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public  String selectByIndex(String Object, String data) {
		try {
		Select dropdownIndex = new Select(driver.findElement(By.xpath(OR.getProperty(Object))));
		dropdownIndex.selectByIndex(4);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able to select from dropdown"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public  String scroll(String Object, String data) {
		try {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250);");
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able to scrolldown"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public  String sendKey(String Object, String data) {
		try
		{
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys(Config.getProperty(data));
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able to enter the value in field"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public  String selectByValue(String Object,String data) {
		try {
		Select dropdownValue = new Select(driver.findElement(By.xpath(OR.getProperty(Object))));
		dropdownValue.selectByValue(Config.getProperty(data));
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able select the dropdown value by index"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public  String getText(String Object, String data) {
		try {
		String Text = driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		System.out.println(Object + ":" + Text);
		return Constants.Keyword_Pass + ":" + Text;
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able get the text from element"+" FR:Reason: " +e.getMessage();
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
				return Constants.Keyword_Fail+"FR:Message: "+"not able accept the cookie"+" FR:Reason: " +e.getMessage();
			}
		return Constants.Keyword_Pass;
		}
	
	public  String sleep(String Object, String data) throws InterruptedException {
		try {
		Thread.sleep(2000);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"wait not working"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public  String sleep4000(String Object, String data) throws InterruptedException {
		try {
			Thread.sleep(4000);
			}
			catch (Exception e) {
				return Constants.Keyword_Fail+"FR:Message: "+"wait not working"+" FR:Reason: " +e.getMessage();
			}
			return Constants.Keyword_Pass;
	}
	
	public  String maxwindow(String Object, String data) throws InterruptedException {
		try {
		driver.manage().window().maximize();
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"maximise window not working"+" FR:Reason: " +e.getMessage();
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
			return Constants.Keyword_Fail+"FR:Message: "+"Browser not opening"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	public String implicitWait(String Object, String data) {
		try {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"Implicit wait not working"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}
	
	
	
	public String asserion(String Object, String data) {
		try {
		String actual = driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		String expected = Config.getProperty(data);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"actual and expected results are not matching"+" FR:Reason: " +e.getMessage();
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
			return Constants.Keyword_Fail+"FR:Message: "+"element not visible"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
		
	}
	
	public String tabOut(String Object, String data) {
		try {
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys(Keys.TAB);
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able to taab out"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
	}
	
	public String resizeWindow(String Object, String data) {
		try {
			String[] size = Config.getProperty(data).split(",");
			System.out.println("size:"+size[0]);
			System.out.println("size:"+ size[1]);
			int x = Integer.parseInt(size[0]);
			System.out.println(x);
			int y = Integer.parseInt(size[1]);
			System.out.println(y);
			
			Dimension newSize = new Dimension(x,y);
			driver.manage().window().setSize(newSize);
			
			
		}
		catch (Exception e) {
			return Constants.Keyword_Fail+"FR:Message: "+"not able to resize window"+" FR:Reason: " +e.getMessage();
		}
		return Constants.Keyword_Pass;
		
	}


}
