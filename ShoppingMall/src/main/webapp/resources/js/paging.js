/**
 * 
 */

var prebtn= function(){
	
}

var nextbtn = function(){
	
}

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