package TestCases;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClasse;
import PageObjects.LoginPageObject;


public class LoginPageTest extends BaseClasse{
	

		//public static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());
		
		@Test
		public void loginTest() throws IOException {
			
			
			LoginPageObject lp= new LoginPageObject(driver);
			
			logger.info("Url is opened");
			lp.clickSubmit();
			lp.setUserName(username);
			logger.info("Entred username");
			lp.setPassword(password);
			logger.info("Entred password");
			lp.clickSeConnecter();
			if(lp.verifConnexion()==true) {
				captureScreen(driver,"loginTest");
				Assert.assertTrue(true);
				logger.info("Test passed");
			}else {
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
				logger.info("Test failed");
			}
		
			
			
			
		}
		
}
