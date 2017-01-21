package testng11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class tabprog {
WebDriver d;
@Test()
public void Setup() throws Exception{
	d.get("http://www.seleniumhq.org/");
	WebElement f=d.findElement(By.xpath("//a[contains(text(),'Projects')]"));
	Actions a=new Actions(d);
	a.moveToElement(f).keyDown(Keys.CONTROL).click(f).build().perform();
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
	Thread.sleep(3000);
	d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
  Thread.sleep(3000);
  d.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"\t");
  Thread.sleep(3000);
	
}
@Parameters("browser")
@BeforeMethod
public void SetUp1(String browser){
	if(browser.equals("FF"))
	{
		d=new FirefoxDriver();
	}
	else if(browser.equals("GC"))
	{
		
		System.setProperty("Webdriver.chrome.driver","E:\\selenium\\lib\\chromedriver.exe");
		d=new ChromeDriver();
	}
	else if(browser.equals("IE")){
		System.setProperty("WebDriver.ie.driver","E:\\selenium\\lib\\IE.exe");
		d=new InternetExplorerDriver();
	}
}
@AfterMethod()
public void Setup2(){
	
	
}
}