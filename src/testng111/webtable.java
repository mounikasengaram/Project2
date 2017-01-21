package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webtable {
WebDriver d;
@Test()
public void SetIp(){
	d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
	Select dd=new Select(d.findElement(By.id("Select1")));
	dd.selectByVisibleText("Agriculture and Co-Operation");
	List<WebElement>tr_collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
	System.out.println("no of rows= "+tr_collection.size());
	List<WebElement>td_collection=d.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
	System.out.println("no of columns= "+td_collection.size());
	int rownum,columnnum;
	rownum=1;
	for(WebElement tr:tr_collection){
		List<WebElement>td_collection1=tr.findElements(By.xpath("td"));
		System.out.println("no of columns= "+td_collection1.size());
		columnnum=1; 
		for(WebElement td:td_collection1){
			System.out.println("row1 # "+rownum+" colm1 # "+columnnum+",Text="+td.getText());
			columnnum++;
		}
		rownum++;
			
			
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
