package testng11;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class jquerytab {
WebDriver d;
@Test()
public void Setup1() throws Exception{
	d.get("https://jqueryui.com/");
	WebElement f=d.findElement(By.xpath("//a[contains(text(),'Plugins')]"));
	Actions a= new Actions(d);
	a.moveToElement(f).keyDown(Keys.CONTROL).click(f).build().perform();
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
}
@Parameters("browser")
@BeforeMethod()
public void Setup2(String browser) throws Exception{
	if(browser.equals("FF"))
	{
      //d=new FirefoxDriver();
		d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
	}
    
	else if(browser.equals("GC"))
	{
		System.setProperty("Webdriver.chrome.driver","E:\\selenium\\lib\\chrome.exe");
		//d=new ChromeDriver();
		d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());
	}
	else if(browser.equals("IE")){
		System.setProperty("Webdriver.ie.driver","E:\\selenium\\lib\\IEDriver.exe");
		d=new InternetExplorerDriver();
		d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.internetExplorer());
	}
}

@AfterMethod
public void Setup2(){
	d.close();
}
	
}
