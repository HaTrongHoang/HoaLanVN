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

		<div class="shop-product">
			<!-- Breadcrumbs v5 -->
			<!-- End Breadcrumbs v5 -->

			<div class="container">
				<c:choose>
					<c:when test="${param.mess eq 'amount' }">
						<div
							class="sufee-alert alert with-close alert-success alert-dismissible fade show">
							<span class="badge badge-pill badge-danger">Error</span> Không đủ số lượng
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:when>
					<c:when test="${param.mess eq 'successorder' }">
						<div
							class="sufee-alert alert with-close alert-success alert-dismissible fade show">
							<span class="badge badge-pill badge-success">Success</span> Đặt
							thành công
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:when>
				</c:choose>
				<div class="row">
					<div class="col-md-6 md-margin-bottom-50">
						<div class="ms-showcase2-template">
							<!-- Master Slider -->
							<div class="master-slider ms-skin-default" id="masterslider">
								<div class="ms-slide">
									<img class="ms-brd" style="width: 100%; height: 100%;"
										src="${pageContext.request.contextPath }/upload/product/${product.image }"
										alt="${product.name }">

								</div>


							</div>
							<!-- End Master Slider -->
						</div>
					</div>

					<div class="col-md-6">
						<div class="shop-product-heading">
							<h2>${product.name }</h2>
						</div>
						<!--/end shop product social-->

						<!--/end shop product ratings-->

						<ul class="list-inline shop-product-prices margin-bottom-30">
							<li class="shop-red">${product.price }VND</li>
						</ul>
						<!--/end product size-->

						<!--/end product color-->


						<c:choose>
							<c:when test="${product.amount eq 0 }">
										Hết hàng
									</c:when>
							<c:when test="${product.amount gt 0 }">
								<h3 class="shop-product-title">Số lượng</h3>
								<div class="margin-bottom-40">
									<form name="f1" class="product-quantity sm-margin-bottom-20"
										method="post" action="/HoaLanVN/traodoi/shop/cart">
										<input type="text" value="${product.id }" name="id" hidden="">
										<input type='text' class="quantity-field" name="amount"
											value="1" />
										<button type="submit" class="btn-u btn-u-sea-shop btn-u-lg">Mua</button>
									</form>
								</div>
							</c:when>
						</c:choose>




						<!--/end product quantity-->

						<ul class="list-inline add-to-wishlist add-to-wishlist-brd">
							<li class="wishlist-in"></li>
							<li class="compare-in"></li>
						</ul>
						<p class="wishlist-category">
							<strong>Categories: ${product.category }</strong>
						</p>
					</div>
				</div>
				<div class="content-md container">
					<div class="tab-v5">
						<ul class="nav nav-tabs" role="tablist">
							<li class="active">Mô tả</li>
						</ul>

						<div class="tab-content">
							<!-- Description -->
							<div class="tab-pane fade in active" id="description">
								<div class="row">
									<div class="col-md-7">
										<p>${product.des }</p>
										<br>
									</div>
								</div>
							</div>
						</div>
						<!--/end row-->
					</div>
				</div>
			</div>
		</div>
		<!--/wrapper-->
		<jsp:include page="/views/client/common/footer.jsp"></jsp:include>

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
		<jsp:include page="/views/client/common/scriptJS.jsp"></jsp:include>
</body>
</body>
</html>