package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class remoteweb {
	WebDriver d;
	@Test
	public void Setup() throws Exception{
		d.get("http://www.seleniumhq.org/");
		Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
		for(int i=0;i<=10;i++){
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,300)");
		}
		
		
}
@BeforeMethod()
public void SetUp2(){
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

@AfterMethod()
public void SetUp3(){
d.close();;
}
}

