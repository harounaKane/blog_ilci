
		<%@ include file="header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="fas fa-cogs"></i> Panneau d'administration</h2>
		<h4 class="text-info"><a href="${pageContext.request.contextPath}/Article?action=newArticle">Rédiger un nouvel article</a></h4>
	
		<table class="table table-striped table-hover">
			<tr class="table-dark">
				<th>Titre</th>
				<th>Article</th>
				<th>Auteur</th>
				<th>Catégorie</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${requestScope.articles}" var="article">
				<tr>
					<td> <c:out value="${article.titre}" /> </td>
					<td> <c:out value="${article.contenu.substring(0, 10)}" /> ...</td>
					<td> <c:out value="${article.auteur.nom}" /> </td>
					<td> <c:out value="${article.categorie.nom}" /> </td>
					<td>
						<a href="${pageContext.request.contextPath}/Article?action=update&id=${article.id}"><i class="fas fa-pencil"></i> </a>
						&nbsp; - &nbsp;
						<a href="${pageContext.request.contextPath}/Article?action=delete&id=${article.id}"><i class="fas fa-times"></i> </a>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	
		<%@ include file="footer.jsp" %>