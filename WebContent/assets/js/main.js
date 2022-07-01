/**
 * 
 */
 $(document).ready(function(){
	
	formValidator("#frmLogin","#btnLoginSend");
	formValidator("#frmSignin","#btnSigninSend");

});

function displayAuth(){
	$('#modalAuth').modal('toggle');
}

function displayInsc(){
	$("#modalInsc").modal('toggle');
}


function formValidator(form, submitbtn){
	let inputs = $(form + ">div>input").attr("required","required");

	inputs.on("input",function(){
		let isFormCompleted = true;
		for(var i = 0; i < inputs.length; i++){
			if(! (inputs[i].value))
				isFormCompleted = false;
		}
		if(isFormCompleted == true)
			$(submitbtn).removeAttr("disabled");
		else
			$(submitbtn).attr("disabled","disabled");	
	});
}