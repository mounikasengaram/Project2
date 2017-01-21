package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class fileoutputstream {
	WebDriver d;
	@Test
	public void dataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("E:\\selenium\\testresults\\Book111.xls");
		WritableWorkbook wwb=Workbook.createWorkbook(fos);
		WritableSheet ws1=wwb.createSheet("Results1",0);
		WritableSheet ws2=wwb.createSheet("Results2",1);
		Label l1=new Label(0,0,"Selenium");
		ws1.addCell(l1);
		Label l2=new Label(0,0,"Selenium");
		ws2.addCell(l2);
		Label l3=new Label(1,1,"Appium");
		ws1.addCell(l3);
		Label l4=new Label(0,0,"Selenium");
		ws2.addCell(l4);
		Label l5=new Label(2,2,"QTP");
		ws1.addCell(l5);
		Label l6=new Label(0,0,"Selenium");
		ws2.addCell(l6);
		wwb.write();
		wwb.close();
	}

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
