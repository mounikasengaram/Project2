package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seleniumtab {
WebDriver d;
@Test
public void SetUp1() throws Exception
{
	d.get("http://www.seleniumhq.org/");
	Assert.assertEquals("Selenium - Web Browser Automation",d.getTitle());
	Actions a= new Actions(d);
	WebElement f=d.findElement(By.linkText("Projects"));
	a.moveToElement(f).sendKeys(Keys.CONTROL).click(f).build().perform();

	Thread.sleep(2000);
    d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
    Thread.sleep(3000);
    d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
    Thread.sleep(3000);
    d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
    Thread.sleep(3000);
    
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
