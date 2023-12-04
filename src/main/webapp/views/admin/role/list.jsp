<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="card card-table">
				<div class="card-body">
					<div class="title-header option-title">
						<a href="role/create"
							class="align-items-center btn btn-theme d-flex"> <i
							data-feather="plus-square"></i>Add New
						</a>
						<h5>All Role</h5>
						<form class="d-inline-flex" action="" method="get">

							<input name="keyword" class="demo-input  form-control w-100"
								placeholder="Search...." />
							<button class="btn" style="color: #008080">
								<i data-feather="search"></i>
							</button>
						</form>
					</div>

					<div class="table-responsive category-table">
						<div>
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
							<table class="table all-package theme-table" id="table_id">
								<thead>
									<tr>
										<th style="color: #ffa53b">Role Id</th>
										<th style="color: #ffa53b">Role Name</th>
										<th style="color: #ffa53b"></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${list}" var="r" varStatus="loop">
										<tr>
											<td><strong>${r.id}</strong></td>
											<td><strong>${r.name}</strong></td>
											<td>
												<ul>
													<li><a href=""> <i class="ri-eye-line"></i>
													</a></li>

													<li><a href="role/edit/${r.id}"> <i
															class="ri-pencil-line"></i>
													</a></li>

													<li><a href="role/delete/${r.id}"> <i
															class="ri-delete-bin-line"></i>
													</a></li>
												</ul>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<c:if test="${count > 5}">
						<div class="mt-5">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:choose>
									<c:when test="${empty param.keyWord}">
										<c:forEach begin="1" end="${totalPage}" var="t">
											<li class="page-item"><a class="page-link"
												href="?pageno=${t}">${t}</a></li>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach begin="1" end="${totalPage}" var="t">
											<li class="page-item"><a class="page-link"
												href="?keyword=${param.keyWord}&pageno=${t}">${t}</a></li>
										</c:forEach>
									</c:otherwise>
								</c:choose>
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>