
		<%@ include file="header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="fas fa-cogs"></i> Panneau d'administration</h2>
		<h4 class="text-info"><a href="${pageContext.request.contextPath}/Article?action=newArticle">R�diger un nouvel article</a></h4>
	
		<table class="table table-striped table-hover">
			<tr class="table-dark">
				<th>Titre</th>
				<th>Article</th>
				<th>Auteur</th>
				<th>Cat�gorie</th>
				<th>Action</th>
			</tr>
			
			<tr>
				<td>Informatique</td>
				<td>Contenu...</td>
				<td>Toto</td>
				<td>Html</td>
				<td>
					<a href="${pageContext.request.contextPath}/Article?action=update&id=1"><i class="fas fa-pencil"></i> </a>
					&nbsp; - &nbsp;
					<a href="${pageContext.request.contextPath}/Article?action=delete&id=1"><i class="fas fa-times"></i> </a>
				</td>
			</tr>
			
			<tr>
				<td>Informatique</td>
				<td>Contenu...</td>
				<td>Toto</td>
				<td>Html</td>
				<td>
					<a href="${pageContext.request.contextPath}/Article?action=update&id=2"><i class="fas fa-pencil"></i> </a>
					&nbsp; - &nbsp;
					<a href="${pageContext.request.contextPath}/Article?action=delete&id=2"><i class="fas fa-times"></i> </a>
				</td>
			</tr>
			
		</table>
	
		<%@ include file="footer.jsp" %>