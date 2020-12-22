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

							<h3 class="title-3 m-b-30">
								<i class="zmdi zmdi-account-calendar"></i>Danh sách đơn hàng
							</h3>
							<div class="table-data__tool">
								<div class="table-data__tool-left"></div>
								<div class="table-data__tool-right">

									<form class="form-header"
										action="/HoaLanVN/admin/category/search" method="POST">
										<input class="au-input au-input--xl" type="text" name="key"
											placeholder="Search ..." />
										<button class="au-btn--submit" type="submit">
											<i class="zmdi zmdi-search"></i>
										</button>
									</form>
								</div>
							</div>

							<div class="table-responsive table-data">
								<table class="table">
									<thead>
										<tr>
											<td>ID Đơn hàng</td>
											<td>Họ tên</td>
											<td>Sản phẩm</td>
											<td>Đơn giá</td>
											<td>Số lượng</td>
											<td>Thành tiền</td>
											<td></td>


										</tr>
									</thead>
									<tbody>
										<c:forEach items="${statusList}" var="statusList">
											<tr>
												<td>
													<div class="table-data__info">
														<h6>${statusList.idorder.idorder}</h6>
													</div>
												</td>
												<td>
													<div class="table-data__info">
														<h6>${statusList.idorder.fullname}</h6>
													</div>
												</td>
												<td>
													<div class="table-data__info">
														<h6>${statusList.product.name}</h6>
													</div>
												</td>

												<td>
													<div class="table-data__info">
														<h6>${statusList.product.price}</h6>
													</div>
												</td>
												<td>
													<div class="table-data__info">
														<h6>${statusList.amount}</h6>
													</div>
												</td>
												<td>
													<div class="table-data__info">
														<h6>${statusList.total_product}</h6>
													</div>
												</td>
												<c:choose>
													<c:when test="${statusList.status eq 1 }">
														<td>
															<div class="table-data-feature">
																<button class="item" data-toggle="tooltip"
																	data-placement="top" title="Done">
																	<a
																		href="/HoaLanVN/traodoi/shop/gianhang/donghang/update?id=${statusList.iddetailorder }&status=2">
																		<i class="far fa-check-circle"></i>


																	</a>
																</button>
																<button class="item" data-toggle="tooltip"
																	data-placement="top" title="Delete">
																	<a
																		href="/HoaLanVN/traodoi/shop/gianhang/donghang/update?id=${statusList.iddetailorder }&status=0"
																		onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
																		class="zmdi zmdi-delete"></i></a>
																</button>
															</div>
														</td>
													</c:when>
													<c:when test="${statusList.status eq 2 }">
														<td>
															<div class="table-data__info">
																<h6>Đã duyệt</h6>
															</div>
														</td>
													</c:when>
													<c:when test="${statusList.status eq 0 }">
														<td>
															<div class="table-data__info">
																<h6>Đã hủy</h6>
															</div>
														</td>
													</c:when>
												</c:choose>


											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

							<!-- END USER DATA-->
						</div>
					</div>

					<div class="user-data__footer">
						<nav aria-label="Page navigation example ">
							<ul class="pagination justify-content-center">
								<c:choose>
									<c:when test="${page le totalPage }">
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?status=${status }&page=1">Previous</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?status=${status }&page=${page-1 }">Previous</a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach items="${pageList}" var="page">
									<li
										class="page-item <c:if test="${param.page eq page}"> active </c:if> "><a
										class="page-link"
										href="${requestScope.request_uri}?status=${status }&page=${page}">${page}</a></li>
								</c:forEach>
								<c:choose>
									<c:when test="${page ge totalPage }">
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?status=${status }&page=${totalPage}">Next</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="${requestScope.request_uri}?status=${status }&page=${page +1 }">Next</a></li>
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
