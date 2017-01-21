package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class draganddrop {
	WebDriver d;
	@Test()
	public void SetUp(){
		d.get("http://jqueryui.com/droppable/");
		Assert.assertEquals("Droppable | jQuery UI",d.getTitle());
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDrop(d.findElement(By.xpath("//div[@id='draggable']")),d.findElement(By.xpath("//div[@id='droppable']"))).perform();
	}

	@Parameters("browser")
	@BeforeMethod
	public void SetUp2(String browser){
		if(browser.equals("FF")){
			d=new FirefoxDriver();
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

