package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class linksdemo {
	WebDriver d;
	@Test
	public void Setup1(){
		d.get("http://www.seleniumhq.org/");
		Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement>f=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("no of links:"+f.size());
		String links[]=new String[f.size()];
		int i=0;
		for(WebElement g:f)
		{
			System.out.println("no of links:"+g.getText());
			links[i]=g.getText();
			i++;
		}
		int j=0;
		for(j=0;j<f.size();j++){
			d.findElement(By.linkText(links[j])).click();
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


