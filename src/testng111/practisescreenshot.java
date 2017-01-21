package testng111;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practisescreenshot {
	WebDriver d;
	@Test()
	public void SetUp1() throws Exception{
		d.get("http://www.seleniumhq.org/");
		d.findElement(By.linkText("Projects11")).click();
     DateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy HH-mm-ss");
     Date dt=new Date();
     File Scrfile=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(Scrfile,new File("E:\\selenium\\testresults\\"+dateformat.format(dt)+".png"));
    
     
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