package shaadi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtils {

	public static final String excelFileName = "UserData.xlsx";

	public static List<String> getUserData(String usertype) throws IOException {

		List<String> userdata = new ArrayList<>();

		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase(usertype)) {
					userdata.add(row.getCell(1).getStringCellValue());
					userdata.add(row.getCell(2).getStringCellValue());
					userdata.add(row.getCell(3).getStringCellValue());
					break;

				}

			}
			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

	public static List<String> getUserType(String testname) throws IOException {

		List<String> userdata = new ArrayList<>();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(1);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase(testname)) {
					userdata.add(row.getCell(1).getStringCellValue());
					userdata.add(row.getCell(2).getStringCellValue());

				}

			}
			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

	public static String getSuitName(String podName) throws IOException {

		String userdata = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(1);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getCell(2).getStringCellValue().equalsIgnoreCase(podName)) {
					userdata = row.getCell(3).getStringCellValue();
				}

			}
			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

	public static List<String> getEmailList() throws IOException {

		List<String> userdata = new ArrayList<>();

		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(2);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (row.getCell(0) != null) {
					userdata.add(row.getCell(0).getStringCellValue().trim());
				}

			}
			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

	public static List<String> getDeviceListForVersion(int version) throws IOException {

		List<String> deviceList = new ArrayList<>();

		int cellno = 0;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(3);
			Row row = sheet.getRow(0);
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getNumericCellValue() == version) {
					cellno = cell.getColumnIndex();
				}

			}
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row1 = rowIterator.next();
				if (row1.getCell(cellno) != null) {
					deviceList.add(row1.getCell(cellno).getStringCellValue().trim());
				}

			}

			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return deviceList;

	}

	public static List<String> getDeviceListForMake(String make) throws IOException {

		List<String> deviceList = new ArrayList<>();

		int cellno = 0;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(4);
			Row row = sheet.getRow(0);
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getStringCellValue().equalsIgnoreCase(make)) {
					cellno = cell.getColumnIndex();
				}

			}
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row1 = rowIterator.next();
				if (row1.getCell(cellno) != null) {
					deviceList.add(row1.getCell(cellno).getStringCellValue().trim());
				}

			}

			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return deviceList;

	}

	public static Map<String, String> getUserList() throws IOException {

		Map<String , String> userdata = new HashMap<>();

		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(excelFileName);
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				userdata.put(row.getCell(1).getStringCellValue() , row.getCell(2).getStringCellValue());

			}
			workbook.close();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

}