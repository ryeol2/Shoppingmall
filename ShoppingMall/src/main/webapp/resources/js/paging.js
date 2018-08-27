/**
 * 
 */

var prevbtn = function(category) {
	var sendData = {
		category : category
	};

	$.ajax({
		type : "GET",
		url : "getPrevPage",
		data : sendData,
		dataType : "html",
		success : function(data) {
			numberClick(category, data);
		},
		error : function() {
			alert("connect error");
		}
	});

};

var nextbtn = function(category) {
	var sendData = {
		category : category
	};

	$.ajax({
		type : "GET",
		url : "getNextPage",
		data : sendData,
		dataType : "html",
		success : function(data) {
			numberClick(category, data);
		},
		error : function() {
			alert("connect error");
		}
	});
};
//
var numberClick = function(category, numPage) {
	var sendData = {
		category : category,
		page : numPage
	};
	var html = new Array();
	var price;
	$.ajax({
		type : "GET",
		url : "getPageSite",
		data : sendData,
		dataType : "json",
		success : function(data) {
			$.each(data, function(key, value) {
				if (value.stock === 0) {
					price = "<label  style='color:red'>품 절</label>";
				} else {
					price = parseInt(value.price).toLocaleString() + "￦";
				}
				// var price = /\B(?=(\d{3})+(?!\d))/g;
				html.push("<tr class='item_img'>"
						+ "<td align='center'><a href='detail?category="
						+ sendData.category + "&item=" + value.productId + "'>"
						+ "<img src='/imgReposity/" + value.imgName
						+ "' width='300px' height='300px'></a><br><br>"
						+ "<p id='productName'>" + value.productName + "</p>"
						+ price + "</td></tr>");

				$("#itemMain").html(html);

			});

		},
		error : function() {
			alert("connect error");
		}

	});
	return;
};
//
//var pageView = function(data){
//alert(data);	
//};
