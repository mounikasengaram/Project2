package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class multipleactions111 {
	public class multipleactions {
		WebDriver d;
		@Test()
		public void SetUp1() throws Exception{
			d.get("https://www.facebook.com/");
			Assert.assertEquals("Facebook - Log In or Sign Up",d.getTitle());
			WebElement gg=d.findElement(By.id("email"));
			Actions a=new Actions(d);
			a.moveToElement(gg).click().keyDown(Keys.SHIFT).sendKeys(gg,"mounikk").keyUp(Keys.SHIFT).sendKeys("singmm")
			.keyDown(Keys.SHIFT).sendKeys("mni").keyUp(Keys.SHIFT).sendKeys(gg,Keys.TAB).build().perform();
			//doubleClick(gg).contextClick(gg).sendKeys(Keys.DOWN).click().sendKeys(Keys.RETURN).build().perform();
			Thread.sleep(6000);
		}
		@BeforeMethod()
		public void SetUo11() throws Exception{
		     d=new FirefoxDriver();
			//d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		}
		@AfterMethod()
		public void Setup333(){
			d.close();
		}
		}








}
