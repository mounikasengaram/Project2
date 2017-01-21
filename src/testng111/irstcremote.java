package testng111;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class irstcremote {
	WebDriver d;
	@Test()
	public void SetUp1(){
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		Assert.assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		for(int i=0;i<=10;i++){
			((RemoteWebDriver) d).executeScript("window.scrollBy(0,200)");
		}

}
    //((RemoteWebDriver) d).executeScript("window.scrollBy(0,300)");
   // Thread.sleep(1000);
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
