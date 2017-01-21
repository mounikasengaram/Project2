package testng111;

import java.util.concurrent.TimeUnit;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class multiframe {
WebDriver d;
@Test()
public void SetUp() throws Exception{
	d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
	List<WebElement>f=d.findElements(By.tagName("frame"));
	System.out.println(f.size());
	for(WebElement g:f){
		System.out.println(g.getText());
	}
	d.switchTo().frame(0);
	d.findElement(By.linkText("com.thoughtworks.selenium")).click();
	Thread.sleep(5000);
	d.switchTo().defaultContent();
	d.switchTo().frame(1);
	d.findElement(By.linkText("BrowserConfigurationOptions")).click();
	Thread.sleep(6000);
	d.switchTo().defaultContent();
	d.switchTo().frame(2);
	d.findElement(By.xpath("//ul[@class='navList']/li[1]/a")).click();
	Thread.sleep(5000);
	d.switchTo().defaultContent();
	
	
	
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

