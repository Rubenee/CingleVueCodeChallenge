package gmail.pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmailPage{
	
	protected static WebDriver webdriver = new FirefoxDriver();
	
	public void launchApp(String url){
		webdriver.get(url);
		webdriver.manage().window().maximize();
	}
	
	public void enterUserName(String loginID) throws Exception{
		WebElement userName = webdriver.findElement(By.cssSelector("#Email"));
		if(userName.isDisplayed()){
			userName.sendKeys(loginID);
		}else{
			throw new Exception("USERNAME TEXT FIELD NOT DISPLAYED");
		}
	}
	
	public void enterPassword(String pwd) throws Exception{
		WebElement password = webdriver.findElement(By.cssSelector("#Passwd"));
		if(password.isDisplayed()){
			password.sendKeys(pwd);
		}else{
			throw new Exception("PASSWORD TEXT FIELD NOT DISPLAYED");
		}
	}
	
	public void clickNext() throws Exception{
		WebElement nextButton = webdriver.findElement(By.cssSelector("#next"));
		if(nextButton.isDisplayed()){
			nextButton.click();
			Thread.sleep(1000);
		}else{
			throw new Exception("NEXT BUTTON NOT DISPLAYED");
		}
	}
	
	public void clickSignIn() throws Exception{
		WebElement signInButton = webdriver.findElement(By.cssSelector("#signIn"));
		if(signInButton.isDisplayed()){
			signInButton.click();
			Thread.sleep(5000);
		}else{
			throw new Exception("NEXT BUTTON NOT DISPLAYED");
		}
	}
	
	public boolean isInboxPage() throws Exception{
		WebElement gmailUser = webdriver.findElement(By.xpath("//a[@class='gb_b gb_Ra gb_R']"));
		if(gmailUser.isDisplayed()){
			return true;
		}else{
			throw new Exception("USER NOT LOGGED INTO THE ACCOUNT");
		}
	}
	
	public void clickCompose() throws Exception{
		WebElement compose = webdriver.findElement(By.xpath("//div[@id=':4i']//div[@role='button']"));
		if(compose.isDisplayed()){
			compose.click();
			Thread.sleep(1000);
		}else{
			throw new Exception("COMPOSE BUTTON NOT PRESENT");
		}
	}
	
	public void composeMail() throws Exception{
		
		WebElement subject = webdriver.findElement(By.xpath("//div[3]/input"));
		WebElement mailBody = webdriver.findElement(By.xpath("//td[2]/div[2]/div"));
		
		if(subject.isDisplayed()){
			subject.click();
			subject.sendKeys("Test Mail To Be Saved In Drafts");
			mailBody.click();
			mailBody.sendKeys("This mail is composed and saved in dratfs without sending");
			webdriver.switchTo().defaultContent();
		}else{
			throw new Exception("MAIL EDITOR TO COMPOSE A MAIL IS NOT PRESENT");
		}
	}
	
	public void clickClose() throws Exception{
		WebElement closeIcon = webdriver.findElement(By.xpath("//img[@alt='Close']"));
		if(closeIcon.isDisplayed()){
			closeIcon.click();
		}else{
			throw new Exception("CLOSE ICON NOT PRESENT");
		}
	}
	
	public boolean isMailSavedInDrafts() throws Exception{
		WebElement draft = webdriver.findElement(By.xpath("//div[@id=':4v']//div[1]/span/a[@class='J-Ke n0']"));
		draft.click();
		Thread.sleep(1000);
		WebElement draftmail = webdriver.findElement(By.xpath("//span[contains(text(),'Test Mail To Be Saved In Drafts')]"));
		if(draftmail.isDisplayed()){
			return true;
		}else{
			throw new Exception("MAIL NOT SAVED IN DRAFT");
		}
	}
	
	public void clickSignOut() throws Exception{
		WebElement gmailUser = webdriver.findElement(By.xpath("//a[@class='gb_b gb_Ra gb_R']"));
		gmailUser.click();
		WebElement signOutBtn = webdriver.findElement(By.xpath("//a[@id='gb_71' and contains(text(),'Sign out')]"));
		signOutBtn.click();
		Thread.sleep(1000);
	}
	
	public boolean isUserLoggedOut() throws Exception{
		WebElement account = webdriver.findElement(By.xpath("//span[@id='reauthEmail' and contains(text(),'cchallengeuser1@gmail.com')]"));
		if(account.isDisplayed()){
			return true;
		}else{
			throw new Exception("USER NOT LOGGED OUT");
		}
	}

}
