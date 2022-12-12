<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

				<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

				<!DOCTYPE html>
				<html>

					<head>
						<meta charset="UTF-8">
						<title>圖片上傳</title>
					</head>

					<body>

						<jsp:include page="../layout/navbar.jsp"></jsp:include>

						<div class="container">
							<h1>上傳圖片</h1>
							<form action="fileUpload" method="post" enctype="multipart/form-data">
								<!-- name -> requestParam -->
								name:<input type="text" name="photoName">
								<br />
								file: <input type="file" name="file">
								<br />
								<input type="submit" value="送出">
							</form>


						</div>

					</body>

				</html>