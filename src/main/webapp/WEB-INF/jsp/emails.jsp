<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/taglib.jsp"%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="Emails" />
	<jsp:param name="page" value="emails" />
</jsp:include>

<h1>Sent emails</h1>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>operations</th>
			<th>subject</th>
			<th>from</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${emails}" var="emailBatch">
			<tr>
				<td>
					<a href="emails/remove/${emailBatch.emailBatchId}.html" class="btn btn-danger">delete</a>
				</td>
				<td>
					<a href="emails/detail/${emailBatch.emailBatchId}.html">
						<c:out value="${emailBatch.subject}" />
					</a>
				</td>
				<td><c:out value="${emailBatch.from}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="layout/footer.jsp" />