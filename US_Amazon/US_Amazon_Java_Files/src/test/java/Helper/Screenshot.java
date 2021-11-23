package Helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot 
{
    public static void takescreenshot() throws IOException
    {
    	TakesScreenshot scrnshot = ((TakesScreenshot)Browsers.driver);
    	File SrcFile = scrnshot.getScreenshotAs(OutputType.FILE);
    	File DestFile = new File(ImportedPackages.screenshotpath);
    	FileUtils.copyFile(SrcFile, DestFile);
    	ImportedPackages.screenshotcount++;
    }
   
}


