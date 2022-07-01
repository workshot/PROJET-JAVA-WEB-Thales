<div class="album py-5 bg-light">
	<div class="container">
		<h2>Tous les Bijoux</h2>
		<div class="row">
			<c:forEach begin="0" end="8" var="film" items="${articles}">
				<div class="col-md-4">
					<div class="card mb-4 box-shadow">
						<a href="${pageContext.request.contextPath}/article/${article.idArticle}"><img
							class="card-img-top"
							src="https://image.tmdb.org/t/p/w500/${article.imagePath}"
							alt="Card image cap"> </a>
						<div class="card-body">
							<p class="card-text">${article.titre}</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-success">Ajouter</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>