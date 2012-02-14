package cat.eFactures.deliver;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
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
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.io.IOUtils;

import cat.eFactures.transform.XMLInvoice;

/**
 * Example Class to send eInvoices by email
 * 
 * @author @santicasas
 *
 */
public class EndPointEmail extends EndPoint {
	
	private Session session;
	private Message message;
	private String body;
	
	/**
	 * Constructor using an auth SSL smtp server
	 * 
	 * @param hostname
	 * @param port
	 * @param username
	 * @param password
	 */
    public EndPointEmail(String hostname, int port, final String username, final String password)
    {            
     
		Properties props = new Properties();

		props.put("mail.smtp.host", hostname);
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);
		
    	session = Session.getDefaultInstance(props,
    			new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});

    }
    
    /**
     * Create Message for sending mail
     * 
     * @param from
     * @param to
     * @param subject
     * @param body
     * @throws AddressException
     * @throws MessagingException
     */
    public void createMessage(String from, String to, String subject, String body) throws AddressException, MessagingException
    {
		message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		this.body = body;
    }

	@Override
	public String deliverInvoice(XMLInvoice xmlInvoice) throws Exception {
	      // create and fill the first message part
	      MimeBodyPart mbp1 = new MimeBodyPart();
	      mbp1.setText(body);		
	      InputStream attach = xmlInvoice.getXmlInputStream();
	      MimeBodyPart mbp2 = new MimeBodyPart();
	      mbp2.setDataHandler(new DataHandler(new ByteArrayDataSource(IOUtils.toByteArray(attach), "text/xml")));
	      mbp2.setFileName("Invoice.xml");
	      Multipart mp = new MimeMultipart();
	      mp.addBodyPart(mbp1);
	      mp.addBodyPart(mbp2);	      
	      message.setContent(mp);
	      message.setSentDate(new Date());
	      Transport.send(message);	      

		return "Send";
	}

}
