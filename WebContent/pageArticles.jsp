<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/css/styleArticles.css">
</head>
<body>
	<%@ include file="/menu.jsp"%>
	<div>
		<h2>Liste des articles</h2>
		<div>

			<c:forEach var="c" items="${applicationScope.categories}">

				<div class="categTitle">
					<c:out value="${c.value}" />
				</div>

				<div class="listeArticles">
					<c:forEach var="a" items="${applicationScope.articles}">
						<c:if test="${a.idCategorie == c.key}">
							<div class="card open" name="${a.id}">
								<h2>${a.nom}</h2>
								<img src="${a.img}" alt="${a.nom}">
								<div class="prix">
									<p>
										prix TTC :
										<fmt:formatNumber type="number" minFractionDigits="2"
											maxFractionDigits="2" value="${a.prix}" />
										&euro;
									</p>
								</div>
							</div>
							<div class="card popup close" id="${a.id}">
								<h2>${a.nom}</h2>
								<p>${a.description}</p>
							</div>
						</c:if>
					</c:forEach>
				</div>

			</c:forEach>
		</div>
	</div>
	<%@ include file="/footerAccueil.jsp"%>
</body>
<script>
	$(document).ready(function() {
		$(".open").on("click", function() {
			var id = $(this).attr('name');
			if ($(".popup[id=" + id + "]").hasClass("active")) {
				$(".popup[id=" + id + "]").removeClass("active");
			} else {
				$(".popup[id=" + id + "]").addClass("active");
			}
		});
		$(".close").on("click", function() {
			var id = $(this).attr('id');
			$(".popup[id=" + id + "]").removeClass("active");
		});
	});
</script>
</html>