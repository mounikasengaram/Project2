package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class draganddrop22 {
	WebDriver d;
	@Test
	public void Setup() throws Exception{
		d.get("http://code.makery.ch/library/dart-drag-and-drop/");
	Assert.assertEquals("Dart Drag and Drop | code.makery.ch", d.getTitle());
	for (int n = 0; n < 5; n++) {
		((RemoteWebDriver) d).executeScript("window.scrollBy(0,150)");
		Thread.sleep(3000);
	}
     d.switchTo().frame(0);
     Actions a=new Actions(d);
     for( int i=0;i<=4;i++){
    	 a.dragAndDrop(d.findElement(By.xpath("//img[@src='images/document.png']")),d.findElement(By.xpath("//div[@class='container']/div"))).perform();
     Thread.sleep(4000);
     }
	
	

}

@BeforeMethod()
public void SetUp1(){
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

@AfterMethod()
public void SetUp3(){
d.close();;
}
}


