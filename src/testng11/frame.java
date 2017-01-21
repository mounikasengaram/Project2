package testng11;


	
import java.net.URL;
import java.util.concurrent.TimeUnit;

	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
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

	public class frame {
		WebDriver d;
		@Test
		public void SetUp() throws Exception{
			d.get("http://www.seleniumhq.org/");
			Assert.assertTrue(d.findElement(By.id("q")).isDisplayed());
			System.out.println(d.findElement(By.id("q")).isDisplayed());
			d.findElement(By.id("q")).sendKeys("eclipse");
			d.findElement(By.id("submit")).click();
			d.switchTo().frame(d.findElement(By.tagName("iframe")));
			d.findElement(By.xpath("//*[@id='e2']/span/b")).click();	
			Thread.sleep(4000);
		}
		@Parameters("browser")
		@BeforeMethod
		public void setUp(String browser) throws Exception
		{

			//Launch browser
	    	if(browser.equals("FF"))
	    	{
	    	      // d=new FirefoxDriver();
	    		d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
	    	}
	    
	    	else if(browser.equals("GC"))
	    	{
	    		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\lib\\chromedriver.exe");
	    		d=new ChromeDriver();
	    		//d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());
	    	}
	    	else if(browser.equals("IE"))
	    	{
	    		System.setProperty("webdriver.ie.driver", "D:\\Selenium_Batch_files\\Lib\\IEDriverServer.exe");
	    		d=new InternetExplorerDriver();
	    		//d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.internetExplorer());
	    	}
			
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			d.manage().deleteAllCookies();		
		}
		@AfterMethod
		public void tearDown()
		{
			//Close browser
			d.close();
		}

	}

	