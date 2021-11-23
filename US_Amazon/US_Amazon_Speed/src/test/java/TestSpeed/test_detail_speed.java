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
				SetMailBody.consoleoutputfilepath.createNewFile();
				ImportedPackages.Screenshotfolder.mkdir();
				speeddatastream = new PrintStream(new FileOutputStream(SetMailBody.speeddatafilepath));
				consoleoutputstream = new PrintStream(new FileOutputStream(SetMailBody.consoleoutputfilepath));
				System.setOut(consoleoutputstream);
				System.setErr(consoleoutputstream);
				ImportedPackages.turn=1;
				Browsers.launch_headless_chrome();
				Browsers.maximizewindow();
				speeddatastream.append("Script start date and time is "+get_current_date_and_time.print_Current_Date_And_Time()+"\n");
				HitURL.hitsearchkeywordpageURL();
				while (ImportedPackages.turn <= 5) 
				{
					GetPage.GetSearchPageusingexcel();
					list_page_url = Browsers.driver.getCurrentUrl();
					pagination_count = pgn.get_pagination_count();
					pagination_random_count = pgn.get_pagination_random_number();
					us_amazon_product_avaiability = Helper.wait.is_us_amazon_products_available();
					if(us_amazon_product_avaiability) 
					{
						TimeCalculation.listpageloadtime();
						speeddatastream.append("\nList page load time for (" +ImportedPackages.searchedkeyword+")"+ImportedPackages.turn + " keyword ="+ ImportedPackages.totaltime + " MilliSeconds\n");
						KeywordsInExcel.rowcount++;
						Helper.HitDetailPage.HitUSDetailPage();
						pgn.hit_pagination_url();
						us_amazon_product_avaiability = Helper.wait.is_us_amazon_products_available();
						if(us_amazon_product_avaiability) 
						{
							Helper.HitDetailPage.HitUSDetailPage();
						}
						ImportedPackages.turn++;
					}
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
				    System.out.println(e);
				    speeddatastream.close();
				    SendMail.send_unexpected_error_mail();;
				}
				catch(Exception e1)
				{
					Screenshot.takescreenshot();
					System.out.println(e1);
					SendMail.send_unexpected_error_mail();;
				}
				System.out.println(e);
				Browsers.closebrowser();
			}
			break;
		}
	}
}
