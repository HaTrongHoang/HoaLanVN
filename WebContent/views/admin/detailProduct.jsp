<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Hoa Lan Việt Nam</title>

<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>
</head>

<body>

	<!-- HEADER -->
	<jsp:include page="/views/admin/common/header.jsp"></jsp:include>
	<!-- MAIN CONTENT-->
	<div class="main-content">
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
											src="${pageContext.request.contextPath }/upload/product/${productDetail.image }"
											name="img" alt="..." class="img-thumbnail">
									</div>
								</div>

								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Tên</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.name }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Mô
											tả</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.des }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Giá</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.price }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Loại</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.category }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Số
											lượng</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.amount }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Người
											bán</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.user.fullname }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Ngày
											đăng</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${productDetail.date_created }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Trạng
											thái</label>
									</div>
									<div class="col-12 col-md-9">
										<c:choose>
											<c:when test="${productDetail.status eq '1' }">
												<label for="text-input" class=" form-control-label">Chưa
													duyệt</label>
											</c:when>
											<c:when test="${productDetail.status eq '2' }">
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

	</div>

	<jsp:include page="/views/admin/common/scriptJS.jsp"></jsp:include>
</body>

</html>
<!-- end document-->
