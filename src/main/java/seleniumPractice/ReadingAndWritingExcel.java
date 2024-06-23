package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingAndWritingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\Datafolder\\InputData.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		//int cellCount=sheet.getRow(0).getLastCellNum();
		XSSFRow row=sheet.getRow(rowCount+1);
		XSSFCell cell=row.createCell(1);
		cell.setCellValue("Dineshhhhhjajkkaj");
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\Datafolder\\InputData.xlsx");
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}

}
