package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtil {
Workbook wb;
//XSSFSheet sheet;

public ExcelFileUtil(String Excelpath) throws Exception {
	FileInputStream fis =new FileInputStream(Excelpath);
	wb= WorkbookFactory.create(fis);
}
public int rowcount(String Sheetnamae) {
	return wb.getSheet(Sheetnamae).getLastRowNum();
	
}
public String getclldata(String Sheetname, int row, int col) {
	String data="";
	if(wb.getSheet(Sheetname).getRow(row).getCell(col).getCellType()==CellType.NUMERIC) {
		int celldata =(int) wb.getSheet(Sheetname).getRow(row).getCell(col).getNumericCellValue();
		data= String.valueOf(celldata);
	}else {
		data= wb.getSheet(Sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	return data;
}
public void  setcelldata(String sheetname, int row, int col, String status, String writeExcel) throws Exception {
	Sheet ws = wb.getSheet(sheetname);
	Row rownum = ws.getRow(row);
	Cell cell=rownum.createCell(col);                                       //create  fileOutput excel file to get status
	cell.setCellValue(status);
	ws.getRow(row).getCell(col).setCellValue(status);
	FileOutputStream fos =new FileOutputStream(writeExcel);
	wb.write(fos);
	
}
}
