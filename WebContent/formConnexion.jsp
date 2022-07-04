<!-- Modal -->
<div class="modal fade" id="modalAuth" tabindex="-1" role="dialog"
	aria-labelledby="authTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container">
					<div class="row">
						<h5 class="modal-title" id="modalAuthTitle">Authentification</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<!--  <span aria-hidden="true">&times;</span>-->
						</button>
					</div>
					<div class="row justify-content-md-center">
						<div class="col col-md-auto">
							<span id="connerror" class="text-danger"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-body">
				<div class="row justify-content-md-center">
					<div id="authRetour">
						<form id="frmLogin" action="Login" method="post" >
							<div class="form-group">
								<label for="idUser"><span
									class="glyphicon glyphicon-user"></span> Identifiant : </label> <input
									type="text" id="id" name="id" required="required" placeholder="Saisir votre identifiant"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="pass"><span
									class="glyphicon glyphicon-eye-close"></span> Mot de passe : </label> <input
									type="password" id="password" name="password" placeholder="Saisir votre mot de passe"
									required="required" class="form-control">
							</div>
							<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" id="rememberme">
							<label class="form-check-label" for="rememberme">Se
								rappeler de moi</label>
						</div>
						<input type="submit" class="btn btn-primary btn-lg" value="Se connecter"
					id="btnLoginSend" disabled="disabled" >
						
						</form>
					</div>
				</div>
			</div>
		
			<div class="modal-footer">
			
				
			</div>
		</div>
	</div>
</div>
<!--page d'authentification de l'application-->
