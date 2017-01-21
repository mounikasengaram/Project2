package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seleniumhqxpath {
WebDriver d;
@Test()
public void SetUp(){
	d.get("http://www.seleniumhq.org/");
	d.findElement(By.xpath("//li[@id='menu_projects']//a[text()='projects']")).click();
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