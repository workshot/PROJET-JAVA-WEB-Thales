<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>facture</title>
</head>
<body>

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
</body>
</html>