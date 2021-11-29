
		<%@ include file="header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="far fa-file-alt"></i> Article</h2>
		<h3>${requestScope.article.titre}</h3>
		<p>
			${requestScope.article.contenu}
		</p>
		<div>
			Rédigé par ${requestScope.article.auteur.nom} le 20/10/2021
		</div>
		
		<c:if test="${!empty commentaires}">
			<hr />
			<c:forEach items="${requestScope.commentaires}" var="commentaire">
				<i class="fas fa-comment"></i> Rédigé par ${commentaire.pseudo}
				<p>${commentaire.contenu}</p>
			</c:forEach>
			<hr />
		</c:if>
		
		<div class="d-flex justify-content-center">
			<di class="w-30 border border-info p-5">
				<h4><i class="fas fa-comment"></i> Nouveau commentaire</h4>
				<form action="${pageContext.request.contextPath}/Article" method="post">
				<input type="hidden" readonly name="id" value="${requestScope.article.id}" />
					<div class="form-group">
						<label for="">Pseudo</label>
						<input type="text" name="pseudo" class="form-control" />
					</div>
					<div class="form-group">
						<label for="">Commentaire</label>
						<textarea name="comment" cols="30" rows="10" class="form-control"></textarea>
					</div>
					<div class="text-center">
						<input type="submit" name="action" value="Commenter" class="btn btn-success mt-3" />
						<input type="reset" class="btn btn-danger mt-3" />
					</div>
				</form>
			</di>
		</div>

		<%@ include file="footer.jsp" %>