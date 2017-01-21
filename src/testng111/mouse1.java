package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mouse1 {
WebDriver d;
@Test()
public void SetUp()
{
	d.get("https://aptransport.in/TGCFSTONLINE/Reports/VehicleRegistrationSearch.aspx");
	Assert.assertEquals("Welcome To TRANSPORT DEPARTMENT GOVERNMENT OF TELANGANA - INDIA",d.getTitle());
	Actions a = new Actions(d);
	a.moveToElement(d.findElement(By.xpath("//div[@id='smoothmenu1']/ul/li/a"))).perform();
	List<WebElement>f=d.findElements(By.xpath("//*[@id='smoothmenu1']/ul[1]/li/ul/li/a"));
	System.out.println("no of sugg"+f.size());
	String store[]=new String[f.size()];
	int i=0;
	for(WebElement g:f)
	{
		System.out.println("no of suggestions"+g.getText());
		store[i]=g.getText();
		i++;
	}
	int k=0;
	for(k=0;k<f.size();k++){
		d.findElement(By.linkText(store[k])).click();
	}
	
	
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

