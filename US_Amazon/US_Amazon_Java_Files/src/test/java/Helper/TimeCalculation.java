package Helper;

public class TimeCalculation 
{
	public static void listpageloadtime()
	{
		ImportedPackages.searchspeed.clear();
		//System.out.println("Start time is "+ImportedPackages.start);
		//System.out.println("End time is "+ImportedPackages.finish);
		ImportedPackages.totaltime = ImportedPackages.finish-ImportedPackages.start;
		//System.out.println("Total time is "+ImportedPackages.totaltime);
		ImportedPackages.searchspeed.add(ImportedPackages.totaltime);
	}
        
}
