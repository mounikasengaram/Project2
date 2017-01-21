package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class framedemo {
	WebDriver d;
	@Test
	public void Setup() throws Exception{
		d.get("http://www.seleniumhq.org/");
		Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
		d.findElement(By.xpath("//input[@id='q']")).sendKeys("eclipse");
		d.findElement(By.xpath("//input[@id='submit']")).click();
		d.switchTo().frame(0);
		d.findElement(By.xpath("//a[@id='e2']/span")).click();
		Thread.sleep(5000);
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//div[@id='menu']/ul/li[2]/a"))).perform();
		d.findElement(By.xpath("//div[@id='menu']/ul/li[2]/ul/li[2]/a")).click();
		List<WebElement>f=d.findElements(By.xpath("//div[@id='menu']/ul/li[2]"));
		System.out.println("no of sugg"+f.size());
		String store[]=new String[f.size()];
		int i=0;
		for(WebElement g:f)
		{
			System.out.println("no of suggestions"+g.getText());
			store[i]=g.getText();
			i++;
		}
		int k=0;
		for(k=0;k<f.size();k++){
			d.findElement(By.linkText(store[k])).click();
		}
		
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
