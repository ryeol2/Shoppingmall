/**
 * 
 */

var prebtn= function(category){
	var sendData = {category: category};
	
	$.ajax({
	type: "GET",
	url: "getPrevPage",
	data: sendData,
	dataType: "html",
	success: function(data){
	$(location).attr('href',data);	
	},
	error: function(){
		alert("connect error");
	}
	});
	
	
};

var nextbtn = function(category){
	var sendData = {category: category};
	
	$.ajax({
	type: "GET",
	url: "getNextPage",
	data: sendData,
	dataType: "html",
	success: function(data){
	$(location).attr('href',data);	
	},
	error: function(){
		alert("connect error");
	}
	});
};

var numberClick =  function(category,numPage){
	var sendData = {category : category, page: numPage};
	
$.ajax({
	type: "GET",
	url: "getPageSite",
	data: sendData,
dataType: "html",
success: function(data){
	$(location).attr('href',data);
},
error: function(){
	alert("connect error");
}
});
	
};