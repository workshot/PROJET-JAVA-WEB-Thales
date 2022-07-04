<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleArticles.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>

	<div class="container-fluid">

		<div class="cardTitle">
			<h2>Nouvel article</h2>
		</div>
		<br/><br/>
		<div class="card" style="margin:auto;height:300px;">

			<form action="nouvelArticle" method="post">
				<table>
					<tr>
						<td>Nom :</td>
						<td><input type="text" name="nom"></td>
					</tr>
					<tr>
						<td>Prix :</td>
						<td><input type="number" step="0.01" name="prix"></td>
					</tr>
					<td>Description :</td>
					<td><input type="text" name="description"></td>
					</tr>
					<tr>
						<td>URL image :</td>
						<td><input type="url" step="0.01" name="img"
							placeholder="https://monImage.jpg"></td>
					</tr>
					<tr>
						<td>Catégorie :</td>
						<td><select name="idCategorie">
								<option value='' disabled selected><p>choisir une
										catégorie...</p>
									<c:forEach var="c" items="${applicationScope.categories}">
										<option value="${c.key}" label="${c.value}">${c.value}</option>
									</c:forEach></td>
					</tr>
				</table>
				<br /> <br />
				<button type="submit" class="btn btn-success float-right">Enregistrer</button>
				<br /> <br />

			</form>
		</div>
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>