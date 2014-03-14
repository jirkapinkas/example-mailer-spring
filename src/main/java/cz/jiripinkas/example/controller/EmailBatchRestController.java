package cz.jiripinkas.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jiripinkas.example.dto.EmailBatchDto;
import cz.jiripinkas.example.service.EmailBatchServiceDto;

@Controller
public class EmailBatchRestController {
	
	@Autowired
	private EmailBatchServiceDto emailBatchServiceDto;

	@RequestMapping("/emails/detail/batch/{id}")
	@ResponseBody
	public EmailBatchDto emailBatch(@PathVariable int id) {
		return emailBatchServiceDto.findOne(id);
	}
}
