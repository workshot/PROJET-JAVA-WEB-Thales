<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/header.jsp"%>
<body>
	<%@ include file="/menu.jsp"%>

	<h2>
		Félicitations
		<c:out value="${sessionScope.client}" />
		!
	</h2>

	<h3>Votre commande est validée.</h3>
	<br />
	<h3>
		Le montant total est de
		<fmt:formatNumber type="number" minFractionDigits="2"
			maxFractionDigits="2" value="${sessionScope.total}" /> &euro;.
	</h3>


	<%@ include file="/footerAccueil.jsp"%>
</body>
</html>