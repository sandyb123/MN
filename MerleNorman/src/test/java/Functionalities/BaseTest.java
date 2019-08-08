package Functionalities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.BaseEncoding;

public class BaseTest {

	
	public String firefoxPath = "\\resources\\drivers\\geckodriver.exe";
	public String iePath = "\\resources\\drivers\\IEDriverServer.exe";

	public static WebDriver driver;

	public static Method method[];
	public static Keywords keywords;
	public static Properties OR, Config;
	public static int totalRowinExcel,currentStep;
	public static String currentKeyword, Object, data, keyword_execution_result,excutionResult,failResult,failMessage,failReason;
	public static ArrayList<String> resultSet;

	

	public BaseTest() {
		keywords = new Keywords();
		method = keywords.getClass().getMethods();
	}

	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		FileInputStream fs = new FileInputStream("src\\test\\java\\Properties\\or.properties");
		OR = new Properties();
		OR.load(fs);

		FileInputStream fsc = new FileInputStream("src\\test\\java\\Properties\\config.properties");
		Config = new Properties();
		Config.load(fsc);

		BaseTest test=new BaseTest();
		test.start();
		
	}
	
	public static void start() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		ArrayList<String> keyTotalRow = GeneralUtilities.Fetchdata
				.getExcelData("\\src\\test\\java\\GeneralUtilities\\orders.xlsx", "TestSteps", 0);
		for ( currentStep = 0; currentStep < totalRowinExcel; currentStep++) {

			ArrayList<String> keywordArray = GeneralUtilities.Fetchdata
					.getExcelData("\\src\\test\\java\\GeneralUtilities\\orders.xlsx", "TestSteps", 0);
			ArrayList<String> objectArray = GeneralUtilities.Fetchdata
					.getExcelData("\\src\\test\\java\\GeneralUtilities\\orders.xlsx", "TestSteps", 1);
			ArrayList<String> dataArray = GeneralUtilities.Fetchdata
					.getExcelData("\\src\\test\\java\\GeneralUtilities\\orders.xlsx", "TestSteps", 2);
			 
			currentKeyword = keywordArray.get(currentStep);
			Object = objectArray.get(currentStep);
			if (Object.equalsIgnoreCase("NA")) {
				Object = "";
			}

			data = dataArray.get(currentStep);
			if (data.equalsIgnoreCase("NA")) {
				data = "";
			}
			
			

			for (int j = 0; j < method.length; j++) {
				
				if (method[j].getName().equals(currentKeyword)) {
					keyword_execution_result = (String) method[j].invoke(keywords, Object, data);
					if(keyword_execution_result==null) {
						keyword_execution_result="NA";
					}
					
					resultSet=new ArrayList<String>();
					resultSet.add(keyword_execution_result);
					 excutionResult = resultSet.get(0);
					
					
					if(excutionResult!="Pass") {
						System.out.println("Execution result:" + excutionResult);
						String[] excutionResultSplit = excutionResult.split("FR:");
						 failResult = excutionResultSplit[0];
						 failMessage = excutionResultSplit[1];
						 failReason=excutionResultSplit[2];		
					}
					GeneralUtilities.Fetchdata.WriteExcelData("\\src\\test\\java\\GeneralUtilities\\ExecutionResult.xlsx", "TestSteps", 3);
					
				}
				
				
				
				 
				
				

			}
		}
		
		
	}

}
