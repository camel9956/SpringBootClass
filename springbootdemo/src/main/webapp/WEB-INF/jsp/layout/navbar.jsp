<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${contextRoot}/css/bootstrap.css" rel="stylesheet">


<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Cool App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${contextRoot}/">首頁 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/messages/add">新增留言</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle"
					href="${contextRoot}/messages/page" role="button"
					data-toggle="dropdown" aria-expanded="false">分頁顯示 </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/messages/ajaxMessages">ajaxDemo</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/newPhoto">上傳圖片</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/listPhoto">查看圖片</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<script type="text/javascript"
		src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
	<script type="text/javascript"
		src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
</body>

</html>