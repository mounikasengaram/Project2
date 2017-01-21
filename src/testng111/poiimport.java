package testng111;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class poiimport {
	WebDriver d;
	@Test()
	public void SetUp() throws Exception{
	d.get("https://www.google.co.in");
	Assert.assertEquals("Google",d.getTitle());
	FileInputStream fis=new FileInputStream("E:\\selenium\\testresults\\Book1.xlsx");
	XSSFWorkbook wb =new XSSFWorkbook(fis);
	XSSFSheet s=wb.getSheetAt(0);
	for(int i=0;i<s.getLastRowNum()+1;i++)
	{
		d.findElement(By.id("lst-ib")).clear();
		d.findElement(By.id("lst-ib")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
		Thread.sleep(2000);
	}
	
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
