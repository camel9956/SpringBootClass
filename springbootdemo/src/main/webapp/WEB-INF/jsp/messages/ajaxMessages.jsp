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
						<title>ajax demo</title>
					</head>

					<body>
						<jsp:include page="../layout/navbar.jsp"></jsp:include>

						<div class="container">
							<h1>ajax+Restful</h1>
							<input type="text" id="my_message">
							<button id="submit_btn">送出</button>

							<div>
								<table class="my_table" id="list_table_json">
									<thead>
										<tr>
											<th>留言內容</th>
											<th>時間</th>
										</tr>
									</thead>
								</table>
							</div>

						</div>

						<script>
							$(document).ready(function () {
								$('#submit_btn').click(function () {
									var inputText = document.getElementById('my_message').value;
									var dtoObj = { "Message": inputText };
									var dtoJson = JSON.stringify(dtoObj);

									$.ajax({
										url: 'http://localhost:8081/my-app/api/postMessages',
										contentType: 'application/json; chartset=UTF-8',//送過去的格式
										method: 'post',
										dataType: 'json',//回傳的資料型別
										data: dtoJson,
										success: function (result) {
											console.log(result);
											$('#list_table_json tbody tr td').remove();
											msg_Data = '<tbody>'
											$.each(result, function (index, value) {
												msg_Data += '<tr>'
												msg_Data += '<td>' + value.text + '</td>'
												msg_Data += '<td>' + value.added + '</td>'
												msg_Data += '</tr>'
											})
											msg_Data += '</tbody>';
											$('#list_table_json').append(msg_Data)
										},
										error: function (err) {
											console.log(err);
										}
									})
								})
							})
						</script>
					</body>

				</html>