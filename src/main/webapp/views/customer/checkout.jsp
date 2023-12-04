<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.custom-select select {
	display: none;
}

.select-selected {
	
}

.custom-select {
	position: relative;
	font-family: Arial;
	border-radius: 0;
}

/*style the arrow inside the select element:*/
.select-selected:after {
	position: absolute;
	content: "";
	top: 20px;
	right: 10px;
	width: 0;
	height: 0;
	border: 6px solid transparent;
	border-color: #fff transparent transparent transparent;
}

/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
	border-color: transparent transparent #fff transparent;
	top: 7px;
}

/*style the items (options), including the selected item:*/
.select-items div {
	color: #111;
	padding: 16px 20px;
	border: 1px solid transparent;
	border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
	cursor: pointer;
	user-select: none;
}

.select-selected {
	color: #111;
	border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
	cursor: pointer;
	user-select: none;
}

/*style items (options):*/
.select-items {
	position: absolute;
	background-color: #f8f8f8;
	top: 100%;
	left: 0;
	right: 0;
	z-index: 99;
}

.select-hide {
	display: none;
}

.select-items div:hover, .same-as-selected {
	background-color: #bbbc;
}
</style>
<!-- shopping-cart-section 
			================================================== -->
<section class="shopping-cart-section">
	<div class="container">
		<f:form class="billing-box" modelAttribute="order" method="post">
			<div class="row">
				<div class="col-lg-5">
					<h2>Billing Details</h2>
					<div class="row">
						<div class="col-lg-6">
							<input type="text" name="username" value="${cus.username}"
								placeholder="User Name" />
						</div>
						<div class="col-lg-6">
							<input type="text" name="fullname" placeholder="Full Name"
								value="${cus.fullName}" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<input type="text" name="address" placeholder="address"
								id="address" value="${cus.address}" />
						</div>
						<div class="col-lg-6">
							<input type="text" name="phone" placeholder="phone*"
								value="${cus.telephone}" />
						</div>
					</div>
					<input type="text" name="email" placeholder="email"
						value="${cus.email}" />
					<div style="margin-bottom: 30px">
						<div class="custom-select "
							style="width: 100%; background: #efefef; height: 50px; line-height: 37px; border: none;">
							<f:select path="shippingMethod">
								<f:option value="">Shipping Method</f:option>
								<f:option value="Home Delivery">Home Delivery</f:option>
								<f:option value="Shipping By Post">Shipping By Post</f:option>
								<f:option value="Express Delivery">Express Delivery</f:option>
							</f:select>
						</div>
						<f:errors cssClass="text-danger" path="shippingMethod" />
					</div>
					<div style="margin-bottom: 30px">
						<div class="custom-select"
							style="width: 100%; background: #efefef; height: 50px; line-height: 37px; border: none;">
							<f:select path="paymentMethod">
								<f:option value="">Payment Method</f:option>
								<f:option value="Cash Payment">Cash Payment</f:option>
								<f:option value="Credit Card Payment">Credit Card Payment</f:option>
								<f:option value="E-Wallet Payment">E-Wallet Payment</f:option>
							</f:select>
						</div>
						<f:errors cssClass="text-danger" path="paymentMethod" />
					</div>
					<div class="optional-box">
						<h2>Ship to a different address?</h2>
						<f:textarea path="orderNote" placeholder="Order notes (optional)"></f:textarea>
					</div>

				</div>
				<div class="col-lg-7">
					<h2>Your Order</h2>
					<div class="inner-total">
						<div class="table-responsive">
							<table class="table text-center">
								<thead>
									<tr>
										<th></th>
										<th>Product</th>
										<th>Quantity</th>
										<th>Price</th>
									</tr>
								</thead>
								<c:set var="totalPrice" value="0" />
								<c:forEach items="${list}" var="c" varStatus="loop">
									<tr>
										<td><img alt=""
											src="${pageContext.servletContext.contextPath}/resources/images/${c.product.image}"
											width="100px"></td>
										<td>${c.product.name}</td>
										<td>${c.quantity}</td>
										<td>${c.total}</td>
									</tr>
									<c:set var="totalPrice" value="${totalPrice + c.total}" />
								</c:forEach>
								<tr>
									<td colspan="3" class="text-left">Total</td>
									<td>$${totalPrice}</td>

								</tr>
							</table>
							<button class="button-one grey" type="submit" style="background: #cc3300; border-radius: 18px;">Place
								Order</button>
						</div>
					</div>
				</div>
			</div>
		</f:form>
	</div>
</section>
<!-- End shopping-cart section -->
<script>
	var x, i, j, l, ll, selElmnt, a, b, c;
	/*look for any elements with the class "custom-select":*/
	x = document.getElementsByClassName("custom-select");
	l = x.length;
	for (i = 0; i < l; i++) {
		selElmnt = x[i].getElementsByTagName("select")[0];
		ll = selElmnt.length;
		/*for each element, create a new DIV that will act as the selected item:*/
		a = document.createElement("DIV");
		a.setAttribute("class", "select-selected");
		a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
		x[i].appendChild(a);
		/*for each element, create a new DIV that will contain the option list:*/
		b = document.createElement("DIV");
		b.setAttribute("class", "select-items select-hide");
		for (j = 1; j < ll; j++) {
			/*for each option in the original select element,
			create a new DIV that will act as an option item:*/
			c = document.createElement("DIV");
			c.innerHTML = selElmnt.options[j].innerHTML;
			c
					.addEventListener(
							"click",
							function(e) {
								/*when an item is clicked, update the original select box,
								and the selected item:*/
								var y, i, k, s, h, sl, yl;
								s = this.parentNode.parentNode
										.getElementsByTagName("select")[0];
								sl = s.length;
								h = this.parentNode.previousSibling;
								for (i = 0; i < sl; i++) {
									if (s.options[i].innerHTML == this.innerHTML) {
										s.selectedIndex = i;
										h.innerHTML = this.innerHTML;
										y = this.parentNode
												.getElementsByClassName("same-as-selected");
										yl = y.length;
										for (k = 0; k < yl; k++) {
											y[k].removeAttribute("class");
										}
										this.setAttribute("class",
												"same-as-selected");
										break;
									}
								}
								h.click();
							});
			b.appendChild(c);
		}
		x[i].appendChild(b);
		a.addEventListener("click", function(e) {
			/*when the select box is clicked, close any other select boxes,
			and open/close the current select box:*/
			e.stopPropagation();
			closeAllSelect(this);
			this.nextSibling.classList.toggle("select-hide");
			this.classList.toggle("select-arrow-active");
		});
	}
	function closeAllSelect(elmnt) {
		/*a function that will close all select boxes in the document,
		except the current select box:*/
		var x, y, i, xl, yl, arrNo = [];
		x = document.getElementsByClassName("select-items");
		y = document.getElementsByClassName("select-selected");
		xl = x.length;
		yl = y.length;
		for (i = 0; i < yl; i++) {
			if (elmnt == y[i]) {
				arrNo.push(i)
			} else {
				y[i].classList.remove("select-arrow-active");
			}
		}
		for (i = 0; i < xl; i++) {
			if (arrNo.indexOf(i)) {
				x[i].classList.add("select-hide");
			}
		}
	}
	/*if the user clicks anywhere outside the select box,
	 then close all select boxes:*/
	document.addEventListener("click", closeAllSelect);
</script>