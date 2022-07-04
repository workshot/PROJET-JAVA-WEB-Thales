<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleCreateA.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>
	<div>
		<h2>Liste des articles</h2>
		<div>
			<form method="post" action="listeArticles">
				<table>
					<tr>
						<th>Catégorie</th>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prix (&euro;)</th>
						<th>Description</th>
						<th>URL image</th>
						<th>Supprimer ?</th>
					</tr>
					<c:forEach var="c" items="${applicationScope.categories}">
						<c:forEach var="a" items="${applicationScope.articles}">
							<c:if test="${a.idCategorie == c.key}">
								<tr>
									<td>${c.value}</td>
									<td>${a.id}</td>
									<td>${a.nom}</td>
									<td><fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2" value="${a.prix}" /></td>
									<td>${a.description}</td>
									<td>${a.img}</td>
									<td><button type="submit" name="supprimer" value="${a.id}"
											style="border: none;background:white;">
											<img src="assets/images/effacer50.png" alt="supprimer"
												width=25>
										</button></td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>