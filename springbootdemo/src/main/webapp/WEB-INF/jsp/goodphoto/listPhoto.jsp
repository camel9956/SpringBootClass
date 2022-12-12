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
						<title>顯示圖片</title>
					</head>

					<body>
						<jsp:include page="../layout/navbar.jsp"></jsp:include>
						<div class="container">
							<h1>查看所有圖片</h1>
							<table>
								<c:forEach var="onePhoto" items="${listPhoto}" >
									<tr>
										<td>${onePhoto.goodName}</td>
										<td><img width="100px" src="${contextRoot}/downloadImage/${onePhoto.id}"/></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</body>

				</html>