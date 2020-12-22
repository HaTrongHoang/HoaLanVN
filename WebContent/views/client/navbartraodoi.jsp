<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/view/client/static" var="url"></c:url>

<div class="navbar navbar-default mega-menu" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-responsive-collapse">
			<!-- Shopping Cart -->
			<jsp:include page="/views/client/carttraodoi.jsp"></jsp:include>
			<!-- End Shopping Cart -->

			<!-- Nav Menu -->
			<ul class="nav navbar-nav">
				<!-- Pages -->
				<li class="dropdown active">
				<li><a href="${pageContext.request.contextPath }/home">Trang
						chủ</a></li>

				</li>
				<!-- End Pages -->
				<!-- Clothes -->
				<li><a href="/HoaLanVN/traodoi/shop">Cửa hàng</a></li>
				<li><a href="/HoaLanVN/traodoi/shop/gianhang">Gian hàng của
						tôi</a></li>
				<!--<li class="dropdown"><a href="javascript:void(0);"
					class="dropdown-toggle" data-hover="dropdown"
					data-toggle="dropdown" data-delay="1000"> Đơn hàng </a>
					<ul class="dropdown-menu">
						<li><a
							href="http://localhost:8080/UNIFY/product/category?cate_id=1">Men</a></li>
						<li><a
							href="http://localhost:8080/UNIFY/product/category?cate_id=2">WOMEN</a></li>
						<li><a
							href="http://localhost:8080/UNIFY/product/category?cate_id=3">CHILDREN</a></li>
					</ul></li>
				 End Clothes -->

				<!-- Main Demo -->
				<li><a
					href="${pageContext.request.contextPath }/traodoi/shop/order">Lịch
						sử mua hàng</a></li>
				<!-- Main Demo -->
			</ul>
			<!-- End Nav Menu -->
		</div>
	</div>
</div>
