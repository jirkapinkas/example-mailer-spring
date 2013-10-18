<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp" %>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="Home" />
	<jsp:param name="page" value="index" />
</jsp:include>

<h1>Just a simple mailer</h1>

<form:form commandName="emailBatch" cssClass="form-signin">
	<div class="errorMessage alert alert-danger" style="display: none"></div>
	<c:if test="${param.sent eq true}">
		<div class="alert alert-success">Success! Email sent.</div>
	</c:if>
	<c:if test="${param.error == true}">
		<div class="alert alert-danger">Error! Could not send email!</div>
	</c:if>
	<form:input path="from" cssClass="form-control from" placeholder="From" /><br />
	<textarea rows="5" name="to" class="form-control to" placeholder="To"></textarea><br />
	<form:errors path="subject" /><br />
	<form:input path="subject" cssClass="form-control subject" placeholder="Subject" /><br />
	<form:errors path="body" /><br />
	<form:textarea rows="5" path="body" cssClass="form-control body" placeholder="Email body" /><br />
	<input type="submit" value="Odeslat" class="btn btn-lg btn-primary">
</form:form>

<script type="text/javascript">
// source: http://stackoverflow.com/questions/2855865/jquery-regex-validation-of-e-mail-address
function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
    return pattern.test(emailAddress);
};

$(document).ready(function() {
	$(".form-signin").submit(function() {
		var from = $(".from").val();
		var subject = $(".subject").val();
		var body = $(".body").val();
		var err = $(".errorMessage");
		err.text("");
		var submit = true;
		if(body.length == 0) {
			err.show();
			err.append("Body cannot be empty!<br>");
			$(".body").focus();
			submit = false;
		}
		if(subject.length == 0) {
			err.show();
			err.append("Subject cannot be empty!<br>");
			$(".subject").focus();
			submit = false;
		}
		if(!isValidEmailAddress(from)) {
			err.show();
			err.append("From must be valid email!<br>");
			$(".from").focus();
			submit = false;
		}
		return submit;
	});
});
</script>

<jsp:include page="layout/footer.jsp" />