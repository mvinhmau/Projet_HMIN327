<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>Recherche Monument</title>
		<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	</head>
	
	<body>
		<h1 style="text-align:center; color:blue;"> Recherche de Monuments </h1>
		<br>
		<a href="<c:url value ="/"/>"> 
		<span class="glyphicon glyphicon-home"></span> 
		Accueil </a>
		
		
		<div>
			<div class="row">
				<div class="col-sm-12">
					
					<div class="col">
					<f:form  modelAttribute="rechercheform" method="post" action="rechercherMonumentsParNom">
						
						<div class="col-sm-2 col-sm-offset-1"> <f:input  class="form-control" placeholder="Par Nom" type="text" path="nomM"/> </div>
						<div class="col-sm-1 col-sm-offset-1"> <button class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Rechercher</button> </div>
					</f:form>
					</div>
					
					<div class="col">
						<f:form class="form-inline"  modelAttribute="rechercheform" method="post" action="rechercherMonumentsParType">
							<div class="col-sm-2 col-sm-offset-1">
								<f:select class="form-control"  path="type">
									<option> Par Type </option>
									<c:forEach  items="${types}" var="type">
											<option value="${type }"> ${type}</option> 
									</c:forEach>
								</f:select>
							</div>
							<div class="col-sm-1 col-sm-offset-1"> <button class="btn btn-primary" > <span class="glyphicon glyphicon-search"></span> Rechercher</button> </div>
						</f:form>
					</div>
					
				</div>
			</div>
			<br>
			
			<div class="row">
				<div class="col-sm-12">
					<div class="col">
						<f:form class="form-inline" modelAttribute="rechercheform" method="post" action="rechercherMonumentsParLieu">
						
							<div class="col-sm-2 col-sm-offset-1">
								<f:select class="form-control"  path="nomLieu">
									<option> Par Lieu </option>
									<c:forEach  items="${communes}" var="commune">
											<option value="${commune.nomCom }"> ${commune.nomCom}</option> 
									</c:forEach>
								</f:select>
							</div>
							
							<div class="col-sm-1 col-sm-offset-1"> <button class="btn btn-primary" > <span class="glyphicon glyphicon-search"></span> Rechercher</button> </div>
						</f:form>
					</div>
					
					<div class="col">
						<f:form class="form-inline" modelAttribute="rechercheform" method="post" action="rechercherMonumentsParDep">
						<div class="col-sm-2 col-sm-offset-1">
							<f:select class="form-control" path="nomDep">
								<option> Par Departement </option>
								<c:forEach  items="${departements}" var="dep">
										<option value="${dep.nomDep }">${dep.numDep} - ${dep.nomDep} </option> 
								</c:forEach>
							</f:select>
						</div>
						<div class="col-sm-1 col-sm-offset-1"> <button class="btn btn-primary" > <span class="glyphicon glyphicon-search"></span> Rechercher</button> </div>
						</f:form>
					</div>
				</div>
			</div>
			<br>
				
		</div>
		
		<!-- Liste des Monuments -->
		<div class="panel-body">
			<c:if test="${not empty monumentForm.monuments}">
				<table class="table table-striped table-bordered table-list" border="1" width="80%">
					<tr>
						<th> Code </th>
						<th> Nom</th>
						<th> Propriétaire </th>
						<th> Type</th>
						<th> Longitude </th>
						<th> Latitude</th>
					</tr>
					<c:forEach  items="${monumentForm.monuments}" var="m">
						
						<tr>
							<td>${m.codeM }</td>
							<td>${m.nomM }</td>
							<td>${m.proprietaire }</td>
							<td>${m.typeMonument }</td>
							<td>${m.longitude }</td>
							<td>${m.latitude }</td>
							
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