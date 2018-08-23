<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>아이템 수정</title>
</head>
<body>
<form action="modified" method="post">
<p><img alt="${modify_item.imgName}" src="${path}/${modify_item.imgName}" width="500px" height="300px"></p> 
<p>상품명 : <input type="text" name="itemName" value="${modify_item.productName }" size="30"></p>
<p>상품설명 : <input type="text" name="itemDescribe" value="${modify_item.pdescribe}" size="100"></p>
<p>재    고 : <input type="text" name="itemStock" value="${modify_item.stock}" size="10"> 개</p>
<p>가    격 : <input type="text" name="itemPrice" value= "${modify_item.price}" size="10"> ￦</p>
<input type="hidden" name="group" value="${modify_item.productId}">
<input type="submit" value="수정">
</form>
</body>
</html>