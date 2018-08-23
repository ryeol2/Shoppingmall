<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/login.js"charset="utf-8"></script>
</head>
<body>
<h1 class="header"><a href="main">쇼핑몰's</a></h1><br><br>

<c:if test="${loginChecked eq false}">
<p class="failLogin">로그인에 실패했습니다. 다시 로그인 해주세요.</p>
</c:if>
<form action="login_user" method="post">
<p class="id"><input type="text" name="userId" id="userId" size="20" placeholder="아이디" ></p>
<p class="password"><input type="password" name="userPwd" size="20" placeholder="비밀번호"></p>
&nbsp;&nbsp;&nbsp;<p class="loginSubmit"><input type="submit"  value="로그인">&nbsp;&nbsp;&nbsp;<a href="join" >회원가입</a></p>
</form>


</body>
</html>