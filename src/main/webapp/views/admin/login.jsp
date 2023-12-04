<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<style>
body {
	background: #e1f5fe;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.login-container {
	width: 400px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	overflow: hidden;
}

.login-header {
	background: #26a69a;
	padding: 20px;
	color: #fff;
	text-align: center;
}

.login-form {
	padding: 20px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	font-weight: 600;
	margin-bottom: 10px;
}

.form-group input {
	width: 100%;
	padding: 10px;
	border: 1px solid #4db6ac;
	border-radius: 4px;
}

.login-btn {
	background: #26a69a;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
}

.login-btn:hover {
	background: #00796b;
}
</style>
</head>
<body>
	<div class="login-container">
		<div class="login-header">
			<h4>
				<i class="fas fa-lock"></i> Admin
			</h4>
		</div>
		<div class="login-form">
			<div class="text-center">
				<strong style="color: red">${error}</strong>
			</div>
			<form action="<c:url value='/admin/j_spring_security_login' />"
				method="post">
				<div class="form-group">
					<label for="username">User Name</label> <input type="text"
						id="username" name="userName" class="form-control">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						id="password" name="password" class="form-control">
				</div>
				<button type="submit" class="login-btn">
					<strong>Login</strong>
				</button>
			</form>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>