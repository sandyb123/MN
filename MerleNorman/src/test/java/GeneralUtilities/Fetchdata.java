package GeneralUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Functionalities.BaseTest;

public class Fetchdata extends BaseTest {
	public static ArrayList<String> getExcelData(String path, String SheetName, int columNum) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + path);
		XSSFWorkbook workbook = new XSSFWorkbook(fls);

		int Numofsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < Numofsheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(SheetName)) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				for (int j = 1; j <= sheet.getLastRowNum(); j++) {
					XSSFRow row = sheet.getRow(j);
					XSSFCell cellValue = row.getCell(columNum);

					if (cellValue == null) {
						break;
					}

					else if (cellValue.getCellType() == CellType.STRING) {
						a.add(cellValue.getStringCellValue());
					}

					else if (cellValue.getCellType() == CellType.NUMERIC) {
						a.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
					}

					else {
						a.add(Boolean.toString(cellValue.getBooleanCellValue()));
					}

					totalRowinExcel = sheet.getLastRowNum();
					

				}
			}

		}

		workbook.close();

		return a;

	}

	public static void  WriteExcelData(String path, String SheetName, int columNum) throws IOException {
		
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + path);
		XSSFWorkbook workbook = new XSSFWorkbook(fls);

		int Numofsheets = workbook.getNumberOfSheets();

		for (int i = 0; i < Numofsheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(SheetName)) {

				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//System.out.println(row);
				
				
				
			for (int k=0; k<=sheet.getLastRowNum(); k++) {
				
				if(k==currentStep+1) {
				XSSFRow row = sheet.getRow(k);
				
				
					
					XSSFCell cell = row.createCell(columNum);
					
					cell.setCellType(CellType.STRING);
					if(excutionResult=="Pass") {
					cell.setCellValue(excutionResult);
					}
					else {
						cell.setCellValue(failResult);
						XSSFCell cell1 = row.createCell(columNum+1);
						//System.out.println(failMessage);
						//System.out.println(columNum+1);
						cell1.setCellValue(failMessage);
						//XSSFCell cell2 = row.createCell(columNum+2);
						//cell1.setCellValue(failReason);
						
					}
					FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + path);
					workbook.write(fos);
					//System.out.println("writing in excel: " + excutionResult);
				}
					
				
			
			}
			}

		}

		workbook.close();
	}
}
