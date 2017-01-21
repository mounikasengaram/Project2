package testng111;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class multipleactions {
WebDriver d;
@Test()
public void SetUp1() throws Exception{
	d.get("https://www.facebook.com/");
	Assert.assertEquals("Facebook - Log In or Sign Up",d.getTitle());
	WebElement gg=d.findElement(By.id("email"));
	Actions a=new Actions(d);
	//a.moveToElement(gg).click().keyDown(Keys.SHIFT).sendKeys("mouni").keyUp(Keys.SHIFT).doubleClick().contextClick().build().perform();
	//a.moveToElement(gg).click().keyDown(Keys.SHIFT).sendKeys("welco").keyUp(Keys.SHIFT).sendKeys("mouni").keyDown(Keys.SHIFT).sendKeys("mouni").build().perform();
	a.moveToElement(gg).click(gg) .keyDown(Keys.SHIFT).sendKeys(gg, "mouni")
    .keyUp(Keys.SHIFT).sendKeys(gg,"mou").keyDown(Keys.SHIFT).sendKeys(gg,"mouni").keyUp(Keys.SHIFT).build().perform(); 
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






















          

