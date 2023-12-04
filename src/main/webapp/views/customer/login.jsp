<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="comming-soon-section">
	<div class="comming-soon-content">
		<div class="container">
			<img src="${pageContext.servletContext.contextPath}/images/foody.png" alt="">
			<h1>Login</h1>
			<p>Please log in to continue</p>
			
			<div id="clock">
				<div class="row">
					<div class="col-sm-3">
						<div class="comming-part no-border">
							<span id="days"></span>
							<p>Wellcome</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="comming-part">
							<span id="hours"></span>
							<p>To</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="comming-part">
							<span id="minutes"></span>
							<p>My</p>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="comming-part sec-part">
							<span id="seconds"></span>
							<p>Store</p>
						</div>
					</div>
				</div>

			</div>
			
			<form class="subscribe"
				action="<c:url value='j_spring_security_login' />" method='POST'>
				<input type="text" id="subscribe" name="userName"
					placeholder="User Name" /> <input type="password" id="subscribe"
					name="password" placeholder="Password" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button>Login</button>
			</form>
			<a href="registercus">register</a>
		</div>
	</div>
</section>