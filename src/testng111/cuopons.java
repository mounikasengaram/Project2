package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cuopons {
	WebDriver d;
@Test()
public void SetUp1(){
	d.get("https://www.coupons.com/");
	d.findElement(By.xpath("//span[@id='ui-id-2']/following::button")).click();
	d.findElement((By.xpath("//a[@class='signup']"))).click();
	//d.findElement(By.xpath("//button[starts-with(@class,'ui-button')]")).click();
	//d.findElement(By.xpath("//button[contains(@class,'ui-dialog-titlebar-close')]")).click();
	d.findElement(By.xpath("//input[@id='signup-email']")).sendKeys("mounika.singaram20@gmail.com");
	d.findElement(By.xpath("//input[@id='signup-password']")).sendKeys("mounika123");
	
	
}
@BeforeMethod()
public void SetUp2(){
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
@AfterMethod()
public void SetUp3(){
	d.quit();
}
}

