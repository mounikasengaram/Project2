package testng111;

	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	public class frame1 {
		WebDriver d;
		@Test
		public void testFrame() throws Exception
		{
			d.get("http://jqueryui.com/autocomplete/");
			Assert.assertEquals("Autocomplete | jQuery UI",d.getTitle());
			List<WebElement> f=d.findElements(By.tagName("iframe"));
			System.out.println(f.size());
			d.switchTo().frame(d.findElement(By.className("demo-frame")));
			d.findElement(By.id("tags")).sendKeys("a");
		}
		@BeforeMethod
		public void setUp()
		{
			// Launch browser
			d=new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver","F:\\Driver Server\\chromedriver.exe");
			//d =new ChromeDriver();
			System.setProperty("webdriver.ie.driver","F:\\Driver Server\\IEDriverServer.exe");
			//d = new InternetExplorerDriver();
			 // Maximize window
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		@AfterMethod
		public void tearDown()
		{
		    //  Close browser
			d.quit();
		}


	}


