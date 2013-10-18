package cz.jiripinkas.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class EmailBatch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_batch_id")
	private Integer emailBatchId;

	@Column(name = "email_from")
	private String from;

	@Size(min = 1, message="Subject must not be empty!")
	@Column(name = "email_subject")
	private String subject;

	@Size(min = 1, message="Body must not be empty!")
	@Column(name = "email_body")
	private String body;

	@OneToMany(mappedBy = "emailBatch", cascade = CascadeType.ALL)
	private List<Email> toEmails;

	public Integer getEmailBatchId() {
		return emailBatchId;
	}

	public void setEmailBatchId(Integer emailBatchId) {
		this.emailBatchId = emailBatchId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Email> getToEmails() {
		return toEmails;
	}

	public void setToEmails(List<Email> toEmails) {
		this.toEmails = toEmails;
	}

}
