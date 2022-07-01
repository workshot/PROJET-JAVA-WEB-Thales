<%@ include file="/header.jsp" %>
<body>
	<%@ include file="/menu.jsp" %>

	<h2>La commande de <c:out value="${sessionScope.client}"/> (Montant total du panier : <c:out value="${total}"/> &euro;)</h2>

	<div class="panier">
		<h5>Faites votre choix parmi nos articles :</h5>

		<form action="facture" method="post">
			<table>
				<tr>
					<th>Article</th>
					<th>Quantité</th>
					<th>Prix total</th>
				</tr>
				<c:forEach var="i" items="${sessionScope.items}">
					<tr>
						<th><c:out value="${i.key.nom}"/></th>
						<th><c:out value="${i.value}"/></th>
						<th><c:out value="${i.value * i.key.prix}"/></th>
					</tr>
				</c:forEach>
			</table>
			
			<button type="button">Retour au panier</button>
			<button type="submit">Valider la commande</button>

		</form>
	</div>
<%@ include file="/footerAccueil.jsp"%>
</body>
</html>