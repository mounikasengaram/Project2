package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class draggable1 {
	WebDriver d;
	@Test()
	public void SetUp(){
		d.get("http://jqueryui.com/draggable/");
		Assert.assertEquals("Draggable | jQuery UI",d.getTitle());
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='draggable']")),150,0).perform();

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