package Helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.SessionId;

public class ImportedPackages 
{
    public static int screenshotcount=1;
    public static File Screenshotfolder = new File(System.getProperty("user.dir")+"/Screenshots/");
    public static String screenshotpath = System.getProperty("user.dir")+"/Screenshots/"+screenshotcount+".png";
    public static long start;
    public static long finish;
    public static int turn = 1;
    public static List<Long> searchspeed = new ArrayList<Long>();
    public static long tempspeed=0;
    public static long avgspeedinms=0;
    public static long avgspeedinseconds=0;
    public static long totaltime;
    public static int keywordposition=5;
    public static WebElement searchfieldwait;
    public static WebElement USProductsAvailability;
    public static Boolean IsUSProductAvailable;
    public static List<WebElement>allamzonproductscountxpath;
    public static int paginationcount;
    public static WebElement paginationcountdiv;
    public static SessionId ssnid;
    public static String searchedkeyword;
    }    
