<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tronghoang.dao.ContactDao"%>
<%@ page import="com.tronghoang.dao.impl.ContactDaoImpl"%>
<%@ page import="com.tronghoang.model.Contact"%>
<footer class="footer">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 offset-lg-2">
				<div class="widget">
					<div class="footer-text text-center">
						<a href="index.html"><img src="/HoaLanVN/images/logo2png.png" alt=""
							class="img-fluid"></a>
						<p>Hiệp Hội Hoa Lan Việt Nam</p>

						<hr class="invis">
					</div>
					<!-- end footer-text -->
				</div>
				<!-- end widget -->
			</div>
			<!-- end col -->
		</div>
		<%
			ContactDao contactDao = new ContactDaoImpl();
		Contact contact = contactDao.getById(1);
		request.setAttribute("contact", contact);
		%>
		<div class="row">
			
			<div class="col-lg-4">
				<i class="fas fa-phone"></i>${contact.phone }

			</div>
			<div class="col-lg-4">
				<i class="fas fa-envelope-open"></i>${contact.email }
			</div>
			<div class="col-lg-4">
				<i class="fas fa-map-marked"></i>${contact.address }
			</div>
			<hr class="invis">
		</div>
	</div>
	<!-- end container -->
</footer>
<!-- end footer -->



<div class="dmtop">Scroll to Top</div>

</div>
<!-- end wrapper -->

