<header>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<a class="navbar-brand" href="#">Bijoux</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/home">ACCUEIL
						<span class="sr-only">(current)</span>
				</a></li>
				
			</ul>
			
			<button type="button" class="btn btn-success mr-1" onclick="displayAuth()">Connexion</button>
			<button type="button" class="btn btn-secondary"
				onclick="displayInsc()">Inscription</button>
		</div>
	</nav>
	<%@ include file="formConnexion.jsp"%>
	<%@ include file="formInscription.jsp"%>
	<%@ include file="popupActionValide.jsp" %>
</header>
