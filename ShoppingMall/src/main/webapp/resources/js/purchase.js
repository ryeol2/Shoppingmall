/**
 * 
 */

var checking= function(){
	var checking = document.purchased.checking.checked;
	if(chekcing){
		document.getElementById('homeAdds').value =document.getElementById('adds').value;
		
	}else{
		document.getElementById('homeAdds').value ='';
	}
	
};