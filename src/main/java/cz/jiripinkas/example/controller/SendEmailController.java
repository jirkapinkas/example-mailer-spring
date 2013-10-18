package cz.jiripinkas.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.jiripinkas.example.entity.Email;
import cz.jiripinkas.example.entity.EmailBatch;
import cz.jiripinkas.example.service.EmailBatchService;
import cz.jiripinkas.example.service.SendEmailService;

@Controller
public class SendEmailController {

	@Autowired
	private EmailBatchService emailBatchService;
	
	@Autowired
	private SendEmailService sendEmailService;

	@RequestMapping("/send-email")
	public String index() {
		return "send-email";
	}

	@ModelAttribute("emailBatch")
	public EmailBatch create() {
		EmailBatch emailBatch = new EmailBatch();
		emailBatch.setSubject("my subject");
		return emailBatch;
	}

	@RequestMapping(value = "/send-email", method = RequestMethod.POST)
	public String sendEmail(@Valid @ModelAttribute EmailBatch emailBatch,
			BindingResult bindingResult, @RequestParam String to)
			throws MessagingException {
		if (bindingResult.hasErrors()) {
			return index();
		}
		String[] tos = to.split("\n");
		List<Email> emails = new ArrayList<Email>();
		for (String emailTo : tos) {
			Email email = new Email(emailTo);
			emails.add(email);
		}
		emailBatchService.save(emailBatch, emails);

		sendEmailService.sendEmail(null, null, null, null);

		return "redirect:/send-email.html?sent=true";
	}
}
