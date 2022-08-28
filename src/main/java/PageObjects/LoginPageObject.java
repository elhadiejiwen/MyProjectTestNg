package PageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver ldriver;
	
	WebDriver driver;
	public LoginPageObject(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="dropdown-account")
	@CacheLookup
	WebElement btnConnex;
	
	@FindBy(id="UserPasswordDropdown")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(id="UserLoginDropdown")
	@CacheLookup
	WebElement Username;
	
	@FindBy(xpath="//button[@type=\"submit\"][contains(text(),\"Se connecter\")]")
	@CacheLookup
	WebElement SeConnecter;
	
	@FindBy(xpath="//button[@id=\"onetrust-accept-btn-handler\"][contains(text(), \"Tout accepter\")]")
	@CacheLookup
	WebElement Accepter;
	
	@FindBy(xpath="//span[@data-dropdown-inited='true'][contains(text(), 'sidi klh')]")
	@CacheLookup
	WebElement verifConnexion;
	
	
	
	public void setUserName(String uname) {
		Username.sendKeys(uname);
		
	}
	public void setPassword(String pwd) {
		 textPassword.sendKeys(pwd);
		
	}
	
	public void clickSubmit() {
		Accepter.click();
		btnConnex.click();
		
	}
	
	public void clickSeConnecter() {
		SeConnecter.click();
		
	}
	
	public boolean verifConnexion() {
		
		boolean vis = verifConnexion.isDisplayed();
		assertTrue(vis);
		return vis;
		
	}
}
