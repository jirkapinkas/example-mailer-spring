package cz.jiripinkas.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jiripinkas.example.entity.Email;
import cz.jiripinkas.example.entity.EmailBatch;
import cz.jiripinkas.example.repository.EmailBatchRepository;
import cz.jiripinkas.example.repository.EmailRepository;

@Service
@Transactional
public class EmailBatchService {

	@Autowired
	private EmailBatchRepository emailBatchRepository;

	@Autowired
	private EmailRepository emailRepository;

	public EmailBatch save(EmailBatch emailBatch, List<Email> emails) {
		emailBatch = emailBatchRepository.save(emailBatch);
		for (Email email : emails) {
			email.setEmailBatch(emailBatch);
			email = emailRepository.save(email);
		}
		return emailBatch;
	}

	public List<EmailBatch> findAll() {
		return emailBatchRepository.findAll();
	}

	public EmailBatch findOne(int id) {
		return emailBatchRepository.findOneFetch(id);
	}

	public void delete(int id) {
		emailBatchRepository.delete(id);
	}
}
