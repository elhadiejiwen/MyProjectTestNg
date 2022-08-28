package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public WebDriver driver;
	ExtentReports extent;
    ExtentTest logger;
    ExtentHtmlReporter htmlReporter;
    String htmlReportPath = "C:\\Screenshots/MyOwnReport.html"; //Path for the HTML report to be saved

    @BeforeTest
   public void onStar(ITestContext testContext) {
	   
	   String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
	   String repName="Test-Report-"+ timeStamp+".html";
	   htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	   htmlReporter.loadXMLConfig(System.getProperty(System.getProperty("user.dir")+"/extent-config.xml"));
	   
	   
	   extent = new ExtentReports();
	   extent.attachReporter(htmlReporter);
	   extent.setSystemInfo("Host name", "localhost");
	   extent.setSystemInfo("Environment", "QA");
	   extent.setSystemInfo("user", "pavan");
	   
	   htmlReporter.config().setDocumentTitle("InetBanking Test Project");
	   htmlReporter.config().setReportName("Function Test Report");
	   htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	   htmlReporter.config().setTheme(Theme.DARK);
	   
   }
    @AfterMethod
   public void onTestSuccess(ITestResult tr){
    	extent = new ExtentReports();
	   logger = extent.createTest(tr.getName());
	   logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	   
	   String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
	   File f = new File(screenshotPath);
	   
	   if(f.exists()) {
		   
	   }try {
		   logger.fail("Screenshot is below :"+ logger.addScreenCaptureFromPath(screenshotPath));
	   }catch (IOException e) {
		   e.printStackTrace();
	   }
   }
    @AfterMethod
 public void onTestFailure(ITestResult tr) {
    	extent = new ExtentReports();
	   logger = extent.createTest(tr.getName());
	   logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	   
	   String screenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
	   File f = new File(screenshotPath);
	   
	   if(f.exists()) {
		   
	   }try {
		   logger.fail("Screenshot is below :"+ logger.addScreenCaptureFromPath(screenshotPath));
	   }catch (IOException e) {
		   e.printStackTrace();
	   }
   }
    @AfterMethod
   public void onTestSkipped(ITestResult tr) {
    	extent = new ExtentReports();
	   logger = extent.createTest(tr.getName());
	   logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	   
   }
   
   public void onFinish(ITestResult tr) {
	   extent = new ExtentReports();
	   extent.flush();
   }
   
}
