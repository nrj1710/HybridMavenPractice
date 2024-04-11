package driverFactory;




import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;

public class AppTest {
	@Test
	public   void openbrowser() throws Exception{
		DriverScript ds= new DriverScript();
		ds.starttest();
		
	}
}
