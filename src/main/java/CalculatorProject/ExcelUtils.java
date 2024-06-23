package CalculatorProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fs;
	public static XSSFSheet sheet;
	public static XSSFWorkbook workbook;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fo;
	public static XSSFCellStyle style;
	
	public static int getRowCount(String xlfile, String xlSheet) throws IOException {
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(xlSheet);
		int lastRowCount=sheet.getLastRowNum();
		workbook.close();
		fs.close();
		
		return lastRowCount;
	}
	public static int getCellCount(String xlfile, String xlSheet, int rownum) throws IOException {
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(xlSheet);
		//int lastRowCount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(rownum).getLastCellNum();
		workbook.close();
		fs.close();
		
		return cellCount;
	}
	
	public static String getCellData(String xlfile, String xlSheet, int rownum, int colnum) throws IOException {
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(xlSheet);
		//int lastRowCount=sheet.getLastRowNum();
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		//int cellCount=sheet.getRow(rownum).getLastCellNum();
		String data;
		try {
		//data=cell.toString();  we can use this statement or below data formatter
		DataFormatter format= new DataFormatter();
		 data=format.formatCellValue(cell);// returns the formatted of a cell as a String regardless of the cell type
		 
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fs.close();
		
		return data;
	}
	public static void setCellData(String xlfile, String xlSheet, int rownum, int colnum, String data) throws IOException {
		
		System.out.println("Received data:"+data);
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(xlSheet);
		//int lastRowCount=sheet.getLastRowNum();
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		
		 fo= new FileOutputStream(xlfile); // open the output file which we are going to write
		workbook.write(fo); // write the data into out workbook file
		workbook.close();
		fs.close();
		fo.close();
	}
	
	public static void fillGreenColor(String xlfile, String xlSheet, int rownum, int colnum) throws IOException {
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(xlSheet);
		//int lastRowCount=sheet.getLastRowNum();
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
	
		fo= new FileOutputStream(xlfile); // open the output file which we are going to write
		workbook.write(fo); // write the data into out workbook file
		workbook.close();
		fs.close();
		fo.close();
	}
	
	
	public static void fillRedColor(String xlfile, String xlSheet, int rownum, int colnum) throws IOException {
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(xlSheet);
		//int lastRowCount=sheet.getLastRowNum();
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
	style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
	
		fo= new FileOutputStream(xlfile); // open the output file which we are going to write
		workbook.write(fo); // write the data into out workbook file
		workbook.close();
		fs.close();
		fo.close();
	}
	
}
