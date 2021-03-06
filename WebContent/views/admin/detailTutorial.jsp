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
								<strong>News</strong> > Detail News
							</div>
							<div class="card-body card-block">
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Category</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tutorial.category_id.name }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Thumb</label>
									</div>
									<div class="col-12 col-md-9">
										<img style="width: 200px" height="300px"
											src="${pageContext.request.contextPath }/upload/content/_thumbs/${tutorial.thumbnail }"
											name="img" alt="..." class="img-thumbnail">
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Created</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tutorial.date_created }</label>
									</div>
								</div>

								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Title</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tutorial.title }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Describe</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tutorial.describe }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label class=" form-control-label">Content</label>
									</div>
									<div class="col col-md-9">${tutorial.content }</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Views</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tutorial.view }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Status</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tutorial.status }</label>
									</div>
								</div>
								<div class="card-footer">
									<button type="button" class="btn btn-primary btn-sm">
										<a style="color: #212529"
											href="/HoaLanVN/admin/tutorial/update?id_tutorial=${tutorial.id_tutorial }">
											<i class="zmdi zmdi-edit"></i>Update
										</a>
									</button>
									<button type="button" class="btn btn-danger btn-sm">
										<a style="color: #212529"
											href="/HoaLanVN/admin/tutorial/delete?id_tutorial=${tutorial.id_tutorial }"
											onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
											class="zmdi zmdi-delete"></i>Delete</a>
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
