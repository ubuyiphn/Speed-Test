package Helper;

import java.io.IOException;

import javax.mail.MessagingException;

public class HitDetailPage 
{
	static AmazonProductsAtListPage amznprdct = new AmazonProductsAtListPage();
	public static void HitUSDetailPage() throws MessagingException, IOException 
    {
    	int urlcount=1;
	    while(urlcount<=3)
	    {
	        amznprdct.setAmazonUSproductURL();
	        urlcount++;
	    }
	    amznprdct.OpenAmazonUSProductDetailPageURL();  
	}
    
}
