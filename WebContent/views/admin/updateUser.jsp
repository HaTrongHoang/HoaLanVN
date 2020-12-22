<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >

<head>
<!-- Required meta tags-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Sửa thông tin</title>

<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>
</head>

<body>
	<div class="page-wrapper">
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
									<strong>Sửa thông tin</strong>
								</div>
								<div class="card-body card-block">
									<form
										action="/HoaLanVN/admin/user/update?id_user=${userUpdate.id_user }"
										method="post" class="form-horizontal"
										enctype="multipart/form-data"accept-charset="UTF-8">
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Ảnh</label>
											</div>
											<div class="col-12 col-md-9">
												<img
													src="${pageContext.request.contextPath }/upload/user/${userUpdate.image }"
													name="img" alt="..." class="img-thumbnail"> <input
													type="file" id="file-input" name="image"
													class="form-control-file"
													value="E:/Java/HoaLanVN/WebContent/upload/user/download.jpg">
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Họ tên</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="fullname"
													value="${userUpdate.fullname }" placeholder="Fullname"
													class="form-control" required > <small
													class="form-text text-muted">This is a help text</small>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Tài khoản</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="username"
													placeholder="Username" class="form-control"
													value="${userUpdate.username }" disabled> <small
													class="form-text text-muted">This is a help text</small>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="email-input" class=" form-control-label">Mật khẩu</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="password" id="password-input" name="password"
													placeholder="Password" class="form-control"
													value="${userUpdate.password }" disabled> <small
													class="form-text text-muted">This is a help text</small>
											</div>
										</div>
										<!--  <div class="row form-group">
											<div class="col col-md-3">
												<label for="disabled-input" class=" form-control-label">Disabled
													Input</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="disabled-input" name="disabled-input"
													placeholder="Disabled" disabled="" class="form-control">
											</div>
										</div>-->
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="select" class=" form-control-label">Chức vụ</label>
											</div>
											<div class="col-12 col-md-9">
												<select name="role" id="select" class="form-control" required>
													<option value="Admin"
														<c:if test="${userUpdate.role eq 'Admin' }">selected</c:if>>Admin</option>
													<option value="Member"
														<c:if test="${userUpdate.role eq 'Member' }">selected</c:if>>Member</option>
												</select>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label class=" form-control-label">Giới tính</label>
											</div>
											<div class="col col-md-9">
												<div class="form-check-inline form-check">
													<label for="inline-radio1" class="form-check-label ">
														<input type="radio" id="inline-radio1" name="gender"
														value="Male" class="form-check-input"
														<c:if test="${userUpdate.gender eq 'Male' }">checked</c:if>>Nam
													</label> <label for="inline-radio2" class="form-check-label ">
														<input type="radio" id="inline-radio2" name="gender"
														value="Female" class="form-check-input"
														<c:if test="${userUpdate.gender eq 'Female' }">checked</c:if>>Nữ
													</label> <label for="inline-radio3" class="form-check-label ">
														<input type="radio" id="inline-radio3" name="gender"
														value="Other" class="form-check-input"
														<c:if test="${userUpdate.gender eq 'Other' }">checked</c:if>>Khác
													</label>
												</div>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Địa chỉ</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="address"
													placeholder="Address" class="form-control"
													value="${userUpdate.address }"required> <small
													class="form-text text-muted">This is a help text</small>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Ngày sinh</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="datebirth"
													placeholder="dd/mm/yyyy" class="form-control"
													value="${userUpdate.datebirth }"> <small
													class="form-text text-muted">This is a help text</small>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="text-input" class=" form-control-label">Số điện thoại</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="phone"
													placeholder="Phone" class="form-control"
													value="${userUpdate.phone }"required> <small
													class="form-text text-muted">This is a help text</small>
											</div>
										</div>
										<!--<div class="row form-group">
											<div class="col col-md-3">
												<label for="file-multiple-input" class=" form-control-label">Multiple
													File input</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="file" id="file-multiple-input"
													name="file-multiple-input" multiple=""
													class="form-control-file">
											</div>
										</div>-->

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
