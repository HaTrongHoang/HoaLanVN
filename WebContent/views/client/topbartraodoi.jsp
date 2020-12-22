<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/view/client/static" var="url"></c:url>
<div class="topbar-v3">


	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				
			</div>
			<c:choose>
				<c:when test="${sessionScope.loginClient == null}">
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
							<li><a href="${pageContext.request.contextPath }/login">Login</a>
								| <a href="${pageContext.request.contextPath }/register">Register</a></li>
							<li><i class="search fa fa-search search-button"></i></li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-sm-6">
						<ul class="list-inline right-topbar pull-right">
							<li><a >${sessionScope.loginClient.fullname }</a> | <a
								href="${pageContext.request.contextPath }/logout-client">Logout</a></li>
							
						</ul>
					</div>
				</c:otherwise>
			</c:choose>



		</div>
	</div>
	<!--/container-->
</div>
