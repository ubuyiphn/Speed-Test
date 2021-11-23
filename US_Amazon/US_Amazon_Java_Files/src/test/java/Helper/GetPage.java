package Helper;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import myexcel.KeywordsInExcel;

public class GetPage 
{    	    
	public static void GetSearchPageusingexcel() throws IOException, InterruptedException, MessagingException
    {
		while(true)
	 	{
	   	    if(ImportedPackages.keywordposition<KeywordsInExcel.getlaswrownumber())
	   	    {
	   	        ImportedPackages.start=0;
	   	        ImportedPackages.searchedkeyword = KeywordsInExcel.getkeywordsfromexcel();
                WebElement searchbar = Browsers.driver.findElement(By.xpath(URLandXPATH.searchboxxpathatUbuyBrandPage));
                searchbar.clear();
                searchbar.sendKeys(ImportedPackages.searchedkeyword);
                WebElement searchicon = Browsers.driver.findElement(By.xpath(URLandXPATH.searchiconxpathatUbuyBrandPage));
       	        ImportedPackages.start = System.currentTimeMillis();
       	        searchicon.click();
                wait.waitforlistpage();
                Thread.sleep(1000);
                break;
	   	    }
	   	    else
	   	    {
	   		    ImportedPackages.keywordposition=0;
	   		    continue;
	   	    }
	   	}
	}
}

