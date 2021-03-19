package util;

import static util.DataDrivenHelper.getTestDataFromExcel;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.apache.commons.collections4.iterators.*;
import org.testng.annotations.DataProvider;

import org.testng.annotations.DataProvider;

public class TestDataFromExcel {
	
		@DataProvider(name="commondata")
		public static Iterator<Object[]> commonData(Method m) throws Exception{
			return getTestDataFromExcel("TestCaseDataSets", DataDrivenHelper.getScriptName(m.getName().trim()));
		}

}
