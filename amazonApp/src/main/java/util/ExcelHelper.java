package util;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
			XSSFWorkbook wb;
			InputStream fis;
			
			//Initialize excel
			public ExcelHelper(String fpath) throws Exception{
				fis = ExcelHelper.class.getClassLoader().getResourceAsStream("MasterTestDataFile.xlsx");
				wb = new XSSFWorkbook(fis);
			}
			
			//get row count
			public int getRowCount(String sheetName){
				XSSFSheet sheet = wb.getSheet(sheetName);
				return sheet.getLastRowNum();
			}
			
			//get column count
			public int getColumnCount(String sheetName){
				XSSFSheet sheet = wb.getSheet(sheetName);
				return sheet.getRow(0).getLastCellNum();
			}
			
			//Read cell value
			public String readCellValue(String sheetName, int row, int col){
				XSSFSheet sheet = wb.getSheet(sheetName);
				XSSFCell cell = sheet.getRow(row).getCell(col);
				
				String celltext = "";
							
				if(cell.getCellTypeEnum()==CellType.STRING){
					celltext = cell.getStringCellValue();
				}else if(cell.getCellTypeEnum()==CellType.NUMERIC){
					celltext = String.valueOf(cell.getNumericCellValue());
				}else if(cell.getCellTypeEnum()==CellType.BLANK){
					celltext="";
				}else if(cell.getCellTypeEnum()==CellType._NONE){
					celltext="";
				}else if(cell.getCellTypeEnum()==null){
					celltext="";
				}
				return celltext;
			}
			
			//write to cell
			public void writeCell(String sheetName,int row,int col,String val){
				XSSFSheet sheet = wb.getSheet(sheetName);
				sheet.getRow(row).getCell(col).setCellValue(val);		
			}
			
			//Save and close
			public void saveAndClose(String fpath) throws Exception{
				FileOutputStream fos = new FileOutputStream(fpath);
				//write and save to excel
				wb.write(fos);
				//Close the streams
				fos.close();
				fis.close();
			}
}
