package cz.jiripinkas.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id")
	private Integer emailId;

	@Column(name = "email_to")
	private String to;

	private boolean sent;

	private boolean result;

	@ManyToOne
	@JoinColumn(name = "email_batch_id")
	private EmailBatch emailBatch;

	public Email() {

	}

	public Email(String to) {
		this.to = to;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public boolean isSent() {
		return sent;
	}

	public Integer getEmailId() {
		return emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public EmailBatch getEmailBatch() {
		return emailBatch;
	}

	public void setEmailBatch(EmailBatch emailBatch) {
		this.emailBatch = emailBatch;
	}

}
