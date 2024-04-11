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
		String Testcase= "Sheet1";
		for(int i=1; i<=xl.rowcount(Testcase); i++) {
		if(xl.getclldata(Testcase, i, 2).equalsIgnoreCase("Y")) {
			FunctionLibrary.startBrowser();
		FunctionLibrary fl= new FunctionLibrary();
		fl.takeurl();
		Modulestatus="True";
         
		if(Modulestatus.equalsIgnoreCase("True")) {
			xl.setcelldata(Testcase, i, 3, "pass", outputpath);      //write on output excelsheet pass or fail
			}
      }
	}
    }
 }