package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class autocomplete11 {
WebDriver d;
@Test
public void Setup1(){
	d.get("http://www.tsrtconline.in/oprs-web/");
	Assert.assertEquals("TSRTC Official Website for Online Bus Ticket Booking - tsrtconline.in",d.getTitle());
	d.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("hyd");
	List<WebElement>f=d.findElements(By.xpath("//li[@class='ui-menu-item']"));
	System.out.println(f.size());
	for(WebElement e:f){
		System.out.println(e.getText());
	}
	d.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
	d.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys("bang");
	List<WebElement>g=d.findElements(By.xpath("//ul[@id='ui-id-2']/li"));
	System.out.println(g.size());
	for(WebElement h:g){
		System.out.println(h.getText());
	}
	d.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
	
	
	
}
@BeforeMethod()
public void SetUp2(){
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

@AfterMethod()
public void SetUp3(){
d.close();;
}
}
