<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp"%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="Emails" />
	<jsp:param name="page" value="emails" />
</jsp:include>

<h1>Email detail</h1>

<h2>subject: ${emailBatch.subject}</h2>
<h3>from: ${emailBatch.from}</h3>

<strong>body:</strong>
<p>${emailBatch.body}</p>

<h2>sent to these emails:</h2>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>email</th>
			<th>sent</th>
		</tr>
	</thead>
	<tbody>
	
	<script>
	var repeatme = function print() {
		$.getJSON("batch/${emailBatch.emailBatchId}.json", function(data) {
 			$.each(data.toEmails, function(key, value) {
 				var div = $(".email_" + value.emailId);
 				if(value.sent) {
 					$(div).html('<img alt="sent" title="sent" src="<c:url value="/resources/img/email-sent.png" />">');
 				} else {
 					$(div).html('<img alt="sent" title="sent" src="<c:url value="/resources/img/email-sending.png" />">');
 				}
 			});
		});

	};

	$(document).ready(function() {
		repeatme();
		setInterval(repeatme, 1000);
	});
	</script>
	
		<c:forEach items="${emailBatch.toEmails}" var="email">
			<tr>
				<td>${email.to}</td>
				<td>
					<div class="email_${email.emailId}">${email.sent}</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/footer.jsp" />