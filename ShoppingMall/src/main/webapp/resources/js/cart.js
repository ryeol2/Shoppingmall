/**
 * 
 */

var sendCart = function() {
	var checkLogin = document.getElementById('userid').value;

	if (checkLogin !== "") {
		document.getElementById('cartStock').value = document
		.getElementById('stockCount').value;
		 // submit버튼

if (confirm("장바구니 목록으로 가시겠습니까?")) {
	//document.location.href("cartList?userid="+checkLogin);
	document.getElementById('judgeCart').value = true;
}else{
	document.getElementById('judgeCart').value = false;
}
document.getElementById('cartBtn').submit();

	
	} else {
		
		alert("로그인을 먼저 해주세요.");
		document.location.href('login');
		
	}

	return;
};

var deleteItem = function(){
	if(confirm("정말로 삭제하시겠습니까??")){
		
	}else{
		window.location.reload();
	}
	
};