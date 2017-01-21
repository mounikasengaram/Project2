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

public class tab1 {
WebDriver d;
@Test()
public void SetUp1() throws Exception{
	d.get("http://www.seleniumhq.org/about/");
	WebElement ff=d.findElement(By.xpath("//a[contains(text(),'Contributors')]"));
	WebElement gg=d.findElement(By.xpath("//a[contains(text(),'News/Blog')]"));
	Actions a=new Actions(d);
	a.moveToElement(gg).keyDown(Keys.CONTROL).click(gg).build().perform();
	Thread.sleep(3000);
	a.moveToElement(ff).keyDown(Keys.CONTROL).click(ff).build().perform();
	Thread.sleep(6000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	
	
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
