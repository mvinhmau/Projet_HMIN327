<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Recherche Célébrités</title>
		<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	</head>
	
	<body>
		<h1 style="text-align:center; color:blue;"> Recherche de Célébrités </h1>
		<br>
		<a href="<c:url value ="/"/>"> 
		<span class="glyphicon glyphicon-home"></span> 
		Accueil </a>
		
		<!-- Forumulaire de Recherche -->
		<div class="row">
		
				<div class="col-sm-12">
				
					<f:form class="form-inline" modelAttribute="rechercheform"  method="post" action="rechercherCelebritesParNoms">
					
						<div class="col-sm-2 col-sm-offset-1">
							<f:input class="form-control" placeholder="Nom" type="text" path="nom"/>
						</div>
						<div class="col-sm-2 col-sm-offset-1">
							<f:input class="form-control" placeholder="Prenom" type="text" path="prenom"/>
						</div>
						<div class="col-sm-2 col-sm-offset-1">
							<button class="btn btn-primary"> <span class="glyphicon glyphicon-search"></span> Rechercher</button>
						</div>
					</f:form>
				</div>
			</div>
				
				<br> <br>
			<div class="row">
				<div class="col-sm-12">
				
					<f:form class="form-inline" modelAttribute="rechercheform2"  method="post" action="rechercherCelebritesParMonument">
					
						<div class="col-sm-2 col-sm-offset-1">
							<f:select class="form-control"  path="codeM">
									<option> Par Monument </option>
									<c:forEach  items="${monuments}" var="monument">
											<option value="${monument.codeM }">${monument.nomM}</option> 
									</c:forEach>
								</f:select>
						</div>
						
						<div class="col-sm-2 col-sm-offset-1">
							<button class="btn btn-primary"> <span class="glyphicon glyphicon-search"></span> Rechercher</button>
						</div>
					</f:form>
				</div>
						
		</div>
		<br><br><br>
		
		<!-- Liste des Celebrite -->
		<div class="panel-body">
		<c:if test="${ not empty celebriteForm.celebrites}"> 
			
			<table class="table table-striped table-bordered table-list" border="1" width="80%">
				<tr>
					<th> Nom</th>
					<th> Prenom </th>
					<th> Nationalité</th>
					<th> Epoque </th>
				</tr>
				<c:forEach  items="${celebriteForm.celebrites}" var="c">
					
					<tr>
						<td>${c.nom }</td>
						<td>${c.prenom }</td>
						<td>${c.nationalite }</td>
						<td>${c.epoque }</td>
						
					</tr>
				
				 
				</c:forEach>
			</table>
		</c:if> 
	</div>
		
		<br><br>
		<f:form action="RechercheInformation">
			<input class="btn btn-info" type="submit" value="Retour" />	
		</f:form>
		
		
		
	
	
	
	
</body>
		
		
	
	
</html>