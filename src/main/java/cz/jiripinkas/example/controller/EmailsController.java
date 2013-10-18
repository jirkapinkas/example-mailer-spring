package cz.jiripinkas.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.jiripinkas.example.entity.EmailBatch;
import cz.jiripinkas.example.service.EmailBatchService;

@Controller
public class EmailsController {

	@Autowired
	private EmailBatchService emailBatchService;

	@RequestMapping("/list-emails")
	public String listEmails(Model model) {
		List<EmailBatch> list = emailBatchService.findAll();
		model.addAttribute("emails", list);
		return "emails";
	}

	@RequestMapping("/emails/remove/{id}")
	public String remove(@PathVariable int id) {
		emailBatchService.delete(id);
		return "redirect:/list-emails.html";
	}

	@RequestMapping("/emails/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		EmailBatch emailBatch = emailBatchService.findOne(id);
		model.addAttribute("emailBatch", emailBatch);
		return "email-detail";
	}

}
