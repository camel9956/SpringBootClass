<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>
</head>
<body>
	<jsp:include page="../layout/navbar.jsp"></jsp:include>

	<div class="container">
		<h1>修改留言頁面</h1>
		<div class="card">
			<h5 class="card-header">修改訊息</h5>
			<div class="card-body">
				<!-- 				   東西送到哪裡     送出的方法         接到的東西      -->
				<form:form action="${contextRoot}/message/posteditMessage"
					method="post" modelAttribute="editMessage">
					<div class="input-group">
						<form:input type="hidden" path="id" />
						<form:input type="hidden" path="added" />
						<form:textarea path="text" class="form-control" />
					</div>
					<!-- 									須知訊息 -->
					<input type="submit" name="submit" value="確認">
					<input type="button" value="取消">
				</form:form>
			</div>
		</div>

		<br />
	</div>

</body>
</html>