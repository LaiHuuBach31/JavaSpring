<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="com.project.entities.CustomUserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<!-- Google font-->
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap"
	rel="stylesheet">

<!-- Linear Icon css -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/linearicon.css">

<!-- fontawesome css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/font-awesome.css">

<!-- Themify icon css-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/themify.css">

<!-- ratio css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/ratio.css">

<!-- remixicon css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/remixicon.css">

<!-- Feather icon css-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/feather-icon.css">

<!-- Plugins css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/scrollbar.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/animate.css">

<!-- Bootstrap css-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/bootstrap.css">

<!-- vector map css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vector-map.css">

<!-- Slick Slider Css -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/vendors/slick.css">

<!-- App css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/admin/assets/css/style.css">
<style>
.body_pagination {
	font-family: Arial, sans-serif;
	background-color: #f0f8ff;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.pagination {
	display: flex;
	list-style: none;
	margin: 0;
	padding: 0;
	align-items: center;
}

.pagination a, .pagination-item {
	margin: 0 5px;
	padding: 8px 12px;
	background-color: #008080;
	color: #fff;
	border-radius: 4px;
	cursor: pointer;
}

.pagination-item.active {
	background-color: #008080;
}

.custom-select {
	position: relative;
	font-family: Arial;
}

.custom-select select {
	display: none;
}

.select-selected {
	background-color: DodgerBlue;
	border-radius: 3px;
}

.select-selected:after {
	position: absolute;
	content: "";
	top: 14px;
	right: 10px;
	width: 0;
	height: 0;
	border: 6px solid transparent;
	border-color: #04968a transparent transparent transparent;
}

.select-selected.select-arrow-active:after {
	border-color: transparent transparent #04968a transparent;
	top: 7px;
}

