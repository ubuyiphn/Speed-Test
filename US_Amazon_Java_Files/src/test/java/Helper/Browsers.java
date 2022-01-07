package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void launch_chrome() 
	{
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		wait = new WebDriverWait(Browsers.driver,20);
	}
	
	public static void launch_headless_chrome()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		//WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(Browsers.driver,20);
	}
	
	public static void maximizewindow()
	{
		Browsers.driver.manage().window().maximize();
	}
	
	public static void closebrowser()  
	{
		Browsers.driver.quit();
	}
	
	public static void closetab()
	{
		Browsers.driver.close();
	}
}
