<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <% request.getSession(true).getAttribute("logined"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/purchase.css" type="text/css"></link>
<script language="javascript" src="${pageContext.request.contextPath}/resources/js/purchase.js"charset="utf-8"></script>
<title>구매하기</title>
</head>
<body>
<form action="purchased" method="get">
<p align="center"><img src="/imgReposity/${item_info.imgName}" width="150" height="150"></p>
<p align="center">상품명 : ${item_info.productName}</p>
<p align="center">수   량 : ${stock}
<p align="center">가   격 : <fmt:formatNumber value="${ stock * item_info.price}" pattern="###,###"></fmt:formatNumber>￦</p>
<p align="center">배송주소 | 기존 배송주소 선택 <input type="checkbox" id="checking"></p>
<p align="center"><input type="text" id="homeAdds" size="50"></p>
<input type="hidden" id="adds" value="${logined.userAdds}">
<p align="center"><input type="submit" value="구매하기"></p>
<input type="hidden" name="stockCount" value="${stock}">
</form>
 
</body>
</html>