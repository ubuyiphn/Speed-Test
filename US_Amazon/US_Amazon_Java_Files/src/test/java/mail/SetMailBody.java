package mail;

import java.io.File;
import javax.mail.*;
import javax.mail.internet.*;

public class SetMailBody extends SetPropertiesOfSSLEmail
 {
	public static File consoleoutputfilepath = new File(System.getProperty("user.dir")+"/ConsoleOutput.txt");
	public static File speeddatafilepath = new File(System.getProperty("user.dir")+"/SpeedData.txt");
	public void set_list_error_mail_body() 
	 {
	 try {
		 System.setProperty("mail.smtp.ssl.protocols", "TLSv1.3");
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,cc4,cc5));
            message.setRecipient(Message.RecipientType.CC,new InternetAddress(cc1,cc3));            
            
            message.setSubject("Proxy Error on list page.");

			MimeBodyPart messagebodypart = new MimeBodyPart();
			messagebodypart.setText("Hello Team \nPlease have a look to list page proxy Error.\nThis mail generated when any keyword took more than 20 seconds to load.\n... ");

			MimeBodyPart attachmentpart = new MimeBodyPart();
			attachmentpart.attachFile(new File(Helper.ImportedPackages.screenshotpath));

			MimeBodyPart signaturepart = new MimeBodyPart();
			signaturepart.setText(".....\n\n\n\n\n Thank You & Regards\n Himanshu Khandelwal\n Quality Analyst\n Ubuy ");
			
			MimeBodyPart consoleoutput = new MimeBodyPart();
			consoleoutput.attachFile(consoleoutputfilepath);
			
			MimeBodyPart speed_data = new MimeBodyPart();
			speed_data.attachFile(speeddatafilepath);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messagebodypart);
			multipart.addBodyPart(attachmentpart);
			multipart.addBodyPart(signaturepart);
			multipart.addBodyPart(consoleoutput);
			multipart.addBodyPart(speed_data);
			
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	}
	
	public void set_detail_error_mail_body() 
	 {
	 try {
		 System.setProperty("mail.smtp.ssl.protocols", "TLSv1.3");
           message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,cc4,cc5));
           message.setRecipient(Message.RecipientType.CC,new InternetAddress(cc1,cc3));            
           
           message.setSubject("Proxy error on detail page.");

			MimeBodyPart messagebodypart = new MimeBodyPart();
			messagebodypart.setText("Hello Team \nPlease have a look to list page proxy Error.\nThis mail generated when any product took more than 20 seconds to load.\\n... ");

			MimeBodyPart attachmentpart = new MimeBodyPart();
			attachmentpart.attachFile(new File(Helper.ImportedPackages.screenshotpath));

			MimeBodyPart signaturepart = new MimeBodyPart();
			signaturepart.setText(".....\n\n\n\n\n Thank You & Regards\n Himanshu Khandelwal\n Quality Analyst\n Ubuy ");
			
			MimeBodyPart consoleoutput = new MimeBodyPart();
			consoleoutput.attachFile(consoleoutputfilepath);
			
			MimeBodyPart speed_data = new MimeBodyPart();
			speed_data.attachFile(speeddatafilepath);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messagebodypart);
			multipart.addBodyPart(attachmentpart);
			multipart.addBodyPart(signaturepart);
			multipart.addBodyPart(consoleoutput);
			multipart.addBodyPart(speed_data);
			
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	}
	 
	 public void SetMailBodyforlistanddetailpagespeed() 
	 {
	 try {
		 System.setProperty("mail.smtp.ssl.protocols", "TLSv1.3");
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,cc4,cc5));
            message.setRecipient(Message.RecipientType.CC,new InternetAddress(cc1,cc3));
            
            message.setSubject("US Amazon List and Detail Page Speed");

			MimeBodyPart messagebodypart = new MimeBodyPart();
			messagebodypart.setText("Greetings of the day!\n\nList and Detail page time taken for different keywords in milliseconds are given in attachment.");
			//messagebodypart.setText("\n List page average time is "+Helper.ImportedPackages.avgspeedinms +" MilliSeconds");

			MimeBodyPart signaturepart = new MimeBodyPart();
			signaturepart.setText(".....\n\n\n\n Thank You & Regards\n Himanshu Khandelwal\n Quality Analyst\n Ubuy ");
			
			MimeBodyPart consoleoutput = new MimeBodyPart();
			consoleoutput.attachFile(consoleoutputfilepath);
			
			MimeBodyPart speed_data = new MimeBodyPart();
			speed_data.attachFile(speeddatafilepath);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messagebodypart);
			multipart.addBodyPart(signaturepart);
			multipart.addBodyPart(consoleoutput);
			multipart.addBodyPart(speed_data);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	}
	 
	 public void set_unexpected_error_mail_body() 
	 {
	 try {
		 System.setProperty("mail.smtp.ssl.protocols", "TLSv1.3");
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,cc4,cc5));
            message.setRecipient(Message.RecipientType.CC,new InternetAddress(cc1,cc3));
            
            message.setSubject("Unexpected error occurring in script.");

			MimeBodyPart messagebodypart = new MimeBodyPart();
			messagebodypart.setText("Greetings of the day!\nPlease have a look to this unexpected error.\n...");
			//messagebodypart.setText("\n List page average time is "+Helper.ImportedPackages.avgspeedinms +" MilliSeconds");

			MimeBodyPart signaturepart = new MimeBodyPart();
			signaturepart.setText(".....\n\n\n\n Thank You & Regards\n Himanshu Khandelwal\n Quality Analyst\n Ubuy ");
			
			MimeBodyPart consoleoutput = new MimeBodyPart();
			consoleoutput.attachFile(consoleoutputfilepath);
			
			MimeBodyPart speed_data = new MimeBodyPart();
			speed_data.attachFile(speeddatafilepath);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messagebodypart);
			multipart.addBodyPart(signaturepart);
			multipart.addBodyPart(consoleoutput);
			multipart.addBodyPart(speed_data);
			message.setContent(multipart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	}
}