package testng111;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class paytime {
WebDriver d;
@Test()
public void SetUp2(){
	d.get("https://www.google.co.in");
	d.findElement(By.xpath("//div[@id='gs_lc0']/child::input[@id='gs_htif0']")).sendKeys("appium");

	
}

@BeforeMethod()
public void SetUp1(){
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
}
