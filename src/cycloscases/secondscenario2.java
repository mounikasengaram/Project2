package cycloscases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class secondscenario2 {
WebDriver d;
@Test()
public void SetUp1() throws Exception{
	d.get("http://183.82.118.175:8080/Cyclos/do/login");
	//verifytitle
	Assert.assertEquals("Indianbank-Hyderabad",d.getTitle());
	//login as admin
	//Enter username
	d.findElement(By.id("cyclosUsername")).sendKeys("admin");
	//password
	d.findElement(By.id("cyclosPassword")).sendKeys("admin");
	//submit
	d.findElement(By.xpath("//input[@class='button']")).click();
	//
	d.findElement(By.cssSelector("#memberUsername")).sendKeys("62803");
	Thread.sleep(3000);
	d.findElement(By.xpath("//*[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr[8]/td/fieldset/table/tbody/tr[1]/td[4]/input")).click();
	d.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
	d.findElement(By.xpath("//textarea[@id='description']")).sendKeys("grant a loan");
	d.findElement(By.xpath("//div[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[17]/td/input")).click();
	d.findElement(By.xpath("//div[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[7]/td/input")).click();
	Alert al=d.switchTo().alert();
	Assert.assertEquals("The loan was successfully granted",al.getText());
	al.accept();
	Thread.sleep(4000);
	WebElement f=d.findElement(By.xpath("//*[@id='tdContents']/form/table/tbody/tr[1]/td[1]"));
	System.out.println(f.isDisplayed());
}
@BeforeMethod()
public void SetUp2(){
	d=new FirefoxDriver();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	d.manage().window().maximize();
}
@AfterMethod()
public void SetUp3(){
	d.close();
}
}