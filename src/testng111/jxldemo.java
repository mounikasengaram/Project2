package testng111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class jxldemo {
	WebDriver d;
	@Test()
	public void SetUp() throws Exception{
	d.get("https://www.google.co.in");
	Assert.assertEquals("Google",d.getTitle());
	FileInputStream fis= new FileInputStream("E:\\selenium\\testresults\\Results.xls");
	Workbook Wb=Workbook.getWorkbook(fis);
	Sheet s=Wb.getSheet(0);
	for(int i=0;i<s.getRows();i++)
	{
		d.findElement(By.id("lst-ib")).clear();
		d.findElement(By.id("lst-ib")).sendKeys(s.getCell(0, i).getContents());
	}}
	
	
			
	
	@BeforeMethod()
	public void SetUp1(){
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}

	@AfterMethod()
	public void SetUp2(){
		d.close();
	}



	}