<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

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

	<section class="section wb">
		<div class="container">
			<div class="row">
				<div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
					<div class="page-wrapper">
						<div class="blog-title-area">

							<span class="color-aqua"><a href="blog-category-01.html"
								title="">Tin Tức</a></span>

							<h3>${news.title }</h3>

							<div class="blog-meta big-meta">
								<small><i class="far fa-eye"></i>${news.view }</small>
								<small>${news.date_created }</small>
								<small>Tin tức</small>
							</div>
							<!-- end meta -->
						</div>
						<!-- end title -->

						<div class="single-post-media">
							<img src="upload/hoa-lan-phi-diep-1.jpg" alt="" class="img-fluid">
						</div>
						<!-- end media -->

						<div class="blog-content">
							<div class="pp">${news.content }</div>
							<!-- end pp -->
						</div>
						<!-- end content -->
					</div>
				</div>
				<!-- end title -->
				<hr class="invis1">
				<div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
					<div class="sidebar">
						<div class="widget">
							<h2 class="widget-title">Bài viết liên quan</h2>
						</div>

						<c:forEach items="${newsList }" var="news">
							<div class="blog-box">
								<div class="post-media">
									<a href="/HoaLanVN/news/detail?id_news=${news.id_news }" title=""> <img
										src="${pageContext.request.contextPath }/upload/content/_thumbs/${news.thumbnail }"
										alt="" class="img-fluid">
										<div class="hovereffect"></div> <!-- end hover -->
									</a>
								</div>
								<!-- end media -->
								<div class="blog-meta">
									<h4>
										<a href="/HoaLanVN/news/detail?id_news=${news.id_news }"
											title="">${news.title }</a>
									</h4>
									<small><a href="blog-category-01.html" title="">Tin
											tức</a></small> <small><a href="blog-category-01.html" title="">${news.date_created }</a></small>
								</div>
								<!-- end meta -->
							</div>
						</c:forEach>

						<!-- end blog-list -->
						<!-- end widget -->
					</div>
				</div>
				<!-- end sidebar -->
			</div>
			<!-- end col -->
		</div>
		<!-- end row -->
		</div>
		<!-- end container -->
	</section>

	<jsp:include page="/views/client/common/footer.jsp"></jsp:include>
	<jsp:include page="/views/client/common/scriptJS.jsp"></jsp:include>
</body>
</html>