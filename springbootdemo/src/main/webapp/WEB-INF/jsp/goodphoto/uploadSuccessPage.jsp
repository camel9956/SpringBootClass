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
<title>上傳成功</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>
	<div>
		<h1>上傳成功</h1>

		<a href="${contextRoot}/">回首頁</a>
	</div>
</body>
</html>