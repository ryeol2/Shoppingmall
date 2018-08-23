/**
 * 
 */

// var Refresh = function(){
// window.location.reload();
// };
var topOver = function() {
	for (var i = 1; i < 5; i++) {
		var top = document.getElementById('topSub' + i);
		top.style.visibility = "visible";
	}
	return;

}

var btmOver = function() {
	for (var i = 1; i < 5; i++) {
		var top = document.getElementById('btmSub' + i);
		top.style.visibility = "visible";
	}
	return;

}

var Out = function() {
	for (var i = 1; i < 5; i++) {
		var top = document.getElementById('topSub' + i);
		top.style.visibility = "hidden";
	}

	for (var i = 1; i < 5; i++) {
		var top = document.getElementById('btmSub' + i);
		top.style.visibility = "hidden";
	}

	return;
}

var newArrival = function(){
	alert("상품 준비중입니다.");
	window.location.reload();
}
var sale = function(){
	alert("상품 준비중입니다.");
	window.location.reload();
}
