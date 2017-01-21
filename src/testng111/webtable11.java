package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webtable11 {
	WebDriver d;
	@Test()
	public void SetUp21() throws Exception{
		d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		Select dd=new Select(d.findElement(By.xpath("//select[@id='Select1']")));
		dd.selectByVisibleText("Agriculture and Co-Operation");
		Thread.sleep(5000);
	
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

