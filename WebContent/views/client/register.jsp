<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:url value="/views/client/static" var="url"></c:url>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico">

<!-- Web Fonts -->
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

<!-- CSS Page Style -->
<link rel="stylesheet" href="${url}/css/pages/log-reg-v3.css">

<!-- Style Switcher -->
<link rel="stylesheet" href="${url}/css/plugins/style-switcher.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${url}/css/theme-colors/default.css"
	id="style_color">

<!-- CSS Customization -->
<link rel="stylesheet" href="${url}/css/custom.css">
<jsp:include page="/views/client/common/linkCSS.jsp"></jsp:include>

</head>
<body>
<body class="header-fixed">
	<div class="wrapper">
		<!--=== Header v5 ===-->
		<div class="header-v5 header-${url}">
			<!-- Topbar v3 -->
			<jsp:include page="topbartraodoi.jsp"></jsp:include>

			<!-- End Topbar v3 -->

			<!-- Navbar -->
			<jsp:include page="navbartraodoi.jsp"></jsp:include>
			<!-- End Navbar -->
		</div>
		<!--=== End Header v5 ===-->


		<!--=== Login ===-->
		<div class="log-reg-v3 content-md">
			<div class="container content-md">	
				<div class="row">

					<div class="col-md-3"></div>
					<div class="col-md-6">
						<c:choose>
							<c:when test="${param.mess eq 'username' }">
								<div
									class="sufee-alert alert with-close alert-danger alert-dismissible fade show">
									<span class="badge badge-pill badge-danger">error</span> Tai
									khoan ton tai
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:when>
							<c:when test="${param.mess eq 'password' }">
								<div
									class="sufee-alert alert with-close alert-danger alert-dismissible fade show">
									<span class="badge badge-pill badge-danger">error</span>
									Password khong dung
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</c:when>
						</c:choose>
						<form id="sky-form1" class="log-reg-block sky-form"
							action="/HoaLanVN/register" method="post"
							enctype="multipart/form-data">
							<h2>Đăng ký tài khoản</h2>
							<div class="login-input reg-input">
								<section>
									<label class="input"> Họ tên</label> <label class="input">
										<input type="text" name="fullname" placeholder="Họ tên"
										class="form-control" required>
									</label>
								</section>
								<section>
									<label class="input"> Tài khoản</label> <label class="input">
										<input type="text" name="username" placeholder="Tài khoản"
										class="form-control" required>
									</label>
								</section>
								<section>
									<label class="input"> Mật khẩu</label> <label class="input">
										<input type="password" name="password" placeholder="password"
										class="form-control" required>
									</label>
								</section>
								<section>
									<label class="input"> Nhập lại mật khẩu</label> <label
										class="input"> <input type="password"
										name="confirmpassword" placeholder="Nhập lại pas"
										class="form-control">
									</label>
								</section>
								<section>
									<label class="input"> Giới tính</label> <label
										for="inline-radio1" class="form-check-label "> <input
										type="radio" id="inline-radio1" name="gender" value="Nam"
										class="form-check-input">Nam
									</label> <label for="inline-radio2" class="form-check-label ">
										<input type="radio" id="inline-radio2" name="gender"
										value="Nữ" class="form-check-input">Nữ
									</label> <label for="inline-radio3" class="form-check-label ">
										<input type="radio" id="inline-radio3" name="gender"
										value="Khác" class="form-check-input">Khác
									</label>
								</section>
								<section>
									<label class="input"> Địa chỉ</label> <label class="input">
										<input type="text" name="address" placeholder="Địa chỉ"
										class="form-control" required>
									</label>
								</section>
								<section>
									<label class="input"> Ngày sinh</label> <label class="input">
										<input type="text" name="datebirth" placeholder="dd/mm/yyyy"
										class="form-control" required>
									</label>
								</section>
								<section>
									<label class="input"> Số điện thoại</label> <label
										class="input"> <input type="text" id="text-input"
										name="phone" placeholder="Phone" class="form-control" required>
									</label>
								</section>
								<section>
									<label class="input"> Ảnh</label> <label class="input">
										<input type="file" id="file-input" name="image"
										class="form-control-file">
									</label>
								</section>
							</div>
							<div class="row margin-bottom-5"></div>
							<button class="btn-u btn-u-sea-shop btn-block margin-bottom-20"
								type="submit">Đăng ký</button>


						</form>

						<div class="margin-bottom-20"></div>
					</div>
				</div>
				<!--/end row-->
			</div>
			<!--/end container-->
		</div>
		<!--=== End Login ===-->


	</div>
	<!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script src="${url}/plugins/jquery/jquery.min.js"></script>
	<script src="${url}/plugins/jquery/jquery-migrate.min.js"></script>
	<script src="${url}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script src="${url}/plugins/back-to-top.js"></script>
	<script src="${url}/plugins/smoothScroll.js"></script>
	<script
		src="${url}/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="${url}/plugins/sky-forms-pro/skyforms/js/jquery.form.min.js"></script>
	<script
		src="${url}/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
	<!-- JS Customization -->
	<script src="${url}/js/custom.js"></script>
	<!-- JS Page Level -->
	<script src="${url}/js/shop.app.js"></script>
	<script src="${url}/js/forms/page_login.js"></script>
	<script src="${url}/js/forms/page_contact_form.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			Login.initLogin();
			App.initScrollBar();
			PageContactForm.initPageContactForm();
		});
	</script>
</body>

</body>
</html>