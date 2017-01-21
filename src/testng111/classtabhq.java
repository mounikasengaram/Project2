package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class classtabhq {
WebDriver d;
@Test
public void Setpuu() throws Exception{
	d.get("http://www.seleniumhq.org/");
	 WebElement ff=d.findElement(By.linkText("Projects"));
	Actions a=new Actions(d);
	a.moveToElement(ff).keyDown(Keys.CONTROL).click(ff).build().perform();
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(6000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(6000);

	
	
}
@BeforeMethod()
public void SetUo11(){

	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
@AfterMethod()
public void Setup333(){
	d.close();
}
}
