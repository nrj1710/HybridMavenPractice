package driverFactory;
import org.openqa.selenium.WebDriver;

import Utilities.ExcelFileUtil;
import commonFunctions.FunctionLibrary;

public class DriverScript {
	public static WebDriver driver;
	String inputpath="./fileInput/controler.xlsx";
	String outputpath="./fileOutput/Result_controller.xlsx";
	//ExtentTest logger;
	
	public void starttest() throws Exception {
		String Modulestatus ="";
		ExcelFileUtil xl= new ExcelFileUtil(inputpath);
		String TestCases="Sheet1";
		
		for(int i=1; i<=xl.rowcount(TestCases); i++) {
		if(xl.getcelldata(TestCases, i, 2).equalsIgnoreCase("Y")) {
		String TCModule=xl.getcelldata(TestCases, i, 1);
			for(int j=1; j<=xl.rowcount(TestCases); j++) {
				
				String Description=xl.getcelldata(TCModule, j, 0);
				String Object_Type =xl.getcelldata(TCModule, j, 1);
				String Locator_Type =xl.getcelldata(TCModule, j, 2);
				String Locator_Value =xl.getcelldata(TCModule, j, 3);
				String  Test_Data    = xl.getcelldata(TCModule, j, 4);
			try {
				if(Object_Type.equalsIgnoreCase("startBrowser")) {
			
				FunctionLibrary.startBrowser();
				
				}
		  if(Object_Type.equalsIgnoreCase("takeUrl")) {
					FunctionLibrary fl= new FunctionLibrary();
		               FunctionLibrary.takeurl();
				}
				xl.setcelldata(TCModule, j, 5, "Pass", outputpath);
				Modulestatus="True";
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			}
		Modulestatus="True";
         
		if(Modulestatus.equalsIgnoreCase("True")) {
			xl.setcelldata(TestCases, 1, 3, "Pass", outputpath);      //write on output excelsheet pass or fail
			
		}
		 }	
		}	
		}	
		}
		
			
		
	
		
	
    	
    
 