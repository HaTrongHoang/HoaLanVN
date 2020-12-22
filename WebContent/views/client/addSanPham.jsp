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
						<div class="col-lg-12">
							<!--<c:choose>
								<c:when test="${param.mess eq 'update' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Sua thanh cong
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
								<c:when test="${param.mess eq 'delete' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Xoa thanh cong
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
							</c:choose>
							 USER DATA-->

							<div class="card-header">
								<strong>Thêm Sản Phẩm</strong>
							</div>
							<div class="card-body card-block">
								<form action="/HoaLanVN/traodoi/shop/gianhang/add" method="post"
									class="form-horizontal" enctype="multipart/form-data">
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Tên
												Sản Phẩm</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" id="text-input" name="name" placeholder=""
												class="form-control" required> <small
												class="form-text text-muted">This is a help text</small>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Giá</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" id="text-input" name="price"
												placeholder="" class="form-control" required> <small
												class="form-text text-muted">This is a help text</small>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Loại
												hoa</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" id="text-input" name="category"
												placeholder="" class="form-control" required> <small
												class="form-text text-muted">This is a help text</small>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="textarea-input" class=" form-control-label">Mô
												tả</label>
										</div>
										<div class="col-12 col-md-9">
											<textarea name="des" id="textarea-input" rows="6"
												placeholder="Describe..." class="form-control"></textarea>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Số lượng</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" id="text-input" name="amount"
												placeholder="" class="form-control" required> <small
												class="form-text text-muted">This is a help text</small>
										</div>
									</div>
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="file-input" class=" form-control-label">Ảnh</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="file" id="file-input" name="image"
												class="form-control-file">
										</div>
									</div>
									<div class="card-footer">
										<button type="submit" class="btn btn-primary btn-sm">
											<i class="fa fa-dot-circle-o"></i> Submit
										</button>
										<button type="reset" class="btn btn-danger btn-sm">
											<i class="fa fa-ban"></i> Reset
										</button>
									</div>
								</form>
							</div>
							<!-- END USER DATA-->
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
