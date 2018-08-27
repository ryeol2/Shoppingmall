<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/item.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/paging.js"charset="utf-8"></script>
<title>Outers</title>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div id="purchaseForm">
<table id="itemMain">
<c:forEach var="list" items="${listOuter}">
<tr class="item_img">
<td align="center"><a href="detail?category=outers&item=${list.productId}"><img src="/imgReposity/${list.imgName}" width="300px" height="300px"></a>
<br><br><p id="productName">${list.productName}</p> 
<c:choose>
<c:when test="${list.stock eq 0}">
<label  style="color:red">품 절</label>
</c:when>
<c:otherwise>
<fmt:formatNumber value="${list.price}" pattern="###,###"></fmt:formatNumber>￦
</c:otherwise>
</c:choose>
</td></tr>
</c:forEach>
</table>
</div><br>

<div class="box-footer">
<div class="text-center" id="paging">
<!--<c:if test="${pageMaker.prev}"></c:if>-->
<a href="javascript:void(0);" onclick="prevbtn('outers')"><font size="5px">◀</font></a>

<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"  var="numPage">
<a href="javascript:void(0);" onclick="numberClick('outers',${numPage})"><font size="5px" >${numPage}</font></a>
</c:forEach>
<!--<c:if test="${pageMaker.next && pageMaker.prev}"></c:if>-->
<a href="javascript:void(0);" onclick="nextbtn('outers')"><font size="5px">▶</font></a>


</div>
</div>
</body>
</html>