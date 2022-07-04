<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleCommande.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>

	<div class="container-fluid">

		<div class="cardTitle">
			<h2>
				Commande de
				<c:out value="${sessionScope.USER_CONNECTED_SESSION.nom}" />
			</h2>
			<h3>
				Montant total du panier :
				<fmt:formatNumber type="number" minFractionDigits="2"
					maxFractionDigits="2" value="${sessionScope.total}" />
				&euro;
			</h3>
		</div>
		<br /> <br />
		<div class="card" style="max-width:600px;">

			<form action="facture" method="post">
				<table>
					<tr>
						<th>Article</th>
						<th>Quantité</th>
						<th>Prix total (&euro;)</th>
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

				<button type="button" onclick="window.location.href = 'commande'"
					class="btn btn-danger float-left">Retour au panier</button>
				<button type="submit" class="btn btn-success float-right">Valider
					la commande</button>
				<br /> <br />

			</form>
		</div>
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>