package shaadi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtils2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		List<String> data = getUserData("free");
		System.out.println(data.get(0));
		System.out.println(data.get(1));

	}

	public static List<String> getUserData(String usertype) throws IOException {

		List<String> userdata = new ArrayList<String>();

		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream("UserData.xlsx");
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

		List<String> userdata = new ArrayList<String>();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream("UserData.xlsx");
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
			InputStream resourceStream = loader.getResourceAsStream("UserData.xlsx");
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

		List<String> userdata = new ArrayList<String>();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream("UserData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(resourceStream);
			XSSFSheet sheet = workbook.getSheetAt(2);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				userdata.add(row.getCell(0).getStringCellValue().trim());

			}
			workbook.close();

			for (int i = 0; i < userdata.size(); i++) {
				if (userdata.get(i).isEmpty())
					userdata.remove(i);
			}

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

}
