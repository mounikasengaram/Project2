package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sign11 {

	WebDriver d;

	@Test()
	public void SetUp1() throws Exception {
		d.get("http://www.vedicsoft.com/contact/");
		Assert.assertEquals("Contact | Vedicsoft Solutions LLC", d.getTitle());
		List<WebElement> menu = d.findElements(By.cssSelector("#menu-primary-menu"));
		System.out.println("no of suggestions:" + menu.size());
		for (WebElement f : menu) {
			System.out.println(f.getText());
		}
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.cssSelector("#menu-item-2911"))).perform();
		//d.findElement(By.cssSelector("#menu-item-2913 > a")).click();
		List<WebElement> f = d.findElements(By.xpath("(//ul[@class='sub-menu'])[1]/li"));
		System.out.println("no of suggestions:" + f.size());
		String fstore[]=new String[f.size()];
		int i=0;
		for (WebElement menu1 : f) {
			System.out.println(menu1.getText());
			fstore[i]=menu1.getText();
		}
		for(int i1=0;i1<f.size();i1++)
		{
			d.findElement(By.linkText(fstore[i])).click();
			
			a.moveToElement(d.findElement(By.cssSelector("#menu-item-2911"))).perform();
		}
	}

	@BeforeMethod()
	public void SetUp() {
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod()
	public void SetUp3() {
		d.close();
	}
}
