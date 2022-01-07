package Helper;

public class HitURL 
{    
    public static void hitsearchkeywordpageURL() throws InterruptedException
    {
    	Browsers.driver.get(URLandXPATH.searchkeywordpageURL);
    	wait.waitforkeywordpage();
    	Thread.sleep(1000);
    }
}
