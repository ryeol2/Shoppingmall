<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css" type="text/css"></link>
<script language="javascript"src="${pageContext.request.contextPath}/resources/js/join.js"charset="utf-8"></script>
<title>회원가입</title>
</head>
<body>
<h1 align="center">회원가입</h1><br><br>
<div class="joinForm">
<div class="sub">
<form action="joinSuccess" method="post" id="joinSuccess">
<p>아이디 &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userId" id="userid" size="20">&nbsp;&nbsp;&nbsp;
<input type="button" value="중복 확인" onclick="idCheck()"></p>
<p>이    름 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userName" id="userName" size="20">&nbsp;&nbsp;&nbsp;
<p>비밀번호 <input type="password" name="userPwd" id="userPwd" size="20"><label id="printCheck"></label></p>
<p>재확인&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="userPwdCheck"  id="userPwdCheck" size="20"></p>
<p>E-mail &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userEmail_id"  id="userEmail" size="20">&nbsp;&nbsp;&nbsp;
<select name="userEmail" id="userEmailadds">
<option>선 택</option>
<option value="@naver.com">@naver.com</option>
<option value="@daum.net">@daum.net</option>
<option value="@gmail.com">@gmail.com</option>
</select></p>
<p>주소  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userAdds"  id="userAdds" size="50"></p>
<br>
<p align="center"><input type="button" value="회원가입" onclick="joinCheck()"></p>

</form>
</div>
</div>
</body>
</html>