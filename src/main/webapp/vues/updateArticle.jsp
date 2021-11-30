
		<%@ include file="header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="fas fa-cogs"></i> Panneau d'administration</h2>
		<h4>Editer un article</h4>
		
		<div class="d-flex justify-content-center">
			<di class="w-30 border border-info p-5">
				<h4 class="text-info"><i class="fas fa-file"></i> Article</h4>
				<form class="" action="${pageContext.request.contextPath}/Article" method="post">
				<input type="hidden" name="id" value="${requestScope.article.id}"/>
					<div class="form-group">
						<label for="">Titre</label>
						<input type="text" value="${requestScope.article.titre}" name="titre" class="form-control" />
					</div>
					<div class="form-group">
						<label for="">Contenu</label>
						<textarea name="contenu"cols="30" rows="10" class="form-control">${requestScope.article.contenu}</textarea>
					</div>
					<div class="text-center">
						<input type="submit" name="action" value="Modiffier" class="btn btn-success mt-3" />
						<input type="reset" class="btn btn-danger mt-3" />
					</div>
				</form>
			</di>
		</div>

		<%@ include file="footer.jsp" %>