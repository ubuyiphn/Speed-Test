package Helper;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TestSpeed.test_detail_speed;

public class AmazonProductsAtListPage 
{
	String URLofAmazonDetailPage;
	public static Long detailpagetime;
	public static Set<String> allurls = new HashSet<String>();
	public static String just_hit_url;
	public int getAmazonUSProductCountAtListPage()
    {
    	List<WebElement> allamzonproductscountxpath = Browsers.driver.findElements(By.xpath(Helper.URLandXPATH.amazonproductcountxpath)); 
    	int amazonproductcount = allamzonproductscountxpath.size();
    	return amazonproductcount;
    }
    
	public int GetRandomNumberforAmazonProducts() 
	{
		int min = 1;
		int max = getAmazonUSProductCountAtListPage();;
		int rndm;
		rndm = (int) (Math.random() * (max - min + 1)) + min;
		return rndm;
	}
    
	public void setAmazonUSproductURL()
	{
		int rndm = GetRandomNumberforAmazonProducts();
		String USAmazonProductDiv = "//div[@id='usstore-products']/div["+rndm+"]/div/a";
		WebElement USAmazonProductElement = Browsers.driver.findElement(By.xpath(USAmazonProductDiv));
		String URLofAmazonDetailPage = USAmazonProductElement.getAttribute("href");
		System.out.println("URL of amazon product added is "+URLofAmazonDetailPage);
		allurls.add(URLofAmazonDetailPage);
	}
	
	public void getAmazonUSProductURL()
	{
		for(String url : allurls)
		{
			System.out.println(url);
		}
	}
	
	public void OpenAmazonUSProductDetailPageURL() throws MessagingException, IOException
	{
		for(String url : allurls)
		{
			just_hit_url = url;
			System.out.println("Browser going to hit is "+just_hit_url);
			Browsers.driver.get(just_hit_url);
			Long DetailPageStartTime = System.currentTimeMillis();
			Helper.wait.waitfordetailpage();
			Long DetailPageEndTime = System.currentTimeMillis();
			Long DetailPageLoadTime = DetailPageEndTime - DetailPageStartTime;
			test_detail_speed.speeddatastream.append("\n\tDetail page load time = "+DetailPageLoadTime+" for ("+url+")\n");
		}
		allurls.clear();
	}
}

