<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registry.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/main.js"charset="utf-8"></script>
<title>register Item</title>
</head>
<body>
<h1 align="center">상품 입력란</h1>
<div class="mains">
<div class="subs">
<form action="item_registry" method="post"  encType="multipart/form-data">
<select name="items">
<option>선택</option>
<option >----상의----</option>
<option id="outer">외투</option>
<option id="knite">니트</option>
<option id="jacket">자켓</option>
<option id="shirt">셔츠</option>
<option>----하의----</option>
<option id="jean">청바지</option>
<option id="trouser">트라우져</option>
<option id="short">반바지</option>
<option>---------</option>
<option id="acc">악세사리</option>
</select><br>
<p>사&nbsp;&nbsp;&nbsp;&nbsp;진 : <input type="file" name="imgFile"></p>
<p>상품명 : <input type="text" name="itemName" size="30"></p>
<p>상품설명: <input type="text" name="itemDescribe" size="50"></p>
<p>가      격: <input type="text" name="Price" size="30"></p>
<p>재&nbsp;&nbsp;&nbsp;&nbsp;고 : <input type="text" name="itemStock" size="5"></p>
<input type="submit" value="입력">
</form>
</div>
</div>
</body>
</html>