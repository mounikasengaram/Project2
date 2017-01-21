package testng111;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windows {
WebDriver d;
@Test()
public void SetUp1(){
	d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	
	Set<String>ff=d.getWindowHandles();
	System.out.println(ff.size());
	String handles[]=new String[ff.size()];
	int i=0;
	for(String gg:ff ){
		System.out.println(gg);
		handles[i]=gg;
		i++;
	}
}
@BeforeMethod
public void setUp()
{
	// Launch browser
	d=new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver","F:\\Driver Server\\chromedriver.exe");
	//d =new ChromeDriver();
	//System.setProperty("webdriver.ie.driver","F:\\Driver Server\\IEDriverServer.exe");
	//d = new InternetExplorerDriver();
	 // Maximize window
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
@AfterMethod
public void tearDown()
{
    //  Close browser
	d.quit();
}


}
