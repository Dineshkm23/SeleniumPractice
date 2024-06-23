package seleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.err.println("");
		
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\Datafolder\\InputData.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();	
		int columnCount=sheet.getLeftCol();
		int LastCellNum=sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count:"+rowCount);
		//System.out.println("Column count:"+columnCount);
		System.out.println("LastCellNum:"+LastCellNum);
		
		for (int i = 0; i <= rowCount; i++) {
			
			for (int j = 0; j < LastCellNum; j++) {
				String data=sheet.getRow(i).getCell(j).toString();
				System.out.print(data+"\t");
			}
			System.out.println("");
		}
		
		workbook.close();
		fi.close();
		
	}

}
