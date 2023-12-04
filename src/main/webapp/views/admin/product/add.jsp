<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<script src="${pageContext.servletContext.contextPath}/resources/ckeditor/ckeditor.js"></script>
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<div class="row">
				<div class="col-sm-8 m-auto">
					<div class="card">
						<div class="card-body">
							<div class="card-header-2">
								<h5>Product Add</h5>
							</div>

							<f:form action="create" method="post" modelAttribute="product"
								enctype="multipart/form-data"
								class="theme-form theme-form-2 mega-form">
								<div class="mb-4 row align-items-center">
									<label class="form-label-title col-sm-3 mb-0">Product
										Name</label>
									<div class="col-sm-9">
										<f:input class="form-control" type="text" path="name"
											placeholder="Product Name" />
										<f:errors cssClass="text-danger" path="name" />
									</div>
								</div>
								<div class="mb-4 row align-items-center">
									<label class="col-sm-3 col-form-label form-label-title">Category</label>
									<div class="col-sm-9">
										<div class="custom-select">
											<f:select class="js-example-basic-single w-100"
												path="category.id">
												<f:options items="${listCategory}" itemLabel="name"
													itemValue="id" />
											</f:select>
										</div>
									</div>
								</div>

								<div class="mb-4 row align-items-center">
									<label class="form-label-title col-sm-3 mb-0">Product
										Price</label>
									<div class="col-sm-9">
										<f:input class="form-control" type="text" path="price"
											placeholder="Product Price" />
										<f:errors cssClass="text-danger" path="price" />
									</div>
								</div>

								<div class="mb-4 row align-items-center">
									<label class="col-sm-3 col-form-label form-label-title">Product
										Image</label>
									<div class="form-group col-sm-9">
										<div class="dropzone-wrapper">
											<div id="image-preview" class="mb-4 row align-items-center">
												<div class="form-group col-sm-9">
													<img id="selected-image" src="#" alt="Selected Image"
														style="max-width: 100%; max-height: 150px; display: none;">
												</div>
											</div>
											<div class="dropzone-desc">
												<i class="ri-upload-2-line"></i>

											</div>
											<f:input type="file" id="image-input" class="dropzone"
												path="image" />

										</div>
										<f:errors cssClass="text-danger" path="image" />
									</div>

								</div>

								<div class="mb-4 row align-items-center">
									<div class="col-sm-3 form-label-title">Product Status</div>
									<div class="col-sm-9">
										<div class="form-check">
											<f:radiobutton class="form-check-input" path="status"
												value="1" checked="checked" />
											<label class="form-check-label"> On </label>
										</div>
										<div class="form-check">
											<f:radiobutton class="form-check-input" path="status"
												value="0" />
											<label class="form-check-label"> Off </label>
										</div>
									</div>
								</div>

							
								<div class="mb-4 row align-items-center">
									<div class="col-sm-3 form-label-title">Description</div>
									<div class="col-sm-9">
										<f:textarea path="description" />
									</div>
								</div>
								<button type="submit" class="btn btn-success">Create</button>

							</f:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	document.getElementById('image-input').addEventListener('change',
			function(event) {
				var imageInput = event.target;
				var imagePreview = document.getElementById('selected-image');

				if (imageInput.files.length > 0) {
					var file = imageInput.files[0];

					var imageUrl = URL.createObjectURL(file);
					imagePreview.src = imageUrl;
					imagePreview.style.display = 'block';
				} else {
					imagePreview.src = '#';
					imagePreview.style.display = 'none';
				}
			});
	var x, i, j, l, ll, selElmnt, a, b, c;

	x = document.getElementsByClassName("custom-select");
	l = x.length;
	for (i = 0; i < l; i++) {
		selElmnt = x[i].getElementsByTagName("select")[0];
		ll = selElmnt.length;

		a = document.createElement("DIV");
		a.setAttribute("class", "select-selected");
		a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
		x[i].appendChild(a);

		b = document.createElement("DIV");
		b.setAttribute("class", "select-items select-hide");
		for (j = 1; j < ll; j++) {

			c = document.createElement("DIV");
			c.innerHTML = selElmnt.options[j].innerHTML;
			c
					.addEventListener(
							"click",
							function(e) {

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

			e.stopPropagation();
			closeAllSelect(this);
			this.nextSibling.classList.toggle("select-hide");
			this.classList.toggle("select-arrow-active");
		});
	}
	function closeAllSelect(elmnt) {

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
	document.addEventListener("click", closeAllSelect);
</script>
<script>
CKEDITOR.replace('description')
</script>
