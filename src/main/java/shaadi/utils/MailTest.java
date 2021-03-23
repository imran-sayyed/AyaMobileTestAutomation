package shaadi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class MailTest {

	public static String OutlookMailReader(String mailFolderName, String emailSubjectContent, String emailContent)
			throws IOException {

		String hostName = "imap.gmail.com";

		String username = "rajeevb@200mails.com";

		String password = "200mails@2019";

		BufferedReader reader = null;

		int messageCount;

		int unreadMsgCount;

		String emailSubject;

		Message emailMessage;

		String searchText = null;

		Properties sysProps = System.getProperties();

		sysProps.setProperty("mail.store.protocol", "imaps");

		try {

			Session session = Session.getInstance(sysProps, null);

			Store store = session.getStore("imaps");

			store.connect(hostName, username, password);

			Folder emailBox = store.getFolder(mailFolderName);

			emailBox.open(Folder.READ_WRITE);

			// messageCount = emailBox.getUnreadMessageCount();
			messageCount = emailBox.getMessageCount();

			System.out.println("Total Message Count: " + messageCount);

			// unreadMsgCount = emailBox.getNewMessageCount();

			unreadMsgCount = emailBox.getUnreadMessageCount();

			System.out.println("Unread Emails count:" + unreadMsgCount);

			for (int i = messageCount; i > (messageCount - unreadMsgCount); i--)

			{

				emailMessage = emailBox.getMessage(i);

				emailSubject = emailMessage.getSubject();

				if (emailSubject.contains(emailSubjectContent))

				{

					System.out.println("Mail found");

					String line;

					StringBuffer buffer = new StringBuffer();

					reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));

					while ((line = reader.readLine()) != null) {

						buffer.append(line);

					}

					String messageContent = emailContent;

					String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));

					searchText = result.replaceAll("[^\\d]", " ");

					searchText = searchText.trim();

					searchText = searchText.replaceAll(" +", " ");

					emailMessage.setFlag(Flags.Flag.SEEN, true);

					break;

				}

				emailMessage.setFlag(Flags.Flag.SEEN, true);

			}

			emailBox.close(true);

			store.close();

		} catch (Exception mex) {

			System.out.println("Exception Occured " + mex.getMessage());
			System.out.println("OTP Not found ");

		}

		finally {
			if (reader != null) {
				reader.close();
			}
		}

		return searchText;

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// ReadGmail g=new ReadGmail();
		OutlookMailReader("Inbox", "This is the first automationnnnnn testing", "Hi Bhushan");

	}

}
