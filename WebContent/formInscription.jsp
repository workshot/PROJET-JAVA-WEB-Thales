<!-- Modal -->
<div class="modal fade" id="modalInsc" tabindex="-1" role="dialog"
	aria-labelledby="inscTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container">
					<div class="row">
						<h5 class="modal-title" id="modalInscTitle">Inscription</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="row justify-content-md-center">
						<div class="col col-md-auto">
							<span id="inscerror" class="text-danger"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-body">
				<div class="row justify-content-md-center">
					<form id="frmSignin"  action="Inscription" method="post">
						<div class="form-group">
							<label for="id">Identifiant: </label> <input type="number"
								class="form-control" id="id" name="id" aria-describedby="idUserHelp"
								placeholder="Saisir un identifiant" required="required"> <small
								id="idUserHelp" class="form-text text-muted">Ceci est
								votre login.</small>
						</div>
						<div class="form-group">
							<label for="nom">Nom: </label> <input type="text"
								id="nom"  name="nom" aria-describedby="nomHelp" required="required"
								placeholder="Saisir un nom" class="form-control">
							<small id="nomHelp" class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="prenom">Prénom: </label> <input type="text"
								id="prenom" name ="prenom" aria-describedby="nomHelp" required="required"
								placeholder="Saisir un prenom" class="form-control">
							<small id="prenomHelp" class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="password">Mot de passe: </label> <input
								type="password" class="form-control" id="password" name="password"
								required="required" placeholder="Saisir un mot de passe"><small
								id="passwordHelp" class="form-text text-muted">Ne le
								communiquez à personne</small>
						</div>
						<div class="form-group">
							<label for="adresse">Adresse: </label> <input type="text"
								id="adresse" name ="adresse" aria-describedby="adresseHelp" required="required"
								placeholder="Saisir une adresse" class="form-control">
							<small id="prenomHelp" class="form-text text-muted"> Nous ne
								partagerons pas cette adresse.</small>
						</div>
						
						<div class="form-group">
							<label for="email">Adresse courriel: </label> <input type="email"
								class="form-control" id="email" name = "email" aria-describedby="emailHelp"
								placeholder="Saisir une adresse email" required="required"> <small
								id="emailHelp" class="form-text text-muted">Nous ne
								partagerons pas cette adresse.</small>
						</div>
						<div class="form-group">
							<label for="tel">Tél: </label> <input type="tel"
								class="form-control" id="tel" name = "tel" aria-describedby="telHelp"
								placeholder="Saisir un numéro de tél" required="required"> <small
								id="emailHelp" class="form-text text-muted">Nous ne
								partagerons pas ce numéro.</small>
						</div>
						<div class="form-group">
							<label for="livraison">Livraison: </label> <input type="text"
								class="form-control" id="livraison" name ="livraison" aria-describedby="livraisonHelp"
								placeholder="Saisir des instructions livraison" required="required"> <small
								id="livraisonHelp" class="form-text text-muted">Des instructions sur la livraison.</small>
						</div>
						
						
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" id="rememberme">
							<label class="form-check-label" for="rememberme">Se
								rappeler de moi</label>
						</div>
							<input type="submit" value="Se connecter">
						<input  type="submit" class="btn btn-success btn-lg" value="S'inscrire"
					     id="btnLoginSend" disabled="disabled" >
			
						
					</form>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>

