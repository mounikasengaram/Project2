package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class frame2 {
	WebDriver d;
	@Test()
	public void SetUp()
	{
		d.get("http://jqueryui.com/autocomplete/");
		Assert.assertEquals("Autocomplete | jQuery UI",d.getTitle());
		List<WebElement>f=d.findElements(By.tagName("iframe"));
		System.out.println(f.size());
		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement>store=d.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println(store.size());
		for(WebElement h:store)
		{
			System.out.println(h.getText());
		}
		int k=0;
		for(k=0;k<4;k++){
			d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
			d.findElement(By.id("tags")).click();
		}
		d.switchTo().defaultContent();
		d.findElement(By.linkText("Droppable")).click();
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDrop(d.findElement(By.xpath("//div[@id='draggable']")),d.findElement(By.xpath("//div[@id='droppable']"))).perform();
		
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

