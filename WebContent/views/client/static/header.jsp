<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- HEADER MOBILE-->
<header class="header-mobile d-block d-lg-none">
	<div class="header-mobile__bar">
		<div class="container-fluid">
			<div class="header-mobile-inner">
				<a class="logo" href="/HoaLanVN/admin/home"> <img
					src="/HoaLanVN/images/logo2png.png" alt="HoaLanVN" />
				</a>
				<button class="hamburger hamburger--slider" type="button">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
				</button>
			</div>
		</div>
	</div>
	<nav class="navbar-mobile">
		<div class="container-fluid">
			<ul class="navbar-mobile__list list-unstyled">
				<!--  <li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-tachometer-alt"></i>Dashboard
				</a>
					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
						<li><a href="index.html">Dashboard 1</a></li>
						<li><a href="index2.html">Dashboard 2</a></li>
						<li><a href="index3.html">Dashboard 3</a></li>
						<li><a href="index4.html">Dashboard 4</a></li>
					</ul></li>
				<li><a href="chart.html"> <i class="fas fa-chart-bar"></i>Charts
				</a></li>-->
				<li><a href="/HoaLanVN/admin/user"> <i
						class="zmdi zmdi-account-calendar"></i>Cửa hàng
				</a></li>
				<li><a href="/HoaLanVN/admin/user"> <i
						class="zmdi zmdi-account-calendar"></i>Sản phẩm của tôi
				</a></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="far fa-envelope"></i>Đơn hàng của tôi

				</a>
					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
						<li><a href="/HoaLanVN/admin/feedback?status=1">Chưa xử
								lý</a></li>
						<li><a href="/HoaLanVN/admin/feedback?status=2"">Đã xử lý</a></li>
						<li><a href="/HoaLanVN/admin/feedback?status=0"">Đã hủy</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
</header>
<!-- END HEADER MOBILE-->

<!-- MENU SIDEBAR-->
<aside class="menu-sidebar d-none d-lg-block">
	<div class="logo">
		<a href="/HoaLanVN/admin/home"> <img
			src="/HoaLanVN/images/logo2png.png" alt="Hoa Lan VN" />
		</a>
	</div>
	<div class="menu-sidebar__content js-scrollbar1">
		<nav class="navbar-sidebar">
			<ul class="list-unstyled navbar__list">
				<li><a href="/HoaLanVN/traodoi/shop"> <i
						class="zmdi zmdi-account-calendar"></i>Cửa hàng
				</a></li>
				<li><a href="/HoaLanVN/traodoi/shop/gianhang"> <i
						class="zmdi zmdi-account-calendar"></i>Sản phẩm của tôi
				</a></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="far fa-envelope"></i>Đơn hàng của tôi

				</a>
					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
						<li><a
							href="/HoaLanVN/traodoi/shop/gianhang/donhang?status=1">Chưa
								xử lý</a></li>
						<li><a
							href="/HoaLanVN/traodoi/shop/gianhang/donhang?status=2">Đã xử
								lý</a></li>
						<li><a href="/HoaLanVN/traodoi/shop/gianhang/donhang?status=0">Đã hủy</a></li>
					</ul></li>

			</ul>
		</nav>
	</div>
</aside>
<!-- END MENU SIDEBAR-->

<!-- PAGE CONTAINER-->
<div class="page-container">
	<!-- HEADER DESKTOP-->
	<header class="header-desktop">
		<div class="section__content section__content--p30">
			<div class="container-fluid">
				<div class="header-wrap">
					<form class="form-header" action="" method="POST"></form>
					<div class="header-button ">
						<div class="account-wrap">
							<div class="account-item clearfix js-item-menu">
								<div>
									<div class="image">
										<img
											src="${pageContext.request.contextPath }/upload/user/${sessionScope.loginClient.image}"
											alt="${sessionScope.loginClient.fullname}" />
									</div>
									<label> ${sessionScope.loginClient.fullname}</label>
								</div>
								<div class="account-dropdown js-dropdown">
									<div class="info clearfix">
										<!--  <div class="content">
											<h5 class="name">
												<a href="#"></a>
											</h5>
										</div>-->
									</div>
									
									<div class="account-dropdown__footer">
										<a href="/HoaLanVN/logout-client"> <i class="zmdi zmdi-power"></i>Logout
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- HEADER DESKTOP-->