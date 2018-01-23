<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>Recherche Lieux</title>
		<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	</head>
	
	<body>
		<h1 style="text-align:center; color:blue;"> Recherche d'information sur des Communes </h1>
		<br>
		<a href="<c:url value ="/"/>"> 
		<span class="glyphicon glyphicon-home"></span> 
		Accueil </a>
		
		<!-- Forumulaire de Recherche -->
		<div class="row">
				<div class="col-sm-12 col-sm-offset-1">
				
					<f:form class="form-inline" modelAttribute="rechercheform" method="post" action="rechercherLieuxParDep">
					<div class="col-sm-2 col-sm-offset-1">
							<f:select class="form-control" path="nomDep">
								<option>  Liste des Departements </option>
								<c:forEach  items="${departements}" var="dep">
										<option value="${dep.nomDep }">${dep.numDep} - ${dep.nomDep} </option> 
								</c:forEach>
							</f:select>
						</div>
						<div class="col-sm-1 col-sm-offset-1"> <button class="btn btn-primary" ><span class="glyphicon glyphicon-search"></span> Rechercher</button> </div>
					</f:form>
						
		</div>
		<br>
		<br>
		<!-- Liste des Lieux trouves -->
		<div class="panel-body">
		<c:if test="${ not empty lieuForm.lieux}"> 
			
			<table class="table table-striped table-bordered table-list" border="1" width="80%">
				<tr>
				
					<th> code Insee</th>
					<th> nom Commune</th>
					<th> latitude</th>
					<th> longitude </th>
				</tr>
				<c:forEach  items="${lieuForm.lieux}" var="l">
					
					<tr>
						<td>${l.codeInsee }</td>
						<td>${l.nomCom}</td>
						<td>${l.latitude }</td>
						<td>${l.longitude }</td>
						
					</tr>
				
				 
				</c:forEach>
			</table>
		</c:if> 
		</div>
		
		<br><br>
		<div class="col-sm-1 col-sm-offset-0">
		<f:form action="RechercheInformation">
			<input class="btn btn-info " type="submit" value="Retour" />	
		</f:form>
		</div>
		
		
		
	</body>
	
</html>