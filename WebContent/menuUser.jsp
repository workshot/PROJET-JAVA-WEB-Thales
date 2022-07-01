<header>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			<a class="navbar-brand" href="#">Bijoux</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/home">ACCUEIL
						<span class="sr-only">(current)</span>
				</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/Bijouxlist">Bijoux cat</a></li>
			</ul>
			
			<div class="dropdown">
				<i class=""></i>
  				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    				Mon compte
  				</button>
  				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    				<a class="dropdown-item" href="${pageContext.request.contextPath}/Panier">Mon Panier</a>
    				<div class="dropdown-divider"></div>
    				<button class="btn dropdown-item" type="button" onclick="deconnecter()">Déconnexion</button>
  				</div>
			</div>
		</div>
	</nav>
	<%@ include file="popupActionValide.jsp" %>
</header>