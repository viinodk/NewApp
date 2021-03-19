package util;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class DataDrivenHelper {
	//common method, to generalize the data provider
		public static  Iterator<Object[]> getTestDataFromExcel(String sheetname, String scriptname ) throws Exception{
//			ExcelHelper excelRW = new ExcelHelper(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\MasterTestDataFile.xlsx");
			
			ExcelHelper excelRW = new ExcelHelper(scriptname);
			int rowcount = excelRW.getRowCount(sheetname);
			int colcount = excelRW.getColumnCount(sheetname);
			//list create
			ArrayList<Object[]> al = new ArrayList<Object[]>();
			for(int i = 1;i<=rowcount;i++){
				String flag=excelRW.readCellValue(sheetname, i, 2);
				String script=excelRW.readCellValue(sheetname, i, 1);
				if(flag.equals("Y") && script.equals(scriptname)){
				//map
				Map<String, String> hmap = new HashMap<String,String>();
				//object array
				Object[] x=new Object[1];
					for(int j=0;j<colcount;j++){
						String key = excelRW.readCellValue(sheetname, 0, j);
						String value = excelRW.readCellValue(sheetname, i, j);
						hmap.put(key,value);
					}
				
				//add object array
				x[0]=hmap;
				al.add(x);
				}
			}
			return al.iterator();
		}
		
		//get the key values from the config properties file
		public static String getKeyValue(String key){
//			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Config.properties");
			InputStream input = null;
			Properties prop = new Properties();
			input = DataDrivenHelper.class.getClassLoader().getResourceAsStream("config.properties");
				try {
					prop.load(input);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return prop.getProperty(key);
		}

		/* Get the testcase IDs from the TestcaseMapping properties file */
		public static String getScriptName(String key) throws Exception{
//			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\TestcaseMapping.properties");
			InputStream input = null;
			Properties prop = new Properties();
			input = DataDrivenHelper.class.getClassLoader().getResourceAsStream("TestcaseMapping.properties");
			prop.load(input);
			return prop.getProperty(key);
		}
}
