package cz.jiripinkas.example.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.jiripinkas.example.dto.EmailBatchDto;
import cz.jiripinkas.example.entity.EmailBatch;

@Service
public class EmailBatchServiceDto {

	@Autowired
	private EmailBatchService emailBatchService;
	
	@Autowired
	private Mapper mapper;
	
	public EmailBatchDto findOne(int id) {
		EmailBatch emailBatch = emailBatchService.findOne(id);
		return mapper.map(emailBatch, EmailBatchDto.class);
	}
}
