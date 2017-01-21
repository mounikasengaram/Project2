package testng111;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class draganddropby {
	WebDriver d;
	@Test()
	public void SetUp() throws Exception{
		d.get("http://jqueryui.com/slider/");
		Assert.assertEquals("Slider | jQuery UI",d.getTitle());
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")),150,0).perform();
		Thread.sleep(5000);
		
	}
		
	


@BeforeMethod()
public void SetUp1(){
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

@AfterMethod()
public void SetUp2(){
	d.close();
}
}
