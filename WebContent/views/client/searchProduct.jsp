<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/views/client/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop online</title>
<link rel='stylesheet' type='text/css'
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="${url}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${url}/css/shop.style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="${url}/css/headers/header-v5.css">
<link rel="stylesheet" href="${url}/css/footers/footer-v4.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="${url}/plugins/animate.css">
<link rel="stylesheet" href="${url}/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="${url}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${url}/plugins/scrollbar/css/jquery.mCustomScrollbar.css">
<link rel="stylesheet"
	href="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet"
	href="${url}/plugins/revolution-slider/rs-plugin/css/settings.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${url}/css/theme-colors/default.css"
	id="style_color">

<!-- CSS Customization -->
<link rel="stylesheet" href="${url}/css/custom.css">
<jsp:include page="/views/client/common/linkCSS.jsp"></jsp:include>

</head>
<body class="header-fixed">
	<div class="wrapper">
		<!--=== Header v5 ===-->
		<div class="header-v5 header-static">
			<!-- Topbar v3 -->
			<jsp:include page="/views/client/topbartraodoi.jsp"></jsp:include>
			<!-- End Topbar v3 -->

			<!-- Navbar -->
			<jsp:include page="/views/client/navbartraodoi.jsp"></jsp:include>
			<!-- End Navbar -->
		</div>
		<!--=== End Header v5 ===-->

		<!--=== Slider ===-->
		<!--=== End Slider ===-->

		<!--=== Product Content ===-->

		<div class="container content-md">
			<div class="heading heading-v1 margin-bottom-40">
				<h2>Danh sách sản phẩm</h2>
			</div>
			<div class="row ">

				<div class="col-md-9 col-sm-6 md-margin-bottom-30"></div>
				<div class="col-md-3 col-sm-6 md-margin-bottom-30">
					<form style="padding-bottom: 4rem;"
						class="form-inline d-flex justify-content-center md-form form-sm active-cyan active-cyan-2 mt-2"
						action="/HoaLanVN/traodoi/shop/search">
						<input class="form-control form-control-sm ml-3 w-75" type="text"
							placeholder="Search" aria-label="Search" style="font-size: 15px">
						</i> <input type="text" value="2" name="status" hidden="">
						<button class="au-btn--submit" type="submit">
							<i class="fas fa-search" aria-hidden="true"></i>
						</button>
					</form>
				</div>
			</div>
			<!--=== Illustration v2 ===-->
			<div class="row ">
				<c:forEach items="${productList }" var="product">
					<div col-lg-3 style="padding-right: 6rem; padding-bottom: 6rem">
						<div class="card" style="width: 100%;">
							<img
								src="${pageContext.request.contextPath }/upload/product/${product.image }"
								class="card-img-top" alt="..." style="height: 18rem;">
							<div class="card-body">
								<a href="/HoaLanVN/traodoi/shop/product?id=${product.id }"
									class="card-title">${product.name }</a>
							</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">Giá: ${product.price } VND</li>
								<li class="list-group-item">Người bán
									:${product.user.fullname }</li>
								<li class="list-group-item">Số lượng: ${product.amount }</li>
							</ul>
							<div class="card-body " style="text-align: center;">
								<c:choose>
									<c:when test="${product.amount eq 0 }">
										Hết hàng
									</c:when>
									<c:when test="${product.amount gt 0 }">
										<a href="/HoaLanVN/traodoi/shop/cart?id=${product.id }"
											class="card-link">Mua</a>
									</c:when>
								</c:choose>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="user-data__footer">
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-center">
						<c:choose>
							<c:when test="${page le totalPage }">
								<li class="page-item"><a class="page-link"
									href="${requestScope.request_uri}?key=${key}&status=${status }&page=1">Previous</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${requestScope.request_uri}?key=${key}&status=${status }&page=${page-1 }">Previous</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach items="${pageList}" var="page">
							<li class="page-item "><a class="page-link"
								<c:if test="${param.page eq page}"> style="background-color: #c1c1c1 " </c:if>
								href="${requestScope.request_uri}?key=${key}&status=${status }&page=${page}">${page}</a></li>
						</c:forEach>
						<c:choose>
							<c:when test="${page ge totalPage }">
								<li class="page-item"><a class="page-link"
									href="${requestScope.request_uri}?key=${key}&status=${status }&page=${totalPage}">Next</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${requestScope.request_uri}?key=${key}&status=${status }&page=${page +1 }">Next</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
			</div>
			<!--=== End Illustration v2 ===-->
		</div>
		<!--=== End Product Content ===-->
		<!--=== Footer v4 ===-->

		<!--=== End Footer v4 ===-->
	</div>
	<!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script src="${url}/plugins/jquery/jquery.min.js"></script>
	<script src="${url}/plugins/jquery/jquery-migrate.min.js"></script>
	<script src="${url}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script src="${url}/plugins/back-to-top.js"></script>
	<script src="${url}/plugins/smoothScroll.js"></script>
	<script src="${url}/plugins/jquery.parallax.js"></script>
	<script src="${url}/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script
		src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
	<script
		src="${url}/plugins/revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<!-- JS Customization -->
	<script src="${url}/js/custom.js"></script>
	<!-- JS Page Level -->
	<script src="${url}/js/shop.app.js"></script>
	<script src="${url}/js/plugins/owl-carousel.js"></script>
	<script src="${url}/js/plugins/revolution-slider.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			App.initScrollBar();
			App.initParallaxBg();
			OwlCarousel.initOwlCarousel();
			RevolutionSlider.initRSfullWidth();
		});
	</script>
	<jsp:include page="/views/client/common/footer.jsp"></jsp:include>
	<jsp:include page="/views/client/common/scriptJS.jsp"></jsp:include>

</body>
</body>
</html>