package myexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Helper.Browsers;

public class KeywordsInExcel 
{	
	static File excelfilepath = new File(System.getProperty("user.dir")+"/UbuyExcel.xls");
	public static int rowcount=0;
	public static void fillkeywordtoexcel() throws IOException
    {
		excelfilepath.createNewFile();
		Browsers.launch_chrome();
		Browsers.maximizewindow();
		Browsers.driver.get("https://www.a.ubuy.com.kw/en/html-sitemap/ubuybrands");
		List<String> urlsofkeywordpage = getkeywordpage();
		FileOutputStream fos = new FileOutputStream(excelfilepath);
		Workbook wb = new HSSFWorkbook();
    	wb.createSheet("Keywords");
    	Sheet sheet = wb.getSheet("Keywords");
    	int c = 0;
    	Row row;
    	Cell cell;
    	for(int keywordpagecount=0;keywordpagecount<27;keywordpagecount++)
    	{
    		Browsers.driver.get(urlsofkeywordpage.get(keywordpagecount));
    		List<String> allkeywords = getkeyword();
    		for(String keyword : allkeywords)
    		{
    			row = sheet.createRow(rowcount);
    	   		cell = row.createCell(c);
    			//System.out.println(keyword);
    			cell.setCellValue(keyword);
    			rowcount++;
    		}
    	}
    	wb.write(fos);
    	wb.close();
    	fos.close();
    }
	
	public static List<String> getkeywordpage()
	{
		String xpathofkeywordpageelement = "//div[@class='pagination-inner']/a";
		List<WebElement> allkeywordpageelements = new ArrayList<WebElement>();
		allkeywordpageelements = Browsers.driver.findElements(By.xpath(xpathofkeywordpageelement));
		List<String> urlsofkeywordpage = new ArrayList<String>();
		for(WebElement keywordpageelement : allkeywordpageelements)
		{
			urlsofkeywordpage.add(keywordpageelement.getAttribute("href"));
		}	
		return urlsofkeywordpage;
	}
	
	public static List<String> getkeyword()
	{
		String xpathofkeyword = "//ul[@class='list clearfix']/li/a";
		List<WebElement> elementofkeyword = new ArrayList<WebElement>();
		elementofkeyword = Browsers.driver.findElements(By.xpath(xpathofkeyword));
		List<String> allkeywords = new ArrayList<String>();
		for(WebElement keywords : elementofkeyword)
		{
			allkeywords.add(keywords.getText());
		}
		return allkeywords;
	}
	
	public static int getrandomrowcountfromexcel() throws IOException
	{
		long lastrowcount = getlaswrownumber();
		int firstrowcount = 0;
		int rndmcountforkeyword;
		rndmcountforkeyword = (int) (Math.random() * (lastrowcount - firstrowcount + 1)) + firstrowcount;
	    return rndmcountforkeyword;
	}
	
	public static String getkeywordsfromexcel() throws IOException
	{
		FileInputStream fis = new FileInputStream(excelfilepath);
		Workbook wb = new HSSFWorkbook(fis);
		int rndmcountforkeyword = getrandomrowcountfromexcel();
		String keyword = wb.getSheet("Keywords").getRow(rndmcountforkeyword).getCell(0).toString();
		fis.close();
		wb.close();
		return keyword;
	}
	
	
	public static int getlaswrownumber() throws IOException
	{
		FileInputStream fis = new FileInputStream(excelfilepath);
		Workbook wb = new HSSFWorkbook(fis);
		//System.out.println(wb.getSheet("Keywords").getLastRowNum());
		int lastrowcountinexcel = wb.getSheet("Keywords").getLastRowNum();
		fis.close();
		wb.close();
		return lastrowcountinexcel;
	}
	
}
