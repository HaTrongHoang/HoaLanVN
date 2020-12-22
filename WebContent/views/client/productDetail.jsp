<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<!-- Title Page-->
<title>Trang chủ</title>

<!-- Fontfaces CSS-->
<jsp:include page="/views/client/static/linkCss.jsp"></jsp:include>

</head>

<body>
	<div class="page-wrapper">
		<!-- header -->
		<jsp:include page="/views/client/static/header.jsp"></jsp:include>
		<!--end header -->
		<!-- MAIN CONTENT-->
		<div class="main-content" style="background: #fff">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-11">
							<div class="card">
								<div class="card-header">
									<strong>Thông tin sản phẩm</strong> >
								</div>
								<div class="card-body card-block">
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Ảnh</label>
										</div>
										<div class="col-12 col-md-9">
											<img style="width: 200px" height="300px"
												src="${pageContext.request.contextPath }/upload/product/${detailProduct.image }"
												name="img" alt="..." class="img-thumbnail">
										</div>
									</div>

									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Tên</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.name }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Mô
												tả</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.des }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Giá</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.price }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Loại</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.category }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Số
												lượng</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.amount }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Người
												bán</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.user.fullname }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Ngày
												đăng</label>
										</div>
										<div class="col-12 col-md-9">
											<label for="text-input" class=" form-control-label">${detailProduct.date_created }</label>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Trạng
												thái</label>
										</div>
										<div class="col-12 col-md-9">
											<c:choose>
												<c:when test="${detailProduct.status eq '1' }">
													<label for="text-input" class=" form-control-label">Chưa
														duyệt</label>
												</c:when>
												<c:when test="${detailProduct.status eq '2' }">
													<label for="text-input" class=" form-control-label">Đã
														duyệt</label>
												</c:when>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- END MAIN CONTENT-->
	<!-- END PAGE CONTAINER-->
	</div>

	</div>

	<jsp:include page="/views/client/static/scriptJS.jsp"></jsp:include>

</body>

</html>
<!-- end document-->
>
