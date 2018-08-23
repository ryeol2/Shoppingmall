/**
 * 
 */

var idCheck = function(){
	$.ajax({
		type: "GET",
		url: "idCheck",
		data: {userId : $("#userid").val()},
		success: function(data){
			if($("#userid").val()==''){
				alert("아이디를 입력해주세요.");
			}else if(!data){
				alert("사용가능한 아이디입니다.");
			}else{
			 alert('이미 존재하는 아이디입니다.');
			}
		},
		error: function(){alert("connect failed.");}
	});
};

var joinCheck = function(){
	var idCheck = document.getElementById('userid').value;
	var mainpwd = document.getElementById('userPwd').value;
	var pwdCheck = document.getElementById('userPwdCheck').value;
	var emailCheck = document.getElementById('userEmailadds').value;
	var addsCheck = document.getElementById('userAdds').value;
	var checksum = false;
	
	if(idCheck.length<8){
		checksum = false;
		alert('아이디는 8자리 이상입니다.');
		idCheck.focus();
	}else{
		checksum = true;
	}
	if(mainpwd.length>8){
	if(mainpwd === pwdCheck){
		checksum = true;
	}else{
		checksum= false;
		alert('비밀번호가 일치하지 않습니다.');
		mainpwd.foucus();
	}
}else{
	alert('비밀번호 8자리 이상 입력해주세요.');
	mainpwd.foucus();
}
	
	if(emailCheck ===null){
		checksum = false;
		alert('이메일을 선택해주세요.');
		emailCheck.focus();
	}else{
		checksum = true;
	}
	
	if(addsCheck ===""){
		checksum = false;
		alert('주소를 입력해주세요.');
	}else{
		checksum =true;
	}
	
	if(checksum){
		alert("가입을 축하합니다!!!");
		document.getElementById('joinSuccess').submit();
	}
	return;
};

