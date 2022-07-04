<header>
	<!-- Fixed navbar -->
	 <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
            <div class="container">
                <a class="navbar-brand text-uppercase fw-bold d-lg-none" href="index.html">Bijoux</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto">
                     <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="accueil.jsp">Accueil</a></li>
                        
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="catBijoux2.jsp">Cat&eacute;gorie</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="about.jsp">About</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="store.jsp">Magasin</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="pageArticles.jsp">Tous les bijoux</a></li>
						
                    </ul>
	
			
			<div class="dropdown">
				<i class=""></i>
  				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    				Mon compte
  				</button>
  				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    				<a class="dropdown-item" href="${pageContext.request.contextPath}/commande">Mon Panier</a>
    				<div class="dropdown-divider"></div>
    				<button id ="btndeconnection"class="btn dropdown-item" type="button" onclick="window.location.href = 'ServletLogout'">Déconnexion</button>
  				</div>
			</div>
		</div>
	</nav>
	<%@ include file="popupActionValide.jsp" %>
</header>
