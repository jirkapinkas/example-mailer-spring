package cz.jiripinkas.example.dto;

import java.util.List;

public class EmailBatchDto {

	private List<EmailDto> toEmails;

	public List<EmailDto> getToEmails() {
		return toEmails;
	}

	public void setToEmails(List<EmailDto> toEmails) {
		this.toEmails = toEmails;
	}
	
	
}
