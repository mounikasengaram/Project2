package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class thirdscenario {
	WebDriver d;
	@Test()
	public void SetUp2() throws Exception{
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		//verifytitle
		Assert.assertEquals("Indianbank-Hyderabad",d.getTitle());
		//login as admin
		//Enter username
		d.findElement(By.id("cyclosUsername")).sendKeys("46702");
		//password
		d.findElement(By.id("cyclosPassword")).sendKeys("mounika4513");
		//submit
		d.findElement(By.xpath("//input[@class='button']")).click();
		//click on payment action
		d.findElement(By.xpath("//div[@id='tdContents']/table[1]/tbody/tr[2]/td/table/tbody/tr/td[3]/a")).click();
		//enter login recepient
		d.findElement(By.xpath("//input[@id='memberName']")).sendKeys("laxman");
		//d.findElement(By.xpath("//input[@id='memberName']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		//enter amount
		d.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
		//descrption
		d.findElement(By.xpath("//textarea[@id='description']")).sendKeys("payment to member");
		//click
		d.findElement(By.xpath("//input[@id='submitButton']")).click();
		//enter transaction password
		d.findElement(By.xpath("//input[@value='A']")).click();
		d.findElement(By.xpath("//input[@value='G']")).click();
		
		d.findElement(By.xpath("//input[@value='C']")).click();
		d.findElement(By.xpath("//input[@value='F']")).click();
		d.findElement(By.xpath("//input[@value='Submit']")).click();
		
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
