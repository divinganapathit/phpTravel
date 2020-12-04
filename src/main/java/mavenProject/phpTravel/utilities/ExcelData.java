package mavenProject.phpTravel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Author:
 * Date: 
 * Info: Class to read the excel sheet
 * 
 * */
public class ExcelData {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;
	List<String> data = new ArrayList<String>();

	/*
	 * Method to read the excel sheet and return the list of element that is stored
	 * in the excel sheet. Note: In this method, Header row and the column is
	 * ingnored.
	 * 
	 */
	public List<String> readData(String address) throws IOException {
		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\" + address + "\\"));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			int rowNumber;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowNumber = row.getRowNum();
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (rowNumber == 0) {
						break;
					}
					switch (cell.getCellType()) {
					case STRING:
						data.add(cell.getStringCellValue());
//						System.out.println(cell.getStringCellValue());
						break;
					case NUMERIC:
						data.add(String.valueOf(cell.getNumericCellValue()));
//						System.out.println(cell.getNumericCellValue());
						break;
					default:
						System.out.println(cell.getStringCellValue());
					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception while reading data from Excel file");
			e.printStackTrace();
		} finally {
			fis.close();
			workbook.close();
		}
		return data;
	}

}