.select-items div, .select-selected {
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
	background-color: #0da487;
	color: #fff;
}
</style>
</head>
<body>

	<%!CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();%>
	<!-- tap on top start -->
	<div class="tap-top">
		<span class="lnr lnr-chevron-up"></span>
	</div>
	<!-- tap on tap end -->

	<!-- page-wrapper Start-->
	<div class="page-wrapper compact-wrapper" id="pageWrapper">
		<!-- Page Header Start-->
		<div class="page-header">
			<div class="header-wrapper m-0">
				<div class="header-logo-wrapper p-0">
					<div class="logo-wrapper">
						<a href="index.html"> <img class="img-fluid main-logo"
							src="${pageContext.servletContext.contextPath}/resources/admin/assets/images/logo/1.png"
							alt="logo"> <img class="img-fluid white-logo"
							src="${pageContext.servletContext.contextPath}/resources/admin/assets/images/logo/1-white.png"
							alt="logo">
						</a>
					</div>
					<div class="toggle-sidebar">
						<i class="status_toggle middle sidebar-toggle"
							data-feather="align-center"></i> <a href="index.html"> <img
							src="${pageContext.servletContext.contextPath}/resources/admin/images/logo/1.png"
							class="img-fluid" alt="">
						</a>
					</div>
				</div>

				<form class="form-inline search-full" action="javascript:void(0)"
					method="get">
					<div class="form-group w-100">
						<div class="Typeahead Typeahead--twitterUsers">
							<div class="u-posRelative">
								<input
									class="demo-input Typeahead-input form-control-plaintext w-100"
									type="text" placeholder="Search Fastkart .." name="q" title=""
									autofocus> <i class="close-search" data-feather="x"></i>
								<div class="spinner-border Typeahead-spinner" role="status">
									<span class="sr-only">Loading...</span>
								</div>
							</div>
							<div class="Typeahead-menu"></div>
						</div>
					</div>
				</form>
				<div class="nav-right col-6 pull-right right-header p-0">
					<ul class="nav-menus">
						<li><span class="header-search"> <i
								class="ri-search-line"></i>
						</span></li>
						<li class="onhover-dropdown">
							<div class="notification-box">
								<i class="ri-notification-line"></i> <span
									class="badge rounded-pill badge-theme">4</span>
							</div>
							<ul class="notification-dropdown onhover-show-div">
								<li><i class="ri-notification-line"></i>
									<h6 class="f-18 mb-0">Notitications</h6></li>
								<li>
									<p>
										<i class="fa fa-circle me-2 font-primary"></i>Delivery
										processing <span class="pull-right">10 min.</span>
									</p>
								</li>
								<li>
									<p>
										<i class="fa fa-circle me-2 font-success"></i>Order Complete<span
											class="pull-right">1 hr</span>
									</p>
								</li>
								<li>
									<p>
										<i class="fa fa-circle me-2 font-info"></i>Tickets Generated<span
											class="pull-right">3 hr</span>
									</p>
								</li>
								<li>
									<p>
										<i class="fa fa-circle me-2 font-danger"></i>Delivery Complete<span
											class="pull-right">6 hr</span>
									</p>
								</li>
								<li><a class="btn btn-primary" href="javascript:void(0)">Check
										all notification</a></li>
							</ul>
						</li>

						<li>
							<div class="mode">
								<i class="ri-moon-line"></i>
							</div>
						</li>
						<li class="profile-nav onhover-dropdown pe-0 me-0">
							<div class="media profile-media">
								<img class="user-profile rounded-circle"
									src="https://anbvietnam.vn/wp-content/uploads/2022/05/co_ba_la_co_y_nghia_gi_1-600x400.jpg"
									alt="">
								<div class="user-name-hide media-body">
									<span><% out.print(user.getFullName()); %></span>
									<p class="mb-0 font-roboto">
										Admin<i class="middle ri-arrow-down-s-line"></i>
									</p>
								</div>
							</div>
							<ul class="profile-dropdown onhover-show-div">
								<li><a href="all-users.html"> <i data-feather="users"></i>
										<span>Users</span>
								</a></li>
								<li><a href="order-list.html"> <i
										data-feather="archive"></i> <span>Orders</span>
								</a></li>
								<li><a href="support-ticket.html"> <i
										data-feather="phone"></i> <span>Spports Tickets</span>
								</a></li>
								<li><a href="profile-setting.html"> <i
										data-feather="settings"></i> <span>Settings</span>
								</a></li>
								<li><a data-bs-toggle="modal"
									data-bs-target="#staticBackdrop" href="javascript:void(0)">
										<i data-feather="log-out"></i> <span>Log out</span>
								</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Page Header Ends-->

		<!-- Page Body Start-->
		<div class="page-body-wrapper">
			<!-- Page Sidebar Start-->
			<div class="sidebar-wrapper">
				<div id="sidebarEffect"></div>
				<div>
					<div class="logo-wrapper logo-wrapper-center">
						<a href="index.html" data-bs-original-title="" title=""> <img
							class="img-fluid for-white"
							src="${pageContext.servletContext.contextPath}/resources/admin/assets/images/logo/full-white.png"
							alt="logo">
						</a>
						<div class="back-btn">
							<i class="fa fa-angle-left"></i>
						</div>
						<div class="toggle-sidebar">
							<i class="ri-apps-line status_toggle middle sidebar-toggle"></i>
						</div>
					</div>
					<div class="logo-icon-wrapper">
						<a href="index.html"> <img
							class="${pageContext.servletContext.contextPath}/resources/admin/assets/img-fluid main-logo main-white"
							src="assets/images/logo/logo.png" alt="logo"> <img
							class="img-fluid main-logo main-dark"
							src="${pageContext.servletContext.contextPath}/resources/admin/assets/images/logo/logo-white.png"
							alt="logo">
						</a>
					</div>
					<nav class="sidebar-main">
						<div class="left-arrow" id="left-arrow">
							<i data-feather="arrow-left"></i>
						</div>

						<div id="sidebar-menu">
							<ul class="sidebar-links" id="simple-bar">
								<li class="back-btn"></li>

								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title link-nav" href="${pageContext.servletContext.contextPath}/admin">
										<i class="ri-home-line"></i> <span>Dashboard</span>
								</a></li>

								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-store-3-line"></i>
										<span>Product</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a
											href="${pageContext.servletContext.contextPath}/admin/product">Prodcts</a></li>

										<li><a
											href="${pageContext.servletContext.contextPath}/admin/product/create">Add
												New Products</a></li>
									</ul></li>

								<li class="sidebar-list"><a
									class="linear-icon-link sidebar-link sidebar-title"
									href="javascript:void(0)"> <i class="ri-list-check-2"></i>
										<span>Category</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a
											href="${pageContext.servletContext.contextPath}/admin/category">Category
												List</a></li>

										<li><a
											href="${pageContext.servletContext.contextPath}/admin/category/create">Add
												New Category</a></li>
									</ul></li>

								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title" href="javascript:void(0)">
										<i class="ri-user-3-line"></i> <span>Users</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="${pageContext.servletContext.contextPath}/admin/user">All users</a></li>
										<li><a href="${pageContext.servletContext.contextPath}/admin/user/create">Add new user</a></li>
									</ul></li>

								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title" href="javascript:void(0)">
										<i class="ri-user-3-line"></i> <span>Roles</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="${pageContext.servletContext.contextPath}/admin/role">All roles</a></li>
										<li><a href="${pageContext.servletContext.contextPath}/admin/role/create">Create Role</a></li>
									</ul></li>


								<li class="sidebar-list"><a
									class="sidebar-link sidebar-title" href="javascript:void(0)">
										<i class="ri-archive-line"></i> <span>Orders</span>
								</a>
									<ul class="sidebar-submenu">
										<li><a href="${pageContext.servletContext.contextPath}/admin/order">Order List</a></li>
										<!-- <li><a href="order-tracking.html">Order Tracking</a></li> -->
									</ul></li>
							</ul>
						</div>

						<div class="right-arrow" id="right-arrow">
							<i data-feather="arrow-right"></i>
						</div>
					</nav>
				</div>
			</div>
			<!-- Page Sidebar Ends-->

			<!-- index body start -->
			<div class="page-body">
				<tiles:insertAttribute name="body" />
				<!-- Container-fluid Ends-->

				<!-- footer start-->
				<div class="container-fluid">
					<footer class="footer">
						<div class="row">
							<div class="col-md-12 footer-copyright text-center">
								<p class="mb-0">Copyright 2022 © Fastkart theme by
									pixelstrap</p>
							</div>
						</div>
					</footer>
				</div>
				<!-- footer End-->
			</div>
			<!-- index body end -->

		</div>
		<!-- Page Body End -->
	</div>
	<!-- page-wrapper End-->

	<!-- Modal Start -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog  modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-body">
					<h5 class="modal-title" id="staticBackdropLabel">Logging Out</h5>
					<p>Are you sure you want to log out?</p>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
					<div class="button-box">
						<button type="button" class="btn btn--no" data-bs-dismiss="modal">No</button>
						<form action="<c:url value="/admin/j_spring_security_logout" />"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button type="submit" class="btn  btn--yes btn-primary">Yes</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal End -->

	<!-- latest js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/jquery-3.6.0.min.js"></script>

	<!-- Bootstrap js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/bootstrap/bootstrap.bundle.min.js"></script>

	<!-- feather icon js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/icons/feather-icon/feather.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/icons/feather-icon/feather-icon.js"></script>

	<!-- scrollbar simplebar js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/scrollbar/simplebar.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/scrollbar/custom.js"></script>

	<!-- Sidebar jquery -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/config.js"></script>

	<!-- tooltip init js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/tooltip-init.js"></script>

	<!-- Plugins JS -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/sidebar-menu.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/notify/bootstrap-notify.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/notify/index.js"></script>

	<!-- Apexchar js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/chart/apex-chart/apex-chart1.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/chart/apex-chart/moment.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/chart/apex-chart/apex-chart.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/chart/apex-chart/stock-prices.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/chart/apex-chart/chart-custom1.js"></script>


	<!-- slick slider js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/slick.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/custom-slick.js"></script>

	<!-- customizer js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/customizer.js"></script>

	<!-- ratio js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/ratio.js"></script>

	<!-- sidebar effect -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/sidebareffect.js"></script>

	<!-- Theme js -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/admin/assets/js/script.js"></script>
</body>
</html>