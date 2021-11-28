package Helper;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import TestSpeed.test_detail_speed;
import mail.SendMail;

public class wait 
{
	public static String xpath_of_title_at_detail_page = "//h1[@class=\"title h1 mb-2\"]";
	
	public static String xpath_not_found_page = "//div[@class='product-not-found m-auto']";
	
	public static String xpath_sorry_page = "//img[@src='https://www.ubuy.qa/skin/frontend/default/ubuycom/images/not-available/notavailable-inner.jpg.webp?v=1.0']";
	
    public static String Is_Pagination_Available_xpath = "//div[@class='store-filter clearfix w-100']";
    
    public static Boolean availability;
    
    public static Boolean verify_xpath(String x_path)
	{
		try
		{
			availability = Browsers.driver.findElement(By.xpath(x_path)).isDisplayed();
			
			System.out.println(x_path+""+availability);
			
			return availability;
		}
		
		catch(Exception e)
		{
			availability = false;
			
			System.out.println(x_path+""+availability);
			
			return availability;
		}
	}
    
    public static void waitforkeywordpage()
    {
    	Browsers.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(URLandXPATH.searchkeywordxpath)));
    }
    
   
    
    public static void waitforlistpage() throws MessagingException, IOException
    {
    	try {
    	
    		ImportedPackages.finish = 0;
    	
    		ImportedPackages.USProductsAvailability = Browsers.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(URLandXPATH.amazonproductclickxpathatlistpage)));
       	
    		ImportedPackages.IsUSProductAvailable = ImportedPackages.USProductsAvailability.isDisplayed();
    		
    		ImportedPackages.finish = System.currentTimeMillis();
    	}
       	
    	catch(Exception e)
    	{
       		ImportedPackages.start = 0;
       		
       		ImportedPackages.finish = 0;
       		
       		ImportedPackages.IsUSProductAvailable = false;
       		
       		if(verify_xpath("//div[@class='loader-spin-overlay loading']/div") == true || verify_xpath("//div[@class='detail-page-skelton container card-skeleton']") == true)
       		{
       		test_detail_speed.speeddatastream.append("US Store products not searched within 20 seconds for "+ImportedPackages.searchedkeyword+" keyword. So moving to next keyword.");
    	
       		Screenshot.takescreenshot();
       		
       		SendMail.send_search_error_mail();
       		}
       		
    	}
      
    }
    
    public static Boolean is_us_amazon_products_available() throws MessagingException, IOException
    {
        return ImportedPackages.IsUSProductAvailable;
    }
    
   
    
    public static void waitforsearchfield()
    {
    	ImportedPackages.searchfieldwait = Browsers.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(URLandXPATH.searchboxxpathatUbuyBrandPage)));
    }
    
    
   
    
    public static Boolean Is_Pagination_Available()
    {    	
    	try 
    	{
    		WebElement Is_Pagination_Available_Element = Browsers.driver.findElement(By.xpath(Is_Pagination_Available_xpath));
    		
    		return Is_Pagination_Available_Element.isDisplayed();
    	}
    	catch(Exception e)
    	{
    		test_detail_speed.speeddatastream.append("Pagination not available.");
    		
    		return false;
    	}
    }

    
    
    public static void waitfordetailpage() throws MessagingException, IOException
    {    	
    	try
    	{
    	Browsers.wait.until(ExpectedConditions.or
    
    	(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_of_title_at_detail_page)),
    	
    	ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_not_found_page)),
    	
    	ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_sorry_page))));
    	}
    	catch(Exception e)
    	{
    		if(verify_xpath("//div[@class='loader-spin-overlay loading']/div") == true || verify_xpath("//div[@class='detail-page-skelton container card-skeleton']") == true)
    		{
    		test_detail_speed.speeddatastream.append("Detail page taking more than 20 seconds.("+AmazonProductsAtListPage.just_hit_url+")");
    	
    		Screenshot.takescreenshot();
    		
    		SendMail.send_detail_error_mail();
    		}
    	}
    }
   
    
}
