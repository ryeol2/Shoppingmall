<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <% request.getSession(true).getAttribute("logined"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/cart.js"charset="utf-8"></script>
<title>상품 설명</title>
</head>
<body>

<form action="purchase" method="get">

<h1 align="center">${detail.productName}</h1>
<p align="center"><img alt="${detail.imgName}" src="/imgReposity/${detail.imgName}" width="500px" height="300px"></p><br>

<p align="center">${detail.pdescribe}</p>
<c:choose>
<c:when test="${detail.stock eq 0}">
<p align="center"><font color="red"> 품 절</font></p>
</c:when>
<c:otherwise>
<p align="center"><fmt:formatNumber value="${detail.price}" pattern="###,###"></fmt:formatNumber>￦</p>
</c:otherwise>
</c:choose>
<p align="center">
<select name="stockCount" id="stockCount">
<option>수량선택</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select></p>
<c:if test="${logined.getUserId() eq 'admin' }">
<p align="center"><a href="modify?itemNumber=${detail.productId}">수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?category=${category}&itemNum=${detail.productId}" onclick="deleteItem()">삭제하기</a></p><script> var num = ${detail.productId}</script>
</c:if>
<p align="center"><input type="submit" value="구매하기"></p>

<input type="hidden" name="item" value="${detail.productId}">
<input type="hidden" name="category" value="${category }">

</form>

<form action="cart" method="post" id="cartBtn">
<p align="center"><input type="button" value="장바구니" onclick="sendCart()"></p>

<input type="hidden" name="category" value="${category}">
<input type="hidden" name="item" value="${detail.productId}">
<input type="hidden" name="productName" value="${detail.productName}">
<input type="hidden" name="price" value="${detail.price}">
<input type="hidden" name="cartStock" id="cartStock" >
<input type="hidden" name="userid"  id="userid" value="${logined.getUserId()}">
</form>


</body>
</html>