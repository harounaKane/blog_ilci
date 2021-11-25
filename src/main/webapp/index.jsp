
		<%@ include file="vues/header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="fas fa-home"></i> Accueil</h2>
		<ul class="list-group">
			<li class="list-group-item text-info">
				<a href="${pageContext.request.contextPath}/Article?action=articleClicked&id=51">
					<i class="fas fa-hand-point-right"></i> Informatique
				</a>
			</li>
			<li class="list-group-item">le contenu ...</li>
			<li class="list-group-item">Rédigé par <strong>Toto le 20/10/2021</strong></li>
			
			<li class="list-group-item text-info">
				<a href="${pageContext.request.contextPath}/Article?action=articleClicked&id=2">
					<i class="fas fa-hand-point-right"></i> Electronique
				</a>
			</li>
			<li class="list-group-item">le contenu</li>
			<li class="list-group-item">rédigé par <strong>Tata le 20/10/2021</strong></li>
		</ul>
	
		<%@ include file="vues/footer.jsp" %>