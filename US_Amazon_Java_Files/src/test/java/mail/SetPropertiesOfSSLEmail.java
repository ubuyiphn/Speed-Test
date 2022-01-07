package mail;

import javax.mail.*;

public class SetPropertiesOfSSLEmail {
	public static String to = "himanshu.khandelwal@ubuy.com";
	public static String from = "ubuyiphn@gmail.com";
	public static String host = "smtp.gmail.com";
	public static final String username = "ubuyiphn@gmail.com";
	public static final String password = "ubuy@123";
	public static Session session;
	public static Transport transport;
	public static Message message;
	public static int port = 465;
	public static String protocol = "smtp";
	public static String cc1 = "ramesh.saini@ubuy.com";
	public static String cc5 = "deepak.soni@ubuy.com";
	public static String cc3 = "akhil@ubuy.co.in";
	public static String cc4 = "shubha.joshi@ubuy.com";
	public static String cc2 = "shailendra.singh@ubuy.com";
}