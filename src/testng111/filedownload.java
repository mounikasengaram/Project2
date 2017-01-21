package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class filedownload {
WebDriver d;
@Test()
public void SetUp1() throws Exception{
	d.get("http://www.seleniumhq.org/");
	d.findElement(By.linkText("Download")).click();
	Thread.sleep(2000);
	d.findElement(By.linkText("3.0.1")).click();
	Thread.sleep(1000);
	new ProcessBuilder("E:\\selenium\\autoit\\download.exe").start();
	Thread.sleep(1000);
	
}
@BeforeMethod
public void SetUp2(){
	
	
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
}
