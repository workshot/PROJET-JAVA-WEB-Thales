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


function connecter(){
	$.ajax({
		url:"http://localhost:8080/projetBijouxGroupe5/Login",
		method: "get",
		data: {
			id: $("#id").val(),
			pass: $("#pass").val()	
		},
		success:function(data){
				if(data == true){
					displayAuth();
					$("#modalValidationTitle").html("connexion");
					$("#modalValidationMsg").html("Content de vous revoir !");
					$("#modalvalidation").modal('toggle');
					setTimeout(function(){
						$("#modalvalidation").modal('hide');
						window.location.reload();
					},2000);
				}
				else{
					$("#connerror").html("Login ou mot de passe incorrecte !");
				}
			
		},
		error:function(error){
			$("#connerror").html("Problème de connexion au serveur !");	
		}
	});
	}

function deconnecter(){
	$.ajax({
		url:"http://localhost:8080/projetBijouxGroupe5/ServletLogout",
	method: "post",
	data: {
	},
	success:function(data){
			if(data == true){
				$("#modalValidationTitle").html("déconnexion");
				$("#modalValidationMsg").html("A bientôt !");
				$("#modalvalidation").modal('toggle');
				setTimeout(function(){
					$("#modalvalidation").modal('hide');
					window.location.replace("http://localhost:8686/home");
				},2000);
			}
			else{
				$("#connerror").html("Hmm, vous n'étiez pas connecté !");
			}
		
	},
	error:function(error){
		$("#connerror").html("Problème de connexion au serveur !");	
	}
});
}

$(function() {

	if ( $('.owl-2').length > 0 ) {
        $('.owl-2').owlCarousel({
            center: false,
            items: 1,
            loop: true,
            stagePadding: 0,
            margin: 20,
            smartSpeed: 1000,
            autoplay: true,
            nav: true,
            dots: true,
            pauseOnHover: false,
            responsive:{
                600:{
                    margin: 20,
                    nav: true,
                  items: 2
                },
                1000:{
                    margin: 20,
                    stagePadding: 0,
                    nav: true,
                  items: 3
                }
            }
        });            
    }

})