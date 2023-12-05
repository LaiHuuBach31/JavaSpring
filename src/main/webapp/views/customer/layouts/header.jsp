
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	right: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	background-color: #fefefe;
	margin: 15% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 30%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

button {
	background-color: #ff9999;
	color: white;
	padding: 10px 15px;
	margin: 5px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.yesno {
	display: block;
	width: 100%;
	margin-top: 5px;
}

.yesno:hover {
	background-color: #ffcccc;
}
</style>
<div id="container">
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href=""><img src="images/logo.png" alt=""></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav m-auto">
					<li class="nav-item"><a class="nav-link "
						href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="menu">Menu</a></li>
					<li class="nav-item"><a class="nav-link" href="about">About</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="delivery">Delivery</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="blog">Blog</a></li>
					<li class="nav-item"><a class="nav-link" href="location">Locations</a>
					</li>
				</ul>
				
				<a href="${pageContext.servletContext.contextPath}/cart"
					class="shopping-cart"><i class="fa fa-shopping-bag">
					</i>
					<c:choose>
					<c:when test="${countCart > 0}">
							<span>${countCart}</span>
					</c:when>
					<c:otherwise>
						<span>0</span>
					</c:otherwise>
				</c:choose>
					</a>

				<c:choose>
					<c:when test="${not empty name}">
						<img
							src="https://cdn.alongwalk.info/vn/wp-content/uploads/2022/03/13034625/image-danh-sach-nhung-buc-anh-viet-nam-lot-top-anh-dep-the-gioi-164709278437272.jpg"
							class="shopping-cart mr-3"
							style="width: 45px; height: 45px; border-radius: 50%; cursor: pointer;"
							id="logoutLink">
						<div id="logoutModal" class="modal">
							<div class="modal-content">
								<span class="close">&times;</span>
								<p>Do you want to logout?</p>
								<form action="<c:url value="/j_spring_security_logout"/>"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<button type="submit" id="confirmLogout" class="yesno">Yes</button>
								</form>
								<button id="cancelLogout" class="yesno">No</button>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<a href="logincus" class="shopping-cart"><i class="fa fa-user"></i></a>
					</c:otherwise>
				</c:choose>

			</div>

		</nav>
	</header>
</div>
<script>
	document.getElementById('logoutLink').addEventListener('click', function() {
		document.getElementById('logoutModal').style.display = 'block';
	});

	document.getElementById('cancelLogout').addEventListener('click',
			function() {
				document.getElementById('logoutModal').style.display = 'none';
			});

	document.getElementById('confirmLogout').addEventListener('click',
			function() {
				window.location.href = '/logout';
			});

	window.onclick = function(event) {
		var modal = document.getElementById('logoutModal');
		if (event.target == modal) {
			modal.style.display = 'none';
		}
	};

	document.getElementsByClassName('close')[0].addEventListener('click',
			function() {
				document.getElementById('logoutModal').style.display = 'none';
			});
</script>