<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="card">
				<div class="card-body">
					<div class="title-header title-header-block package-card">
						<div>
							<h5>Order</h5>
						</div>
						<div class="card-order-section">
							<ul>
								<li>${order.orderDate}</li>
								<li>${item} items</li>
								<li>Total $${totalPrice}</li>
							</ul>
						</div>
					</div>
					<div class="bg-inner cart-section order-details-table">
						<div class="row g-4">
							<div class="col-xl-8">
								<div class="table-responsive table-details">
									<table class="table cart-table table-borderless">
										<thead>
											<tr>
												<th colspan="2">Items</th>
												<th class="text-end" colspan="2"><a
													href="javascript:void(0)" class="theme-color">Edit
														Items</a></th>
											</tr>
										</thead>

										<tbody>
										 <c:set var="totalPrice" value="0" />
										<c:forEach items="${list}" var="od" varStatus="loop">
											<tr class="table-order">
												<td><a href="javascript:void(0)"> <img
														src="${pageContext.servletContext.contextPath}/resources/images/${od.product.image}"
														class="img-fluid blur-up lazyload" alt="">
												</a></td>
												<td>
													<p>Product Name</p>
													<h5>${od.product.name}</h5>
												</td>
												<td>
													<p>Quantity</p>
													<h5>${od.quantity}</h5>
												</td>
												<td>
													<p>Price</p>
													<h5>$ ${od.price}</h5>
												</td>
											</tr>
											 <c:set var="totalPrice" value="${totalPrice + od.price}" />
											</c:forEach>
										</tbody>

										<tfoot>
											<tr class="table-order">
												<td colspan="3">
													<h5>Subtotal :</h5>
												</td>
												<td>
													<h4>$0.00</h4>
												</td>
											</tr>

											<tr class="table-order">
												<td colspan="3">
													<h5>Shipping :</h5>
												</td>
												<td>
													<h4>$0.00</h4>
												</td>
											</tr>

											<tr class="table-order">
												<td colspan="3">
													<h5>Tax(GST) :</h5>
												</td>
												<td>
													<h4>$0.00</h4>
												</td>
											</tr>

											<tr class="table-order">
												<td colspan="3">
													<h4 class="theme-color fw-bold">Total Price :</h4>
												</td>
												<td>
													<h4 class="theme-color fw-bold">$${totalPrice}</h4>
												</td>
											</tr>
										</tfoot>
									</table>
								</div>
							</div>

							<div class="col-xl-4">
								<div class="order-success">
									<div class="row g-4">
										<h4>summery</h4>
										<ul class="order-details">
											<li>Order ID: ${order.orderCode}</li>
											<li>Order Date: ${order.orderDate}</li>
											<li>Order Total: $${totalPrice}</li>
										</ul>

										<h4>shipping address</h4>
										<ul class="order-details">
											<li>${order.shippingMethod}</li>
										</ul>

										<div class="payment-mode">
											<h4>payment method</h4>
											<p>${order.paymentMethod}</p>
										</div>

										<div class="delivery-sec">
											<h3>
												expected date of delivery: <span></span>
											</h3>
											<a href="order-tracking.html">track order</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- section end -->
				</div>
			</div>
		</div>
	</div>
</div>