<header>
	<!-- Fixed navbar -->
	
        <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
            <div class="container">
                <a class="navbar-brand text-uppercase fw-bold d-lg-none" href="index.html">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto">
                     <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="accueil.jsp">Accueil</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="pageArticles.jsp">Bijoux</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="catBijoux2.jsp">Catégorie</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="about.jsp">About</a></li>
                        <li class="nav-item px-lg-3"><a class="nav-link text-uppercase" href="store.jsp">Magasin</a></li>
						
                    </ul>
                    
                    <button type="button" class="btn btn-primary mr-1" onclick="displayAuth()">Connexion</button>
			<button type="button" class="btn btn-secondary"
				onclick="displayInsc()">Inscription</button>
                </div>
            </div>
        </nav>

	<%@ include file="formConnexion.jsp"%>
	<%@ include file="formInscription.jsp"%>
	<%@ include file="popupActionValide.jsp" %>
</header>
