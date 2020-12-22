<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tronghoang.dao.CategoryDao"%>
<%@ page import="com.tronghoang.dao.impl.CategoryDaoImpl"%>
<%@ page import="com.tronghoang.model.Category"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tronghoang.dao.BannerDao"%>
<%@ page import="com.tronghoang.dao.impl.BannerDaoImpl"%>
<%@ page import="com.tronghoang.model.Banner"%>
<!-- LOADER -->
<div id="preloader">
	<img class="preloader" src="images/loader.gif" alt="">
</div>
<!-- end loader -->
<!-- END LOADER -->

<%
	CategoryDao categoryDao = new CategoryDaoImpl();
List<Category> categoryList = categoryDao.getCategory();
request.setAttribute("categoryList", categoryList);
BannerDao bannerDao = new BannerDaoImpl();
Banner banner = bannerDao.get(1);
request.setAttribute("banner", banner);
%>
<div id="wrapper">
	<div class="collapse top-search" id="collapseExample">
		<div class="card card-block">
			<div class="newsletter-widget text-center">
				<form class="form-inline">
					<input type="text" class="form-control"
						placeholder="What you are looking for?">
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>
			<!-- end newsletter -->
		</div>
	</div>
	<!-- end top-search -->


	<!-- end topbar -->

	<div class="header-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="logo">
						<a href="index.html"><img
							src="/HoaLanVN/style/client/images/logo2.jpg" alt=""></a>
					</div>
					<!-- end logo -->
				</div>
			</div>
			<!-- end row -->
		</div>
		<!-- end header-logo -->
	</div>
	<!-- end header -->

	<header class="header">
		<div class="container">
			<nav class="navbar navbar-inverse navbar-toggleable-md">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#cloapediamenu" aria-controls="cloapediamenu"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse justify-content-md-center"
					id="cloapediamenu">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link color-pink-hover"
							href="/HoaLanVN/home">Trang chủ</a></li>
						<li class="nav-item dropdown has-submenu"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown02"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Sổ
								tay hoa lan</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown02">
								<c:forEach items="${categoryList }" var="category">
									<li><a class="dropdown-item"
										href="/HoaLanVN/tutorial?category_id=${category.id_category }">${category.name }</a></li>
								</c:forEach>
							</ul></li>
						<li class="nav-item"><a class="nav-link color-pink-hover"
							href="/HoaLanVN/news">Tin Tức</a></li>
						<li class="nav-item"><a class="nav-link color-red-hover"
							href="/HoaLanVN/feedback">Phản hồi/Góp ý</a></li>
							<li class="nav-item"><a class="nav-link color-red-hover"
							href="/HoaLanVN/traodoi/shop">Cửa hàng</a></li>
						<li class="nav-item"><a class="nav-link color-aqua-hover"
							href="/HoaLanVN/introduce">Giới thiệu</a></li>
						<!--  <li class="nav-item">
                                <a class="nav-link color-green-hover" href="blog-category-04.html">Travel</a>
                            </li>  
                            <li class="nav-item">
                                <a class="nav-link color-yellow-hover" href="blog-category-05.html"><i class="fa fa-play-circle-o"></i> Vlogs</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link color-grey-hover" href="blog-category-06.html">Health</a>
                            </li> -->
					</ul>
				</div>
			</nav>
		</div>
		<!-- end container -->
	</header>
	<!-- end header -->

	<section class="section first-section">
		<div class="container-fluid">
			<div class="masonry-blog clearfix">
				<div id="carouselExampleInterval" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner" style="width: 100%; height: 300px;">
						<div class="carousel-item active" data-interval="10000">
							<img src="${pageContext.request.contextPath }/upload/banner/${banner.image1 }" class="d-block w-100" alt="..."
								style="width: 100%; height: 300px">
						</div>
						<div class="carousel-item" data-interval="2000">
							<img src="${pageContext.request.contextPath }/upload/banner/${banner.image2 }" class="d-block w-100" alt="..."
								style="width: 100%; height: 300px">
						</div>
						<div class="carousel-item">
							<img src="${pageContext.request.contextPath }/upload/banner/${banner.image3 }" class="d-block w-100" alt="..."
								style="width: 100%; height: 300px">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleInterval"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleInterval"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!-- end masonry -->
		</div>
	</section>