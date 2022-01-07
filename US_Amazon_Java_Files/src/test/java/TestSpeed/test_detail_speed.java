package TestSpeed;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.mail.MessagingException;
import Helper.Browsers;
import Helper.GetPage;
import Helper.HitURL;
import Helper.ImportedPackages;
import Helper.Pagination;
import Helper.Screenshot;
import Helper.TimeCalculation;
import Helper.get_current_date_and_time;
import mail.SendMail;
import mail.SetMailBody;
import myexcel.KeywordsInExcel;

public class test_detail_speed
{ 
	public static PrintStream speeddatastream;
	
	public static PrintStream consoleoutputstream;
	
	static Pagination pgn = new Pagination();
	
	public static int pagination_count;
	
	public static int pagination_random_count;
    
	public static String list_page_url;
    
	public static Boolean us_amazon_product_avaiability;
	
	public static void main(String[] args) throws InterruptedException, MessagingException, IOException 
	{
		while (true) 
		{
			try 
			{
				SetMailBody.speeddatafilepath.createNewFile();
				
				System.out.println("Speed data file created.");
				
				SetMailBody.consoleoutputfilepath.createNewFile();
				
				System.out.println("Console output file created.");
				
				ImportedPackages.Screenshotfolder.mkdir();
				
				System.out.println("Screen shot folder created.");
				
				speeddatastream = new PrintStream(new FileOutputStream(SetMailBody.speeddatafilepath));
				
				consoleoutputstream = new PrintStream(new FileOutputStream(SetMailBody.consoleoutputfilepath));
				
				//System.setOut(consoleoutputstream);
				
				//System.setErr(consoleoutputstream);
				
				ImportedPackages.turn=1;
				
				System.out.println("Turn is"+ImportedPackages.turn);
				
				Browsers.launch_chrome();
				
				System.out.println("Browser launched.");
				
				Browsers.maximizewindow();
				
				System.out.println("Browser window maximized.");
				
				speeddatastream.append("Script start date and time is "+get_current_date_and_time.print_Current_Date_And_Time()+"\n");
				
				HitURL.hitsearchkeywordpageURL();
				
				System.out.println("Brand page loaded.");
				
				while (ImportedPackages.turn <= 10) 
				{
					GetPage.GetSearchPageusingexcel();
					
					System.out.println("Keyword searched.");
					
					list_page_url = Browsers.driver.getCurrentUrl();
					
					System.out.println("Current url is "+list_page_url);
					
					pagination_count = pgn.get_pagination_count();
					
					System.out.println("Pagination count is"+pagination_count);
					
					pagination_random_count = pgn.get_pagination_random_number();
					
					System.out.println("Random number for pagination count is "+pagination_random_count);
					
					us_amazon_product_avaiability = Helper.wait.is_us_amazon_products_available();
					
					System.out.println("Is US amazon product available "+us_amazon_product_avaiability);
					
					if(us_amazon_product_avaiability == true) 
					{
						TimeCalculation.listpageloadtime();
					
						speeddatastream.append("\nList page load time for (" +ImportedPackages.searchedkeyword+")"+ImportedPackages.turn + " keyword ="+ ImportedPackages.totaltime + " MilliSeconds\n");
						
						if(ImportedPackages.turn <= 5)
						{
						    Helper.HitDetailPage.HitUSDetailPage();
						
						    if(pagination_random_count!=1)
						    {
						        pgn.hit_pagination_url();
						    
						        us_amazon_product_avaiability = Helper.wait.is_us_amazon_products_available();
						        
						        if(us_amazon_product_avaiability== true) 
						        {
						    	    Helper.HitDetailPage.HitUSDetailPage();
						        }
						    }
						}
					}
					ImportedPackages.turn++;
					
					KeywordsInExcel.rowcount++;
				}
				speeddatastream.append("\nScript end date and time is "+get_current_date_and_time.print_Current_Date_And_Time());
				
				speeddatastream.close();
				
				SendMail.sendmailforspeed();
				
				Browsers.closebrowser();			 
			} 
			catch (Exception e) 
			{
				try 
				{
				    Screenshot.takescreenshot();
				  
				    System.out.println("Error catched in 1st catch method."+e);
				    
				    speeddatastream.close();
				    
				    SendMail.send_unexpected_error_mail();
				}
				catch(Exception e1)
				{
					Screenshot.takescreenshot();
					
					System.out.println("Error catched in 1st catch method."+e1);
					
					SendMail.send_unexpected_error_mail();
				}
				System.out.println(e);
				
				Browsers.closebrowser();
			}
			continue;
		}
	}
}
