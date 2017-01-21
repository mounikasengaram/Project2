package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fileupload {
	public class filedownload {
		WebDriver d;
		@Test()
		public void SetUp1() throws Exception{
			d.get("https://www.sendspace.com/");
			d.findElement(By.id("upload_file")).click();
			Thread.sleep(2000);
			new ProcessBuilder("E:\\selenium\\autoit\\fileupload.exe").start();
			Thread.sleep(1000);
			
		}
		@BeforeMethod
		public void SetUp2(){
			
			
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		}
		}

}
