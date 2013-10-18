package cz.jiripinkas.example.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

	@Value("${mail.smtp}")
	private String smtp;

	@Value("${mail.username}")
	private String username;

	@Value("${mail.password}")
	private String password;

	@Value("${mail.port}")
	private int port;

	@Value("${preview}")
	private boolean preview;

	@Async
	public void sendEmail(String from, String to, String subject, String body)
			throws MessagingException {
		if (!preview) {
			Properties props = System.getProperties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", smtp);
			props.setProperty("mail.smtp.port", port + "");
			props.setProperty("mail.smtp.user", username);

			final Session session = Session.getInstance(props, null);
			session.setPasswordAuthentication(new URLName("smtp", smtp, -1,
					null, username, null), new PasswordAuthentication(username,
					password));

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);
		}
	}
}
