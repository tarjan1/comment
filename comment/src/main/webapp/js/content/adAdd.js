/**
 * 
 */

$(function(){
	common.showMessage($("#message").val());
});

function add(){
	
	$("#mainForm").submit();
	
}


$(function(){
	
	$("#save").on("click",function(){
		
		add();
	});
	
})

