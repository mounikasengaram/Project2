package testng11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class junitf {

	public static void main(String[] args) throws Exception 
	{

		System.setProperty("webdriver.chrome.driver","D:\\Root\\new lib\\chromedriver.exe");
		 WebDriver d =new ChromeDriver();
		//Load web page
		d.get("https://www.facebook.com/");
		//Print page title
		//System.out.println("Page title is:"+d.getTitle());
		//Verify page title
		Assert.assertEquals("Facebook - Log In or Sign Up",d.getTitle());
		//Enter user name
		d.findElement(By.id("email")).sendKeys("Selenium");
		//Enter password
		d.findElement(By.id("pass")).sendKeys("Selenium");
		//Click on Login button
		d.findElement(By.id("u_0_l")).click();
		//Pause 4sec
		Thread.sleep(4000);
	
	d.close();
	}}