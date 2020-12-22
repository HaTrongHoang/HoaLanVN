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
							<c:choose>
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
								<c:when test="${param.mess eq 'success' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Thêm thành công
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
								<c:when test="${param.mess eq 'successorder' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Đặt thành công
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
							</c:choose>

							<h3 class="title-3 m-b-30">
								<i class="zmdi zmdi-account-calendar"></i>Danh sách sản phẩm
							</h3>
							<div class="table-data__tool">
								<div class="table-data__tool-left">
									<button class=" au-btn-icon au-btn--small">
										<a href="/HoaLanVN/traodoi/shop/gianhang/add"><i
											class="zmdi zmdi-plus"></i>THÊM SẢN PHẨM</a>
									</button>
								</div>
								<div class="table-data__tool-right">

									<form class="form-header"
										action="/HoaLanVN/admin/category/search" method="POST">
										<input class="au-input au-input--xl" type="text" name="key"
											placeholder="Search ..." /> <input type="text" value="2"
											name="status" hidden="">
										<button class="au-btn--submit" type="submit">
											<i class="zmdi zmdi-search"></i>
										</button>
									</form>
								</div>
							</div>



							<!-- END USER DATA-->
						</div>
					</div>
					<div class="row">
						<c:forEach items="${productList }" var="product">
							<div class="col-lg-3">
								<div class="card" style="width: 18rem;">
									<img
										src="${pageContext.request.contextPath }/upload/product/${product.image }"
										class="card-img-top" alt="..."
										style="width: 18rem; height: 18rem">
									<div class="card-body">
										<a
											href="/HoaLanVN/traodoi/shop/gianhang/product/detail?id=${ product.id}">${product.name }</a>
									</div>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">Giá :${product.price } VND</li>
										<c:choose>
											<c:when test="${product.status eq 1}">
												<li class="list-group-item">Trạng thái: Chờ duyệt</li>
											</c:when>
											<c:when test="${product.status eq 0}">
												<li class="list-group-item">Trạng thái:Không duyệt</li>
											</c:when>
											<c:when test="${product.status eq 2}">
												<li class="list-group-item">Trạng thái:Đã duyệt</li>
											</c:when>
										</c:choose>
										<li class="list-group-item">Số lượng: ${product.amount }</li>
									</ul>
									<div class="card-body">
										<a
											href="/HoaLanVN/traodoi/shop/gianhang/delete?id=${product.id }"
											class="card-link">Xóa</a>
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
											href="${requestScope.request_uri}?page=1">Previous</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?page=${page-1 }">Previous</a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach items="${pageList}" var="page">
									<li
										class="page-item <c:if test="${param.page eq page}"> active </c:if> "><a
										class="page-link"
										href="${requestScope.request_uri}?page=${page}">${page}</a></li>
								</c:forEach>
								<c:choose>
									<c:when test="${page ge totalPage }">
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?page=${totalPage}">Next</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?page=${page +1 }">Next</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
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
