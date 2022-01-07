package Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import TestSpeed.test_detail_speed;

public class Pagination 
{
	List<WebElement> pagination_li = new ArrayList<>();
	
	public int get_pagination_count()
    {
		
		if(Helper.wait.Is_Pagination_Available())
    	{
    		pagination_li = Browsers.driver.findElements(By.xpath("//div[@class=\"store-filter clearfix w-100\"]/nav/ul/li"));
    		
    		int pagination_total_count = pagination_li.size();
    		
    		return pagination_total_count-1;
    	}
    	return 1;
    	
    }
    
    public int get_pagination_random_number()
    {
    	
    	if(test_detail_speed.pagination_count != 1)
    	{
    		int min = 2; 
    		
    		int max = test_detail_speed.pagination_count;
    		
    		int rndm;
    		
    		rndm = (int) (Math.random() * (max - min + 1)) + min;
    		
    		System.out.println(rndm);
    		
    		return rndm;
    		
    	}
    	return 1;
    }
    
    public void hit_pagination_url() throws MessagingException, IOException
    {
    	System.out.println("Pagination random count going to hit is "+test_detail_speed.pagination_random_count);
    
    	String pagination_url = test_detail_speed.list_page_url.concat("&page="+test_detail_speed.pagination_random_count);
    		
    	System.out.println("Pagination url is "+pagination_url);
    		
    	Browsers.driver.get(pagination_url);
    		
    	Helper.wait.waitforlistpage();
    	
    }
    
}















