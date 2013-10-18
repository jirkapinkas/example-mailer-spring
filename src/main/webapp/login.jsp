<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/jsp/layout/taglib.jsp"%>
<jsp:include page="WEB-INF/jsp/layout/header.jsp">
	<jsp:param name="title" value="Emails" />
	<jsp:param name="page" value="emails" />
</jsp:include>

<c:if test="${not empty param.login_error}">
	<font color="red">Your login attempt was not successful, try
		again.<br /> <br /> Reason: <c:out
			value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
	</font>
</c:if>

<p class="alert alert-info">
	By default this application runs in preview mode, which means that it 
	won't send any actual emails and database will be each day re-initialized.
</p>

<strong>You can use these credentials to login (username / password):</strong>

<ul>
	<li>admin / admin</li>
	<li>user / user</li>
</ul>

<form name="f" action="j_spring_security_check" method="post" class="form-signin">
	<h2>Please sign in</h2>
	<input type="text" name="j_username" placeholder="Username" class="form-control" />
	<input type="password" name="j_password" placeholder="Password" class="form-control" />
	<input type="submit" name="submit" class="btn btn-primary btn-lg" />
</form>

<jsp:include page="WEB-INF/jsp/layout/footer.jsp" />