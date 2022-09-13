package testCases;
/*
//import static org.testng.Assert.assertTrue;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//import java.util.regex.Matcher;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument.Pattern;
//import org.testng.annotations.Test;
//
//import com.github.javafaker.Faker;
//import com.github.javafaker.service.FakeValuesService;
//import com.github.javafaker.service.RandomService;
//
//import utilitiez.Constants;
//import utilitiez.ExselUtility;
//
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import utilitiez.Constants;
import utilitiez.ExcelUtility;

public class ExcelLessons {
	static FakeValuesService fakeValuesService;

	@Test(enabled = false)
	public void readExelTest() throws IOException {

		FileInputStream fs = new FileInputStream(Constants.excelDataPath);

		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		XSSFSheet sheet = workbook.getSheet(Constants.sheetName);

		// System.out.println("Printed THIS : == " + sheet.getRow(1).getCell(1));

		for (Row row : sheet) {
			for (Cell cell : row) {

				System.out.println(cell.getRichStringCellValue());

			}
		}

//	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//
//	for (int i = 0; i < rowCount + 1; i++) {
//
//		Row row = sheet.getRow(i);
//
//		// Create a loop to print cell values in a row
//
//		for (int j = 0; j < row.getLastCellNum(); j++) {
//
//			// Print Excel data in console
//
//			System.out.print(row.getCell(j).getStringCellValue() + "|| ");
//
//		}
//
//		System.out.println();
//	}

//	for (Row row : sheet) {
//
//		for (Cell cell : row) {
//			switch (cell.getCellType()) {
//			case BOOLEAN:
//				System.out.println(cell.getBooleanCellValue());
//				break;
//			case NUMERIC:
//				System.out.println(cell.getNumericCellValue());
//				break;
//			case STRING:
//				System.out.println(cell.getRichStringCellValue());
//				break;
//			case FORMULA:
//	        	System.out.println(cell.getNumericCellValue());
//	        	break;
//
//			}
//			System.out.println(" ");
//
//		}
//
//		workbook.close();
//
//	}

//	DataFormatter objDefaultFormat = new DataFormatter();
//	
//    for (Row row: sheet) {
//        for(Cell cell: row) {
//            String cellValue = objDefaultFormat.formatCellValue(cell);
//            System.out.print(cellValue + "\t");
//        }
//        System.out.println(" ");
	}

	@Test
	public void writeToExcel() throws IOException {

		// open connection to the file
		FileInputStream fs = new FileInputStream(Constants.excelDataPath);

		// gets workbook
		Workbook wb = new XSSFWorkbook(fs);

		// get sheet index of
		Sheet sheet = wb.getSheetAt(0);

		// try to print the last row number
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);

//		Row row = sheet.getRow(0);
//		
//		Cell cell = row.createCell(0);
//		
//		cell.setCellValue("Cohort Teams");

		// gets the local date time and seconds
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		// System.out.println(dtf.format(now));

		// this creates random email eachtime
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

		String email = null;

		for (int i = 1; i <= lastRow; i++) {

			Row row = sheet.getRow(i);

			Cell cell = row.createCell(6);
			Cell cell2 = row.createCell(7);
			Cell cell3 = row.createCell(3);
			email = fakeValuesService.bothify("????##@gmail.com");

			cell.setCellValue("Cohort12");
			cell2.setCellValue(dtf.format(now));
			cell3.setCellValue(email);

		}

		// this opens connection to a file and gets ready to write
		FileOutputStream fos = new FileOutputStream(Constants.excelDataPath);
		// this workbook objects actually writes and saves
		wb.write(fos);
		// closses the outputStream connection to the file
		fos.close();

	}

	@Test
	public void writePhoneNumberExcel_Daniel() throws IOException {

		FileInputStream fs = new FileInputStream(Constants.excelDataPath);

		Workbook wb = new XSSFWorkbook(fs);

		Sheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {

			Row row = sheet.getRow(i);
			Cell cell = row.createCell(2);
			Faker faker = new Faker();
			cell.setCellValue(faker.numerify("###-###-####"));
		}

		FileOutputStream fos = new FileOutputStream(Constants.excelDataPath);
		wb.write(fos);
		fos.close();

	}

	@Test
	public void readNameWriteEmailExcel_Daniel() throws IOException {

		FileInputStream fs = new FileInputStream(Constants.excelDataPath);

		Workbook wb = new XSSFWorkbook(fs);

		Sheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {

			Row row = sheet.getRow(i);
			String fullName = row.getCell(1).getStringCellValue().replaceAll(" ", "");
			Cell cell = row.createCell(3);
			Faker faker = new Faker();
			cell.setCellValue(fullName + faker.numerify("##@gmail.com"));

		}

		FileOutputStream fos = new FileOutputStream(Constants.excelDataPath);
		wb.write(fos);
		fos.close();
	}

	@Test
	public void readNameWriteAddress_Katekung() throws IOException {

		FileInputStream fs = new FileInputStream(Constants.excelDataPath);

		Workbook wb = new XSSFWorkbook(fs);

		Sheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {

			Row row = sheet.getRow(i);

			Cell cell5 = row.createCell(4);
			Faker fake = new Faker();

			String streetName = fake.address().streetName();
			String number = fake.address().buildingNumber();
			String city = fake.address().city();
			String country = fake.address().country();
			cell5.setCellValue(number + " " + streetName + " " + city + " " + country);

		}

		FileOutputStream fos = new FileOutputStream(Constants.excelDataPath);
		wb.write(fos);
		fos.close();
	}

	@Test
	public void testExcelUtility() {

		ExcelUtility.excelIntoArray(Constants.excelDataPath, Constants.sheetName);

	}
}
