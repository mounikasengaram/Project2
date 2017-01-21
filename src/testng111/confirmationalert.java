package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class confirmationalert {
WebDriver d;
@Test
public void Setup() throws Exception{
	d.get("http://output.jsbin.com/enifaf");
	d.findElement(By.cssSelector("button")).click();
	Alert al=d.switchTo().alert();
	Assert.assertEquals("Press a button!",al.getText());
	al.dismiss();
}

	@BeforeMethod
	public void SetUp1(){
		d= new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
		@AfterMethod
		public void SetUp2(){
			d.close();
		}
	}
