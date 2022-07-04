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
				Félicitations
				<c:out value="${sessionScope.USER_CONNECTED_SESSION.nom}" />
				!
			</h2>
		</div>

		<div class="card facture" style="max-width: 600px;">
			<h3>Votre commande est validée.</h3>
			<br />
			<h3>
				Le montant total est de
				<fmt:formatNumber type="number" minFractionDigits="2"
					maxFractionDigits="2" value="${sessionScope.total}" />
				&euro;.
			</h3>
			<br/>
			<img src="assets/images/intro.jpg" alt="bijoux">
		</div>
		
	</div>
	
	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>