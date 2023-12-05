
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section class="page-banner-section delivery">
	<div class="container">
		<p>
			You are here: <a href="index.html">Home</a> / <a
				href="shopping-cart.html">Shopping Cart</a>
		</p>
	</div>
</section>
<!-- End page-banner section -->

<!-- shopping-cart-section 
			================================================== -->
<section class="shopping-cart-section">
	<div class="container">
		<div class="checking-form">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th colspan="3">Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
						</tr>
					</thead>
					<c:set var="totalPrice" value="0" />
					<c:forEach items="${list}" var="c" varStatus="loop">
						<tr class="cart-item" data-cart-id="${c.id}">
							<td><a href="delete/${c.id}" style="color: red"><i
									class="fa fa-trash-o"></i></a></td>
							<td><img
								src="${pageContext.servletContext.contextPath}/resources/images/${c.product.image}"
								alt=""></td>
							<td>
								<h2>
									<a href="#">${c.product.name }</a>
								</h2>
							</td>
							<td>$<span class="price stat-price">${c.product.price}</span></td>
							<td>
								
								<div class="form-quantity">
									<button class="minus">-</button>
									<input type="text" class="quantity-cart"
										value="${c.quantity}" />
									<button class="plus">+</button>
								</div>
								
							</td>
							<td>$<span class="price tot-price">${c.total}</span></td>
						</tr>
						<c:set var="totalPrice" value="${totalPrice + c.total}" />
					</c:forEach>
				</table>
			</div>
			<div class="checkout-buttons">
				<div class="left-buttons">
					<input type="text" name="coupon-code"
						placeholder="enter coupon code" /> <a href="#"
						class="button-one grey">Apply Coupon</a>
				</div>
				<div class="right-buttons">
					<a href="menu" class="button-one grey">Update Cart</a> <a
						href="checkout" class="button-one grey">Proceed to Checkout</a>
				</div>
			</div>
			<div class="total-box">
				<div class="row">
					<div class="col-md-6 col-lg-4">
						<h2>Calculate Shipping</h2>
						<input type="text" name="country" placeholder="country" /> <input
							type="text" name="city" placeholder="city" /> <input type="text"
							name="postcode" placeholder="postcode / zip" /> <a href="#"
							class="button-one grey">Update Totals</a>
					</div>
					<div class="col-md-6 col-lg-4 offset-lg-4">
						<div class="inner-total">
							<h2>Cart Total</h2>
							<div class="table-responsive">
								<table class="table">
									<tr>
										<td>Cart Subtotal</td>
										<td><span class="total-price">$${totalPrice}</span></td>
									</tr>
									<tr>
										<td>Shipping and Handling</td>
										<td><span class="shipping-price">Free Shipping</span></td>
									</tr>
									<tr>
										<td>Order Total</td>
										<td><span class="total-price-withshipping">$${totalPrice}</span></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
$(document).ready(function() {
    $(".form-quantity .plus").on("click", function() {
        var row = $(this).closest(".cart-item");
        var cartId = row.data("cart-id");
        var quantityInput = row.find(".quantity-cart");
        var quantity = parseInt(quantityInput.val()) + 1;
		
        //alert("Hello! I am an alert box!!");
        
        $.ajax({
            type: "POST",
            url: "updateQuantity",
            data: {
            	cartId: cartId,
                quantity: quantity
            },
            success: function(response) {
                quantityInput.val(quantity);
                updateTotalPrice(row);
            },
            error: function(error) {
                console.log("Error updating quantity: " + error);
            }
        });
    });

    function updateTotalPrice(row) {
        var price = parseFloat(row.find(".stat-price").text());
        var quantity = parseInt(row.find(".quantity-cart").val());
        var totalPrice = price * quantity;
        row.find(".tot-price").text(totalPrice.toFixed(2));
    }
});

$(document).ready(function() {
    $(".form-quantity .minus").on("click", function() {
        var row = $(this).closest(".cart-item");
        var cartId = row.data("cart-id");
        var quantityInput = row.find(".quantity-cart");
        var quantity = parseInt(quantityInput.val()) - 1;
		
        //alert("Hello! I am an alert box!!");
        
        $.ajax({
            type: "POST",
            url: "updateQuantity",
            data: {
            	cartId: cartId,
                quantity: quantity
            },
            success: function(response) {
                quantityInput.val(quantity);
                updateTotalPrice(row); 
            },
            error: function(error) {
                console.log("Error updating quantity: " + error);
            }
        });
    });

    function updateTotalPrice(row) {
        var price = parseFloat(row.find(".stat-price").text());
        var quantity = parseInt(row.find(".quantity-cart").val());
        var totalPrice = price * quantity;
        row.find(".tot-price").text(totalPrice.toFixed(2));
    }
});

</script>
