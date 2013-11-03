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
		<c:forEach items="${emailBatch.toEmails}" var="email">
			<tr>
				<td>${email.to}</td>
				<td>${email.sent}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/footer.jsp" />