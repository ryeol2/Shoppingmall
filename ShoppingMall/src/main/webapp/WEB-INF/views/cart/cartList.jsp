<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <% request.getSession(true).getAttribute("logined"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cart.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/cart.js"charset="utf-8"></script>
<title>장바구니 목록</title>
</head>
<body>
<h1 align="center">장바구니</h1>
<br><br><br><br><br>
<form action="cartPurchase" method="post">
<table class="cartlist" align="center">
<tr align="center">
<td><font color="skyblue" style="font-weight:bold">선   택</font></td>
<td><font color="skyblue" style="font-weight:bold">상품명</font></td>
<td><font color="skyblue" style="font-weight:bold">수   량</font></td>
<td><font color="skyblue" style="font-weight:bold">가   격</font></td>
</tr>
<c:forEach var="itemList" items="${cartList}">
<tr align="center">
<td><input type="checkbox" name="choiceDelete" value="${itemList.cartId}"></td>
<td>${itemList.productName}</td><!-- 상품명 -->
<td>${itemList.stock}</td> <!-- 수량 -->
<c:set var="sum" value="${itemList.stock * itemList.price}"></c:set>
<c:set var="total" value="${total+sum}"></c:set>
<td><fmt:formatNumber value="${sum}" pattern="###,###"></fmt:formatNumber>￦</td><!-- 가격 -->
</tr>
</c:forEach>
</table>

<c:choose>
<c:when test="${total eq null}">
<p align="center" style="color:red">장바구니가 비었습니다.</p>
<p align="center"><a href="main">메인으로</a></p>
</c:when>
<c:otherwise>
<p align="center">총 가격 : <fmt:formatNumber value="${total}" pattern="###,###"></fmt:formatNumber>￦</p>
<p align="center"><input type="submit" value="구매하기">
</c:otherwise>
</c:choose>
</form>
</body>
</html>