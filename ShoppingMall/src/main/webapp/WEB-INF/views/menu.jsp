<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% request.getSession(true).getAttribute("logined"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/menu.js"charset="utf-8"></script>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/paging.js"charset="utf-8"></script>
<title>Shopping Mall</title>
</head>

<body>
<h1 id="mainLink"><a  href="main" > 쇼핑몰's</a></h1>
<div id="loginJoin">
<% if(session.getAttribute("logined") !=null){ %>
<h4>${logined.getUserName()}님 &nbsp;&nbsp;&nbsp; <a href="logOut">로그아웃</a>&nbsp;&nbsp;&nbsp; 
<a href="cartList?userid=${logined.getUserId()}">장바구니</a></h4>

<%} else{ %>
<h4><a href="login" >로그인</a>&nbsp;&nbsp;&nbsp;</h4>
<%} %>
<c:if test="${logined.getUserId()  eq 'admin'}">
<h4><a href="registry">상품 입력</a></h4>
</c:if>
</div>
<div class="category">
<ul>
<li><a href="#">TOP</a>
<ul>
<li><a href="Outers">Outers</a></li>
<li><a href="Jackets">Jackets</a></li>
<li><a href="Shirts">Shirts</a></li>
<li ><a href="KniteWears">kniteWears</a></li>
</ul></li>
<li><a href="#">BOTTOM</a>
<ul>
<li ><a href="#">Jeans</a></li>
<li ><a  href="#">Trousers</a></li>
<li ><a href="#">Shorts</a></li>
</ul></li>

<li><a href="#">ACC</a>
<ul>
<li><a href="#">Shoes</a></li>
<li><a href="#">Bags</a></li>
<li><a href="#">sunglasses</a></li>
</ul>
</li>
<li><a href="#" onclick="newArrival()">NEW ARRIVAL</a></li>
<li><a href="#" onclick="sale()">SALE</a></li>
</ul>
</div>

</body>
</html>