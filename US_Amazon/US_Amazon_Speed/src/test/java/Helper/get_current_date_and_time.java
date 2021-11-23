package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class get_current_date_and_time 
{
	public static String print_Current_Date_And_Time()
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		  LocalDateTime now = LocalDateTime.now();  
		  return dtf.format(now);
	}
}
