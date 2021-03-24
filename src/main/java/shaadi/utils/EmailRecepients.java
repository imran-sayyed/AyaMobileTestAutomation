package shaadi.utils;

import java.util.ArrayList;
import java.util.List;

public class EmailRecepients {
	
	public static List<String> mailID = new ArrayList<>();

	
	public static String saad_mail = "";
	
	public static String sagar_mail = "";
	
	public static String rahul_mail = "";
	
	public static String kalpit_mail = "";
	
	public static String yatin_mail = "";
	
	public static String imran_mail = "sayyedimran.mohd@gmail.com";
	
	public static String yogi_mail = "";
	
	public static String panchasheela_mail = "";
	
	public static String purna_mail = "";

	public static String prachi_mail = "";

	
	public static List<String> getMailIds(){
		
		mailID.add(saad_mail);
		
		mailID.add(sagar_mail);
		
		return mailID;

	}
	
	/*
	 * public static String[] getArrayOfMail() {
	 * 
	 * String[] mails = new String[mailID.size()]; for(int i = 0 ; i < mailID.size()
	 * ; i++) {
	 * 
	 * mails[i] = mailID.get(i);
	 * 
	 * }
	 * 
	 * return mails; }
	 */




}
