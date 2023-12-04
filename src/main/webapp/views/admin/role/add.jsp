<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<div class="row">
				<div class="col-sm-8 m-auto">
					<div class="card">
						<div class="card-body">
							<div class="card-header-2">
								<h5>Role Add</h5>
							</div>

							<f:form action="create" method="post" modelAttribute="role"
								class="theme-form theme-form-2 mega-form">
								<div class="mb-4 row align-items-center">
									<label class="form-label-title col-sm-3 mb-0">Role
										Name</label>
									<div class="col-sm-9">
										<f:input class="form-control" type="text" path="name"
											placeholder="Role Name"/>
										<f:errors cssClass="text-danger" path="name"/>
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
