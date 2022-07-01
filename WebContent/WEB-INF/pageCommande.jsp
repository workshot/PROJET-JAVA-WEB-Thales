<%@ include file="/header.jsp" %>
<body>
	<%@ include file="/menu.jsp" %>

	<h2>Bienvenue <c:out value="${sessionScope.client}"/> !</h2>

	<h3>Préparez votre commande en ligne</h3>

	<div class="panier">
		<h5>Faites votre choix parmi nos articles :</h5>

		<form action="commande" method="get">

			<select name="articleChoisi">
				<c:forEach var="a" items="${applicationScope.articles}">
					<option value='<c:out value="${a.id}"/>'><c:out
							value="${a.idCategorie} - ${a.nom} : ${a.prix} " /></option>
				</c:forEach>
			</select>

			<div>
				Quantité : <input type="number" name="quantite" value="0"
					style="width: 25px">
			</div>

			<button type="submit">Ajouter au panier</button>

		</form>
	</div>

	<div class="facture">
		<h5>Dans votre panier :</h5>

		<form action="commande" method="post">
			<table>
				<tr>
					<th>Article</th>
					<th>Quantité</th>
					<th>Prix total</th>
				</tr>
				<c:forEach var="i" items="${items}">
					<tr>
						<th><c:out value="${i.key.nom}"/></th>
						<th><c:out value="${i.value}"/></th>
						<th><c:out value="${i.value * i.key.prix}"/></th>
					</tr>
				</c:forEach>
			</table>

			<button type="submit">Valider le panier</button>

		</form>
	</div>
<%@ include file="/footerAccueil.jsp"%>
</body>
</html>