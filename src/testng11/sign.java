package testng11;



	import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

	public class sign {

			WebDriver d;
			@Test()
			public void setUp1() throws Exception{
			d.get("https://www.facebook.com/");
			assertEquals("Facebook - Log In or Sign Up",d.getTitle());
			System.out.println(d.getTitle());
			d.findElement(By.id("email")).sendKeys("selenium");
			d.findElement(By.id("pass")).sendKeys("selenium");
			d.findElement(By.id("u_0_l")).click();
			Thread.sleep(4000);
		}
			@Parameters("browser")
			@BeforeMethod
			public void setUp(String browser)
			{

				//Launch browser
		    	if(browser.equals("FF"))
		    	{
		    		d=new FirefoxDriver();
		    	}
		    	else if(browser.equals("GC"))
		    	{
		    		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\lib\\chromedriver.exe");
		    		d=new ChromeDriver();
		    	}
		    	else if(browser.equals("IE"))
		    	{
		    		System.setProperty("webdriver.ie.driver", "E:\\selenium\\lib\\IEDriverServer.exe");
		    		d=new InternetExplorerDriver();
		    	}
				
				d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				d.manage().deleteAllCookies();		
			}
			@AfterMethod
			public void tearDown()
			{
		
	                  d.close();
	                  
	                  
			}

		}