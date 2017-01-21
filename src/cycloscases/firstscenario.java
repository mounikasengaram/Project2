package cycloscases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class firstscenario {
WebDriver d;
@Test()
public void Setup1(){
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
	//click on usergroups
	d.findElement(By.xpath("//li[@id='menu5']/span[2]")).click();
	//click on manage members
	d.findElement(By.xpath("//li[@id='submenu5.0']/span[2]")).click();
	//click on create member
	Select dd=new Select(d.findElement(By.xpath("//select[@id='newMemberGroup']")));
	dd.selectByVisibleText("Full members");
	//enter full name
	d.findElement(By.xpath("//input[@name='member(name)']")).sendKeys("mounika0909");
	//enter emailid
	d.findElement(By.xpath("//input[@name='member(email)']")).sendKeys("mounika0909@gmail.com");
	//Assign password
	d.findElement(By.xpath("//input[@id='assignPasswordCheck']")).click();
	d.findElement(By.xpath("//input[@name='member(user).password']")).sendKeys("mounika0909");
	d.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mounika0909");
	//submit
	d.findElement(By.xpath("//input[@id='saveAndNewButton']")).click();
	Alert al=d.switchTo().alert();
	//member has been created dailogue box must be displayed
	Assert.assertEquals("The member has been created, however, the activation mail could not be sent",al.getText());
	al.accept();
	//Logout
	d.findElement(By.xpath("//li[@id='menu15']/span[2]")).click();
	al.accept();
	//Login with member id and check for the profile creation
	//memberid
	d.findElement(By.id("cyclosUsername")).sendKeys("46702");
	//password
	d.findElement(By.id("cyclosPassword")).sendKeys("mounika4513");
	//submit
	d.findElement(By.xpath("//input[@class='button']")).click();
	
	
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