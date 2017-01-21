package testng111;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class multiplewindows {
WebDriver d;
@Test()
public void SetUp1(){
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	Assert.assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
	d.findElement(By.linkText("Food-on-Track")).click();
	Set<String> h=d.getWindowHandles();
	System.out.println("number of handles");
	String handles[]=new String[h.size()];
	int i=0;
	for(String f:h)
	{
		System.out.println(f);
		handles[i]=f;
		i++;
	}
	d.switchTo().window(handles[0]);
	d.findElement(By.xpath("//input[@id='loginbutton']")).click();
	Alert al=d.switchTo().alert();
	al.accept();
	d.switchTo().window(handles[1]);
	Assert.assertTrue(d.findElement(By.xpath("//input[@id='stnCode']")).isDisplayed());
	System.out.println(d.findElement(By.xpath("//input[@id='stnCode']")).isDisplayed());
	
}
@Parameters("browser")
@BeforeMethod
public void SetUp2(String browser) throws Exception{
	if(browser.equals("FF")){
		//d=new FirefoxDriver();
		d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
	}
	else if(browser.equals("GC"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\lib\\chrome.driver");
	 d=new ChromeDriver();;
	}
	else if(browser.equals("IE"))
	{
		 System.setProperty("webdriver.ie.driver","F:\\Driver Server\\IEDriverServer.exe");
		 d=new InternetExplorerDriver();
	}
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
	@AfterMethod
	public void SetUp3(){
		d.close();
	}
}

