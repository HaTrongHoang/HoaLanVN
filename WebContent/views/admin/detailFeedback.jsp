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
<title>Forms</title>

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
								<strong>Nội dung phản hồi</strong>
							</div>
							<div class="card-body card-block">

								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Họ tên</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${feedback.fullname }</label>
									</div>
								</div>

								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Email</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${feedback.mail }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Tiêu đề</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${feedback.title }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Nội dung</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${feedback.content }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Trạng thái</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${feedback.status }</label>
									</div>
								</div>
								<div class="card-footer">
									<button class="item" data-toggle="tooltip" data-placement="top"
										title="Done">
										<a
											href="/HoaLanVN/admin/feedback/update?id_feedback=${feedback.id_feedback }">
											<i class="far fa-check-circle"></i>


										</a>
									</button>
									<button class="item" data-toggle="tooltip" data-placement="top"
										title="Delete">
										<a
											href="/HoaLanVN/admin/feedback/delete?id_feedback=${feedback.id_feedback }"
											onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
											class="zmdi zmdi-delete"></i></a>
									</button>
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
