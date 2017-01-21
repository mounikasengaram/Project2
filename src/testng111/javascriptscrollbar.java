package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javascriptscrollbar {
WebDriver d;
@Test()
public void SetUp1() throws Exception{
	d.get("http://jquery.com/");
	//Creating the Javascriptexecutor interface object by Type casting
	   JavascriptExecutor js = (JavascriptExecutor)d;
	 //Vertical scroll - down by 200  pixels
	   js.executeScript("window.scrollBy(0,200)");
	   System.out.println("Successfully did the vertical scroll by 200px");
	   Thread.sleep(5000);
	   d.findElement(By.linkText("jQuery Blog")).click();
	
		
}
@BeforeMethod()
public void SetUp21(){
	d= new FirefoxDriver();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	d.manage().window().maximize();
}
@AfterMethod()
public void SetUp45(){
	d.close();
}
}