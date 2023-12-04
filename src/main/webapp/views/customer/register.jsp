<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<style>
.custom-select {
	position: relative;
	font-family: Arial;
	width: 270px;
	border-radius: 0;
	height: 46px;
}

.custom-select select {
	display: none;
}

.select-selected {
	background-color: DodgerBlue;
	line-height: 32.4px;
}

.select-selected.select-arrow-active:after {
	border-color: transparent transparent #04968a transparent;
	top: 7px;
}

.select-items div {
	color: #898989;
	padding: 10px 10px !important;
	border: 1px solid transparent;
	border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
	cursor: pointer;
	user-select: none;
	border-color: #efefef;
	background-color: #f9f9f6;
	font-size: 14px;
}

.select-selected {
	color: #898989;
	cursor: pointer;
	user-select: none;
	border-color: transparent;
	background-color: transparent;
	font-size: 14px;
}

.select-items {
	position: absolute;
	background-color: DodgerBlue;
	top: 100%;
	left: 0;
	right: 0;
	z-index: 99;
}

.select-hide {
	display: none;
}

.select-items div:hover, .same-as-selected {
	background-color: #f2f2f2;
	color: #111;
}

input {
	margin-bottom: 0 !important;
}
</style>
<section class="comming-soon-section">
	<div class="comming-soon-content">
		<div class="container">
			<img src="images/foody.png" alt="">
			<h1>Register</h1>
			<p>Please register to continue</p>
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
							<span id="mipxtes"></span>
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

			<f:form class="subscribe" action="registercus" modelAttribute="user"
				method="post">
				<div class="row">
					<div class="col-md-6" style="margin-bottom: 30px">
						<f:input type="text" id="subscribe" path="userName"
							placeholder="Username" />
						<f:errors cssClass="text-danger" path="userName"></f:errors>

					</div>
					<div class="col-md-6" style="margin-bottom: 30px">
						<f:input type="text" id="subscribe" path="fullName"
							placeholder="Fullname" />
						<f:errors cssClass="text-danger" path="fullName"></f:errors>
					</div>

				</div>

				<div class="row">
					<div class="col-md-6" style="margin-bottom: 30px">
						<f:input type="date" id="subscribe" path="birthday"
							placeholder="Birthday" />
						<f:errors cssClass="text-danger " path="birthday"></f:errors>
					</div>
					<div class="col-md-6 text-center" style="margin-bottom: 30px">
						<div class="custom-select">
							<f:select path="gender">
								<f:option value="">Gender</f:option>
								<f:option value="1">Male</f:option>
								<f:option value="0">Female</f:option>
							</f:select>
						</div>
						<f:errors cssClass="text-danger" path="gender"></f:errors>
					</div>

				</div>
				<div style="padding: 0 15px">
					<div style="margin-bottom: 30px">
						<f:input type="text" id="subscribe" path="address"
							placeholder="Address" class="w-100" />
						<f:errors cssClass="text-danger " path="address"></f:errors>
					</div>
					<div style="margin-bottom: 30px">
						<f:input type="text" id="subscribe" path="telephone"
							placeholder="Telephone" class="w-100" />
						<f:errors cssClass="text-danger " path="telephone"></f:errors>
					</div>
					<div style="margin-bottom: 30px">
						<f:input type="text" id="subscribe" path="email"
							placeholder="Email" class="w-100" />
						<f:errors cssClass="text-danger" path="email"></f:errors>
					</div>
					<div style="margin-bottom: 30px">
						<f:input type="password" id="subscribe" path="password"
							placeholder="Password" class="w-100" />
						<f:errors cssClass="text-danger" path="password"></f:errors>
					</div>

					<f:input type="hidden" id="subscribe" value="1" path="enabled" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>

				<button type="submit">Register</button>
			</f:form>
		</div>
	</div>
</section>
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