
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
<title>Banner</title>

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
								<strong>Banner</strong>
							</div>
							<div class="card-body card-block">


								<form action="/HoaLanVN/admin/banner
								" method="post"
									class="form-horizontal" enctype="multipart/form-data">
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">Banner</label>
										</div>

										<div class="col-12 col-md-3">
											<img style="width: 200px" height="300px"
												src="${pageContext.request.contextPath }/upload/banner/${banner.image1 }"
												name="img" alt="..." class="img-thumbnail"> <input
												type="file" id="file-input" name="image1"
												class="form-control-file">
										</div>
										<div class="col-12 col-md-3">
											<img style="width: 200px" height="300px"
												src="${pageContext.request.contextPath }/upload/banner/${banner.image2 }"
												name="img" alt="..." class="img-thumbnail"> <input
												type="file" id="file-input" name="image2"
												class="form-control-file">
										</div>
										<div class="col-12 col-md-3">
											<img style="width: 200px" height="300px"
												src="${pageContext.request.contextPath }/upload/banner/${banner.image3 }"
												name="img" alt="..." class="img-thumbnail"> <input
												type="file" id="file-input" name="image3"
												class="form-control-file">
										</div>
									</div>
									<div class="card-footer">
										<button type="submit" class="btn btn-primary btn-sm">
												<i class="zmdi zmdi-edit"></i>Update
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
