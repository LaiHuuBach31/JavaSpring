<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<div class="row">
				<div class="col-sm-8 m-auto">
					<div class="card">
						<div class="card-body">
							<div class="card-header-2">
								<h5>Category Edit</h5>
							</div>

							<f:form action="${pageContext.servletContext.contextPath}/admin/category/edit/${category.id}" method="post" modelAttribute="category" enctype="multipart/form-data"
								class="theme-form theme-form-2 mega-form">
								<f:input path="id" readonly="true" type="hidden"/>
								<div class="mb-4 row align-items-center">
									<label class="form-label-title col-sm-3 mb-0">Category
										Name</label>
									<div class="col-sm-9">
										<f:input class="form-control" type="text" path="name" value=""
											placeholder="Category Name"/>
										<f:errors cssClass="text-danger" path="name"/>
									</div>
								</div>

								<div class="mb-4 row align-items-center">
									<label class="col-sm-3 col-form-label form-label-title">Category
										Image</label>
									<div class="form-group col-sm-9">
										<div class="dropzone-wrapper">
											<div id="image-preview" class="mb-4 row align-items-center">
												<div class="form-group col-sm-9">
													<img id="selected-image" src="${pageContext.servletContext.contextPath}/resources/images/${category.image}" alt="Selected Image"
														style="max-width: 100%; max-height: 150px;">
												</div>
											</div>
											<div class="dropzone-desc">
												<i class="ri-upload-2-line"></i>

											</div>
											<f:input type="file" id="image-input" class="dropzone" path="image"/>
											
										</div>
									</div>

								</div>

								<div class="mb-4 row align-items-center">
									<div class="col-sm-3 form-label-title">Category Status</div>
									<div class="col-sm-9">
										<div class="form-check">
											<f:radiobutton  class="form-check-input" path="status"
												value="1" checked="${category.status ? 'checked': ''}" /> 
												<label class="form-check-label">On</label>
										</div>
										<div class="form-check">
											<f:radiobutton class="form-check-input" path="status"
												value="0"  checked="${category.status ? 'checked': ''}"/> 
												<label class="form-check-label">Off</label>
										</div>
									</div>
								</div>
								<button type="submit" class="btn btn-success">Update</button>

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
</script>