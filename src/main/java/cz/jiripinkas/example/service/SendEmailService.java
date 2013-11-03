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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.entity.Email;
import cz.jiripinkas.example.entity.EmailBatch;
import cz.jiripinkas.example.repository.EmailRepository;

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

	@Autowired
	private EmailRepository emailRepository;

	private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);

	@Async
	@Transactional
	public void sendEmail(EmailBatch emailBatch, Email email) {
		final String from = emailBatch.getFrom();
		final String subject = emailBatch.getSubject();
		final String body = emailBatch.getBody();
		final String to = email.getTo();
		logger.info("start sending email to: " + to);
		try {
			if ("error".equals(email.getTo())) {
				throw new RuntimeException("simulating error");
			}
			if (preview) {
				logger.info("not sending actual email, preview is true");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				Properties props = System.getProperties();
				props.setProperty("mail.transport.protocol", "smtp");
				props.setProperty("mail.smtp.host", smtp);
				props.setProperty("mail.smtp.port", port + "");
				props.setProperty("mail.smtp.user", username);

				final Session session = Session.getInstance(props, null);
				session.setPasswordAuthentication(new URLName("smtp", smtp, -1, null, username, null), new PasswordAuthentication(username, password));
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
					message.setSubject(subject);
					message.setText(body);

					Transport.send(message);
				} catch (MessagingException ex) {
					throw new RuntimeException("could not send email", ex);
				}
			}
			logger.info("finish sending email to: " + to);
			email.setResult(true);
		} catch (Exception ex) {
			// catch all exceptions
		} finally {
			email.setSent(true);
			emailRepository.save(email);
		}
	}
}
