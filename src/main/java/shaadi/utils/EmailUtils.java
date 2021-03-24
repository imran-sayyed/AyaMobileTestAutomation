package shaadi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ITestContext;

import android.shaadi.BaseTest;

public class EmailUtils {

	private static List<String> fileList = new ArrayList<String>();

	public static void sendEmail(String reportName, ITestContext context)
			throws AddressException, MessagingException, IOException {

		checkDirectoryExist(BaseTest.baseDir);

		if (BaseTest.Pod.equalsIgnoreCase("matchmaking")) {
			checkDirectoryExist(BaseTest.baseDir + "A2");
		} else if (BaseTest.Pod.equalsIgnoreCase("Acquisition")) {
			checkDirectoryExist(BaseTest.baseDir + "A1");

		}

		zipIt(BaseTest.baseDir + reportName + ".zip", "./Report/" + reportName + "/");

		String filepath = "";
		String to;
		// List<String> mails = EmailRecepients.getMailIds();
		List<String> mails = ExcelDataUtils.getEmailList();

		InternetAddress[] address = new InternetAddress[mails.size()];
		for (int i = 0; i < mails.size(); i++) {
			address[i] = new InternetAddress(mails.get(i));
		}

		if (BaseTest.Url.equals("http://0.0.0.0:4723/wd/hub") || BaseTest.Url.equals("http://10.10.2.228:4724/wd/hub")
				|| BaseTest.Url.equals("http://10.10.2.228:4725/wd/hub")) {
			to = "sayyedimran.mohd@gmail.com";
		} else {
			to = BaseTest.AutomationReportMailUser;
		}
		String from = "senderemail_will come here";
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("emailfield", "P@ssWorDfield");
			}
		});
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(from));
			// msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setRecipients(Message.RecipientType.TO, address);

			msg.setSubject("Automation Report - " + context.getCurrentXmlTest().getSuite().getName());
			Multipart multipart = new MimeMultipart();
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setHeader("Content-Type", "text/html; charset=utf-8");
			textBodyPart.setText("Please find attachment of automated test report.");
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			File path_to_report = new File(BaseTest.baseDir + reportName + ".zip");
			filepath = path_to_report.getAbsolutePath();
			DataSource source = new FileDataSource(filepath);
			attachmentBodyPart.setDataHandler(new DataHandler(source));
			attachmentBodyPart.setFileName(path_to_report.getName());
			multipart.addBodyPart(textBodyPart);
			multipart.addBodyPart(attachmentBodyPart);
			msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			System.out.println("Exception Occured " + mex.getMessage());
		}
	}

	public static void zipIt(String zipFile, String SOURCE_FOLDER) {

		generateFileList(new File(SOURCE_FOLDER), SOURCE_FOLDER);
		byte[] buffer = new byte[1024];
		String source = new File(SOURCE_FOLDER).getName();
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);

			System.out.println("Output to Zip : " + zipFile);
			FileInputStream in = null;

			for (String file : fileList) {
				System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					if (in != null) {
						in.close();
					}
				}
			}

			zos.closeEntry();
			System.out.println("Folder successfully compressed");

		} catch (IOException ex) {
			System.out.println("Exception Occured " + ex.getMessage());
		} finally {
			try {
				if (zos != null) {
					zos.close();
				}

				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				System.out.println("Exception Occured " + e.getMessage());
			}
		}
	}

	public static void generateFileList(File node, String SOURCE_FOLDER) {
		// add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.toString(), SOURCE_FOLDER));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename), SOURCE_FOLDER);
			}
		}
	}

	private static String generateZipEntry(String file, String SOURCE_FOLDER) {
		return file.substring(SOURCE_FOLDER.length(), file.length());
	}

	public static void checkDirectoryExist(String filePath) {
		File file = new File(filePath);

		if (!file.exists()) {
			file.mkdir();
		}
	}

}
