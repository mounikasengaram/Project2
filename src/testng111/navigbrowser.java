package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class navigbrowser {
WebDriver d;
@Test()
public void SetUp1() throws Exception{
	
	d.get("http://www.seleniumhq.org/");
	Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
   d.findElement(By.linkText("Download")).click();
	Thread.sleep(2000);
	d.navigate().back();
	Thread.sleep(2000);
	d.navigate().forward();
	Thread.sleep(2000);
	d.navigate().refresh();
	Thread.sleep(2000);
	
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
