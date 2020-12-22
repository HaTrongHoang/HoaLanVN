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
	<section class="section wb">
		<div class="container">
			<div class="custombox clearfix">
				${introduce.content }
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