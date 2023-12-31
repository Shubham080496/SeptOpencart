package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  // Log4j
import org.apache.logging.log4j.Logger;   // Log4j

public class BaseClass {

	public static WebDriver driver;	
	public ResourceBundle rb;
	public Logger logger;
	
	@BeforeClass (groups= {"regression","master", "sanity"})
	@Parameters({"browser"})
	public void setup(String br)
	{
		
		logger=LogManager.getLogger(this.getClass()); //Log4j
		
		rb = ResourceBundle.getBundle("config");  // Loading confing.properties file
		
		// launching rigtht browser based on parameter from testng xml	
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
			
		}else {
			driver = new ChromeDriver();
		}
		
		driver.manage().deleteAllCookies(); // delete all cookies from browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
 @AfterClass (groups= {"regression","master", "sanity"})
 public void tearDown() 
 {
driver.close();	 
 }
 
//TO Generate Random String Data --->
 
public String randomString()
{
	String generatedString = RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}

public String randomNumber()
{
	String generatedNumber = RandomStringUtils.randomNumeric(10);
	return generatedNumber;
}

public String ranodmAlphaNumaric()
{
	 String str = RandomStringUtils.randomAlphabetic(5);
	 String Num= RandomStringUtils.randomNumeric(10);
	 return str+Num;
}

public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;

}

}
