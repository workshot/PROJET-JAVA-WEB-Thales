<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleCommande.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>

	<h2>
		Commande de
		<c:out value="${sessionScope.client}" />
	</h2>
	<h3>
		Montant total du panier :
		<fmt:formatNumber type="number" minFractionDigits="2"
			maxFractionDigits="2" value="${sessionScope.total}" />
		&euro;
	</h3>
	<br />
	<br />
	<div class="panier">

		<form action="facture" method="post">
			<table>
				<tr>
					<th>Article</th>
					<th>Quantité</th>
					<th>Prix total</th>
				</tr>
				<c:forEach var="i" items="${sessionScope.items}">
					<tr>
						<td><c:out value="${i.key.nom}" /></td>
						<td><c:out value="${i.value}" /></td>
						<td><fmt:formatNumber type="number" minFractionDigits="2"
								maxFractionDigits="2" value="${i.value * i.key.prix}" /></td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br />

			<button type="button" onclick="window.location.href = 'commande'">Retour
				au panier</button>
			<button type="submit">Valider la commande</button>
			<br /> <br />

		</form>
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>