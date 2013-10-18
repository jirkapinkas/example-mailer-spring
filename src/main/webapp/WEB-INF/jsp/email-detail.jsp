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

<table class="table table-striped table-bordered table-hover">
	<c:forEach items="${emailBatch.toEmails}" var="email">
		<tr>
			<td>${email.to}</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />