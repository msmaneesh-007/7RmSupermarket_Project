package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;//path to open 
	static XSSFWorkbook w; 
	static XSSFSheet sh; 

	public static String getStringData(int a,int b,String sheet) throws IOException 
	{ 
		f=new FileInputStream(Constant.TESTDATAFILE); 
		w=new XSSFWorkbook(f); 
		sh=w.getSheet(sheet); 
		XSSFRow r=sh.getRow(a); 
		XSSFCell c=r.getCell(b); 
		return c.getStringCellValue(); 
		 
	} 
	public static String getintigerData(int a,int b,String sheet) throws IOException 
	{ 
		f=new FileInputStream(Constant.TESTDATAFILE); 
		w=new XSSFWorkbook(f); 
		sh=w.getSheet(sheet); 
		XSSFRow r=sh.getRow(a); 
		XSSFCell c=r.getCell(b); 
		int m=(int) c.getNumericCellValue();//type casting 
		return String.valueOf(m);
	} 
}
