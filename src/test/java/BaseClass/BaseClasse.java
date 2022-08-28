package BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasse {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getAppUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPass();
	public String pathchrome=readconfig.getchromepath();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	
	public void setup(String br) throws Exception{
		
		logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("log4j.properties");
		 
		 if(br.equals("chrome")) {
		 
		System.setProperty("webdriver.chrome.driver",pathchrome);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 }
		 else if(br.equals("firefox")) {
			 System.setProperty("webdriver.chrome.driver",readconfig.getfirefoxpath());
				//WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 }
		 driver.get(baseURL);
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/ScreenShots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
		
		
		
	}
}
