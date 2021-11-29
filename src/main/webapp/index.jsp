
		<%@ include file="vues/header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="fas fa-home"></i> Accueil</h2>
		<ul class="list-group">
			
			<c:forEach items="${requestScope.articles}" var="article">
				<li class="list-group-item text-info">
				<a href="${pageContext.request.contextPath}/Article?action=articleClicked&id=${article.id}">
					<i class="fas fa-hand-point-right"></i> ${article.titre}
				</a>
				</li>
				<li class="list-group-item">${article.contenu.substring(0, 15)} ...</li>
				<li class="list-group-item">Rédigé par <strong>${article.auteur.nom} le 20/10/2021</strong></li>
			</c:forEach>			
	
		</ul>
	
		<%@ include file="vues/footer.jsp" %>