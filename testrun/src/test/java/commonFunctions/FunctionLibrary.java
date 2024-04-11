package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {
	public static WebDriver driver;
	public static Properties popcorn;
	public static WebDriverWait wait;
	
	public static WebDriver startBrowser() throws FileNotFoundException, IOException {
		popcorn =new Properties();
		popcorn.load(new FileInputStream("./propertyFile/Environment.properties"));
		if(popcorn.getProperty("Browser").equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}else if  (popcorn.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		return driver;
	}
	public  void takeurl() {
		driver.get(popcorn.getProperty("Url"));
	}

}
