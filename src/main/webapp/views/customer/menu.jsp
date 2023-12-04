<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<style>
.pagination {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.pagination li {
	list-style: none;
	margin: 0 5px;
}

.pagination a, .pagination span {
	color: #fff; /* Màu chữ */
	background-color: #dc3545; /* Màu nền đỏ */
	text-decoration: none;
	border-radius: 5px;
}

.pagination a:hover {
	background-color: #c82333;
	color: #fff;
}
</style>
<!-- page-banner-section 
			================================================== -->
<section class="page-banner-section menu">
	<div class="container">
		<p>
			You are here: <a href="index.html">Home</a> / <a href="menu.html">Menu</a>
		</p>
	</div>
</section>
<!-- End page-banner section -->

<!-- small-menu-section 
			================================================== -->
<section class="small-menu-section">
	<div class="container">
		<div class="menu-box">
			<h1 class="menu-title">~ chicken pizzas ~</h1>
			<div class="row">
				<c:forEach items="${list}" var="pro" varStatus="loop">
					<div class="col-lg-4 col-md-6">
						<div class="menu-post">
							<div class="menu-content">
								<div class="image-holder">
									<img
										src="${pageContext.servletContext.contextPath}/resources/images/${pro.image}"
										alt="">
								</div>
								<div class="post-content">
									<h2>
										<a href="#">${pro.name}</a>
									</h2>
									<p>Seasoned chicken, parmesan, maple cured rasher chicken,
										red onion, mushroom on a garlic crème fraiche base, topped
										with fresh sliced spring</p>
								</div>
							</div>
							<div class="menu-price-order">
								<span class="price">$${pro.price}</span>
								<div class="row">
									<form action="cart" method="post"
										class="d-flex justify-content-end align-items-center">
										<input type="hidden" value="${pro.id}" name="id">
										<!-- <a href="detail/${pro.id}" class="details"><i class="fa fa-eye"></i></a> -->
										<button type="submit" class="details btn">
											<i class="fa fa-shopping-bag"></i>
										</button>
									</form>
								</div>

							</div>
						</div>
					</div>
				</c:forEach>

				<c:if test="${count > 9}">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>

							<c:forEach begin="1" end="${totalPage}" var="t">
								<li class="page-item"><a class="page-link"
									href="?pageno=${t}">${t}</a></li>
							</c:forEach>
							
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
		</div>
	</div>
</section>