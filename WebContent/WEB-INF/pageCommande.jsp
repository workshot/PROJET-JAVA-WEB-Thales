<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleCommande.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>

	<h2>
		Bienvenue
		<c:out value="${sessionScope.client}" />
		!
	</h2>

	<h3>Préparez votre commande en ligne</h3>
	<br />
	<br />


	<div class="container">

		<div class="card panier">
			<h5>Faites votre choix parmi nos articles :</h5>
			<br />

			<form action="commande" method="get">

				<select name="art">
					<option value='' disabled selected><p>Sélectionnez un article...</p></option>
					<c:forEach var="c" items="${applicationScope.categories}">
						<optgroup label="${c.value}">

							<c:forEach var="a" items="${applicationScope.articles}">
								<c:if test="${a.idCategorie == c.key}">
									<option value='<c:out value="${a.id}"/>'>${a.nom} (
									<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${a.prix}" />
									 &euro;)
									</option>
								</c:if>
							</c:forEach>

						</optgroup>
					</c:forEach>
				</select><br /> <br />

				<div>
					Quantité : <input type="number" name="qte" value="1"
						style="width: 50px">
				</div>
				<br />

				<button type="submit">Ajouter au panier</button>

			</form>
		</div>
		<br /> <br />

		<div class="card facture">
			<h5>Dans votre panier :</h5>
			<br />

			<form action="commande" method="post">
				<table>
					<tr>
						<th>Article</th>
						<th>Quantité</th>
						<th>Prix total (&euro;)</th>
					</tr>
					<c:forEach var="i" items="${items}">
						<tr>
							<td><c:out value="${i.key.nom}" /></td>
							<td><c:out value="${i.value}" /></td>
							<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${i.value * i.key.prix}" /></td>
						</tr>
					</c:forEach>
				</table>
				<br />
				<h6 class="total">Total : <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${sessionScope.total}" /> &euro;</h6>
				<br />

				<button type="submit">Valider le panier</button>

			</form>
		</div>
		<br /> <br />
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>