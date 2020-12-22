<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Site Metas -->
<title>Hoa Lan Việt Nam</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<jsp:include page="/views/client/common/linkCSS.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/views/client/common/header.jsp"></jsp:include>
	<section class="section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div div class="row">
						<div class="col-lg-9"></div>
						<div class="col-lg-3">
							<div class="widget">
								<form class="form-inline search-form" action="/HoaLanVN/tutorial/search">
									<div class="form-group">
										<input type="text" class="form-control" name="key"
											placeholder="Search on the site">
									</div>
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-search"></i>
									</button>
								</form>
							</div>
						</div>
					</div>
					<div class="blog-list clearfix">
						<div class="section-title">
							<h3 class="color-green">
								<a href="blog-category-01.html" title="">Hoa Lan</a>
							</h3>
						</div>
						<!-- end title -->
						<c:forEach items="${tutorialList }" var="tutorial">
							<div class="blog-box row">
								<div class="col-md-4">
									<div class="post-media">
										<a href="single.html" title=""> <img
											src="${pageContext.request.contextPath }/upload/content/_thumbs/${tutorial.thumbnail }"
											alt="" class="img-fluid">
											<div class="hovereffect"></div>
										</a>
									</div>
									<!-- end media -->
								</div>
								<!-- end col -->

								<div class="blog-meta big-meta col-md-8">
									<h4>
										<a
											href="/HoaLanVN/tutorial/detail?id_tutorial=${tutorial.id_tutorial }"
											title="">${tutorial.title }</a>
									</h4>
									<p>${tutorial.describe }</p>
									<small><i class="far fa-eye"></i>${tutorial.view }</small>
									<small>${tutorial.date_created }</small>
									<small>${tutorial.category_id.name }</small>
								</div>
								<!-- end meta -->
							</div>
							<!-- end blog-box -->

							<hr class="invis">
						</c:forEach>
					</div>
					<!-- end blog-list -->
				</div>
				<!-- end blog-list -->

				<hr class="invis">
	</section>
	<div class="user-data__footer">
		<nav aria-label="Page navigation example ">
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${page le totalPage }">
						<li class="page-item"><a class="page-link"
							href="${requestScope.request_uri}?category_id=${category}&page=1">Previous</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${requestScope.request_uri}?category_id=${category}&page=${page-1 }">Previous</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach items="${pageList}" var="page">
					<li class="page-item "><a class="page-link"
						<c:if test="${param.page eq page}"> style="background-color: #c1c1c1 " </c:if>
						href="${requestScope.request_uri}?category_id=${category}&page=${page}">${page}</a></li>
				</c:forEach>
				<c:choose>
					<c:when test="${page ge totalPage }">
						<li class="page-item"><a class="page-link"
							href="${requestScope.request_uri}?category_id=${category}&page=${totalPage}">Next</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${requestScope.request_uri}?category_id=${category}&page=${page +1 }">Next</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
	<jsp:include page="/views/client/common/footer.jsp"></jsp:include>
	<jsp:include page="/views/client/common/scriptJS.jsp"></jsp:include>

</body>

</html>