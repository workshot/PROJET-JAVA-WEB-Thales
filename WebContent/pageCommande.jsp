<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleCommande.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>

	<div class="container-fluid">

		<div class="cardTitle" style="margin: auto;">
			<h2>
				Bienvenue
				<c:out value="${sessionScope.USER_CONNECTED_SESSION.nom}" />
				!
			</h2><br/>
			<h3 style="text-align:center;">Préparez votre commande en ligne</h3>
		</div>
		<br />

		<div class="container">

			<div class="card">
				<h5>Faites votre choix parmi nos articles :</h5>

				<form action="commande" method="get">

					<select name="art">
						<option value='' disabled selected><p>Sélectionnez un
								article...</p>
						</option>
						<c:forEach var="c" items="${applicationScope.categories}">
							<optgroup label="${c.value}">

								<c:forEach var="a" items="${applicationScope.articles}">
									<c:if test="${a.idCategorie == c.key}">
										<option value='<c:out value="${a.id}"/>'>${a.nom}(
											<fmt:formatNumber type="number" minFractionDigits="2"
												maxFractionDigits="2" value="${a.prix}" /> &euro;)
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

					<button type="submit" class="btn btn-info">Ajouter au
						panier</button>

				</form>
			</div>

			<div class="card">
				<h5>Dans votre panier :</h5>

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
								<td><fmt:formatNumber type="number" minFractionDigits="2"
										maxFractionDigits="2" value="${i.value * i.key.prix}" /></td>
							</tr>
						</c:forEach>
					</table>
					<br />
					<h6 class="total">
						Total :
						<fmt:formatNumber type="number" minFractionDigits="2"
							maxFractionDigits="2" value="${sessionScope.total}" />
						&euro;
					</h6>
					<br />
					<button type="submit" name="empty" class="btn btn-danger float-left">Vider le
						panier</button>
					<button type="submit" class="btn btn-success float-right">Valider
						le panier</button>



				</form>
			</div>
		</div>
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>