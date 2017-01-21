package testng11;

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

public class tab {
WebDriver d;
@Test()
public void SetUPP() throws Exception{
	d.get("http://www.seleniumhq.org/");
	WebElement store=d.findElement(By.linkText("Projects"));
	WebElement store1=d.findElement(By.linkText("Download"));
	Actions a= new Actions(d);
	a.moveToElement(store).keyDown(Keys.CONTROL).click(store).build().perform();
	a.moveToElement(store1).keyDown(Keys.CONTROL).click(store1).build().perform();
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
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
