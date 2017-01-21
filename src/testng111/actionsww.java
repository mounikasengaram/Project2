package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class actionsww {
WebDriver d;
@Test()
public void SetUp1(){

	    d.get("http://fleet.idrivesafely.com");
	    d.manage().window().maximize();
	    d.findElement(By.linkText("Student Login")).click();
	    WebElement loc=d.findElement(By.className("input1"));
	    Actions builder=new Actions(d);
        builder.moveToElement(loc).click(loc)
                .keyDown(Keys.SHIFT).sendKeys(loc, "mouni")
                .keyUp(Keys.SHIFT).build().perform(); 

}
@BeforeMethod
public void SetUp2(){
	
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
}
