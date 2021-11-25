
		<%@ include file="header.jsp" %>
		
		<h2 class="my-3 text-info"><i class="far fa-file-alt"></i> Article</h2>
		<h3>Informatique</h3>
		<p>
			Ready to pour… the Font Awesome 6 Beta!
			The next generation of the web’s favorite icon library + 
			toolkit is now available as a Beta release! Try out the Free version. 
			Subscribe to Font Awesome Pro to get even more! 
		</p>
		<div>
			Rédigé par Toto le 20/10/2021
		</div>
		
		<hr />
			<i class="fas fa-comment"></i> Rédigé par Tutu
			<p>contenu du commentaire de Tutu</p>
			
			<i class="fas fa-comment"></i> Rédigé par Tutu
			<p>contenu du commentaire de Tutu</p>
		<hr />
		
		<div class="d-flex justify-content-center">
			<di class="w-30 border border-info p-5">
				<h4><i class="fas fa-comment"></i> Nouveau commentaire</h4>
				<form action="${pageContext.request.contextPath}/Article" method="post">
				<input type="text" readonly name="id" value="${requestScope.id}" />
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