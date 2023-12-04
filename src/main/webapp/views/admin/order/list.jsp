<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="card card-table">
				<div class="card-body">
					<div class="title-header option-title">
						<form class="d-inline-flex" action="" method="get">

							<input name="keyword" class="demo-input  form-control w-100"
								placeholder="Search...." />
							<button class="btn" style="color: #008080">
								<i data-feather="search"></i>
							</button>
						</form>
						<h5>Order List</h5>
						<a href="#" class="btn btn-solid">Download all orders</a>
					</div>
					<div>
						<div class="table-responsive">
						<c:if test="${!empty success}">
								<div class="alert alert-primary" style="background: green" role="alert">
									<strong>${success}</strong>
								</div>
							</c:if>
							<c:if test="${!empty faild}">
								<div class="alert alert-dangery" style="background: red" role="alert">
									<strong>${faild}</strong>
								</div>
							</c:if>
							<table class="table all-package order-table theme-table"
								id="table_id">
								<thead>
									<tr>
										<!-- <th>Order Image</th> -->
										<th>Order Code</th>
										<th>Date</th>
										<th>Payment Method</th>
										<th>Delivery Method</th>
										<th>Amount</th>
										<th>Status</th>
										<th>Option</th>
									</tr>
								</thead>

								<tbody>
								
									<c:forEach items="${list}" var="o" varStatus="loop">
										<tr data-bs-toggle="offcanvas" >
											<%-- <td><a class="d-block"> <span class="order-image">
													<img src="${pageContext.servletContext.contextPath}/resources/images/${o.orderProduct.product.image}" class="img-fluid"
													alt="users">
											</span>
										</a></td> --%>

											<td>${o.orderCode}</td>

											<td>${o.orderDate}</td>

											<td>${o.paymentMethod}</td>

											<td>${o.shippingMethod}</td>

											<td>$15</td>

											<c:choose>
												<c:when test="${o.status}">
													<td class="order-success"><span>Success</span></td>
    											</c:when>
												<c:otherwise>
													<td class="order-pending"><span>Pending</span></td>
    											</c:otherwise>
											</c:choose>

											<td>
												<ul>
													<li><a href="${pageContext.servletContext.contextPath}/admin/order/${o.id}"> <i
															class="ri-eye-line"></i>
													</a></li>

													<li><a href="javascript:void(0)"> <i
															class="ri-pencil-line"></i>
													</a></li>

													<li><a href="order/delete/${o.id}"
														> <i
															class="ri-delete-bin-line"></i>
													</a></li>
													<li><a class="btn btn-sm btn-solid text-white"
														href="order-tracking.html"> Tracking </a></li>
												</ul>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>