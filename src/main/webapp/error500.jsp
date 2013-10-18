<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/jsp/layout/header.jsp">
	<jsp:param name="title" value="Internal Server Error!" />
</jsp:include>

<h1>Internal Server Error!</h1>

<p>Hint: Check email.properties and insert valid mandrillapp
	credentials.</p>

<jsp:include page="WEB-INF/jsp/layout/footer.jsp" />