<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tronghoang.model.DetailOrder"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
HttpSession a = request.getSession();
List<DetailOrder> cartList = (List<DetailOrder>) a.getAttribute("cartList");
if(cartList != null){
	int count = cartList.size();
	request.setAttribute("count", count);
}
else{
	int count =0;
}
%>
<ul class="list-inline shop-badge badge-lists badge-icons pull-right">
	<li><a href="/HoaLanVN/traodoi/shop/cart"><i class="fa fa-shopping-cart"></i></a> <span
		class="badge badge-sea rounded-x">${count}</span></li>
</ul>