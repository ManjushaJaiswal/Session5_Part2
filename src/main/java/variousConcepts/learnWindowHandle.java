package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class learnWindowHandle {

	
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");


		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void windowHandle()  {
	//	System.out.println(driver.getTitle());
		//String windowHandle1= driver.getWindowHandle();
	//	System.out.println(windowHandle1);
		
		
		//**by using this windowhandle method we can get trace of the drive of each windows
		//**by driver.getTitle and by using syso we can get to know the title of the window.
		
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
	//	System.out.println(driver.getTitle());
	//	String windowHandle2= driver.getWindowHandle();
	//	System.out.println(windowHandle2);
		
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		
		Set<String> Handles= driver.getWindowHandles();
		//System.out.println(Handles);		
		//by using set of <String> handles it will give us the trace of all set of windows uniqueId
		//once we run using syso;
		
		for(String i: Handles ) {
			System.out.println(i);
			System.out.println(driver.getTitle());
			driver.switchTo().window(i);
		}
		
		//here using for each loop we are handling each windows and we can switch that
		//window to another using that loop and driver.switch.window(i)--for each iteration
		
		
		
	//	System.out.println(windowHandle);
		
		System.out.println(driver.getTitle());
		String windowHandle3= driver.getWindowHandle();
		System.out.println(windowHandle3);
		

			
		
		
	}
	
	@After
	public void tearDown() {
		
		driver.close();
		driver.quit();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
