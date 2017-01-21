package testng111;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class twobrowser {
		public static void main(String args[])throws Exception
		{
			WebDriver Browser1=new FirefoxDriver();
			Browser1.get("http://www.Yahoo.com");
			System.out.println(Browser1.getTitle());
			
			WebDriver Browser2=new FirefoxDriver();
			Browser2.get("http://www.gmail.com");

	System.out.println(Browser2.getTitle());
			Thread.sleep(2000);
						//Browser1.close();
						
		}

	}

