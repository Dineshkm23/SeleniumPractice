package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static XSSFRow row;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Datafolder\\InputData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rowCount = sheet.getLastRowNum();
		int LastCellNum = sheet.getRow(0).getLastCellNum();

		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir") + "\\Datafolder\\output.xlsx");
		XSSFWorkbook workbookWrite = new XSSFWorkbook();
		XSSFSheet SheetWrite = workbookWrite.createSheet();

		for (int i = 0; i <= rowCount; i++) {
			System.out.println("Inside ROw");
			row = SheetWrite.createRow(i);

			for (int j = 0; j < LastCellNum; j++) {
				String data = sheet.getRow(i).getCell(j).toString();
				
				row.createCell(j).setCellValue(data);
			}
			System.out.println("");
		}
		workbookWrite.write(fo);

		workbook.close();
		workbookWrite.close();
		file.close();
		fo.close();

	}

}
