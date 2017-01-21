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

public class mouseover1 {
	WebDriver d;

	@Test()
	public void SetUp1() throws Exception {
		d.get("http://www.ucliditschool.com/");
		Assert.assertEquals("UCLID IT School | Think about Oracle Think About UCLID", d.getTitle());
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//ul[@id='main-nav']/li[2]/a"))).perform();
		List<WebElement> aboutlist = d.findElements(By.xpath("//*[@id='main-nav']/li[2]/ul/li"));
		String aboutstore[] = new String[aboutlist.size()];
		int a2 = 0;
		for (WebElement s : aboutlist) {
			System.out.println("name =" + s.getText());
			aboutstore[a2] = s.getText();
			a2++;
		}
		for (int i = 0; i < aboutlist.size(); i++) {
			d.findElement(By.linkText(aboutstore[i])).click();

			a.moveToElement(d.findElement(By.xpath("//ul[@id='main-nav']/li[2]/a"))).perform();
		}
		// d.findElement(By.xpath("//li[2]/ul/li[2]/a/span")).click();
		// d.findElement(By.linkText("Uclid IT School")).click();
		// d.findElement(By.xpath("//button[@class='section-header-directions
		// noprint']")).click();
		Thread.sleep(6000);
		a.moveToElement(d.findElement(By.xpath("//ul[@id='main-nav']/li[4]/a/span"))).perform();
		List<WebElement> store = d.findElements(By.xpath("//ul[@id='main-nav']/li[4]/ul/li"));
		String store1[] = new String[store.size()];
		int j = 0;
		for (WebElement f : store) {
			System.out.println("name=" + f.getText());
			store1[j] = f.getText();
			j++;
		}
		int k;
		for (k = 0; k < store.size(); k++) {
			d.findElement(By.linkText(store1[k])).click();
			a.moveToElement(d.findElement(By.xpath("//ul[@id='main-nav']/li[4]/a/span"))).perform();
		}
	}

	@BeforeMethod()
	public void SetUp2() {
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterMethod()
	public void SetUp3() {
		d.close();
	}
}
