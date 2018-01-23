<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html">
<meta charset="UTF-8">
<title>Gestion des Celebrites</title>
<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
</head>

<body>
	<h1 style="text-align:center; color:blue;"> Gestion des Célébrités</h1>
	<br>
		<a href="<c:url value ="/"/>"> 
			<span class="glyphicon glyphicon-home"></span> 
			Accueil 
		</a>
		
	<!-- Formulaire Saisi Célébrités -->
	<div>
		<div class="row">
			<div class="col-sm-12">
				
					<f:form modelAttribute="celebriteForm" 
							action="enregistrerCelebrite" method="post">
						<div class="row">
							<div class="col-sm-4 col-sm-offset-1">
								<h3> Formulaire de Saisie </h3>
							</div>
						</div>
						<div class="row">
								<c:if test="${celebriteForm.numCelebrite!=0}">
									<div class="col-sm-2 col-sm-offset-1">
										<f:input class="form-control" placeholder="Num Célébrité"  path="numCelebrite" value="${celebriteForm.numCelebrite}"/>
									</div> 
								</c:if>
								
						</div>
						
						<br>
						<div class="row">
							<div class="col-sm-2 col-sm-offset-1">
									<f:input class="form-control" placeholder="Nom " type="text" path="nom"/>
							</div>
							<div class="col-sm-2 col-sm-offset-1">
									<f:input class="form-control" placeholder="Prenom" type="text" path="prenom"/>
							</div>
						</div>
						<br>
						
						<div class="row">
							<div class="col-sm-2 col-sm-offset-1">
								 <f:select class="form-control" path="nationalite">
										<c:if test="${celebriteForm.nationalite ==null}">
										<option >Nationalite</option>
										 </c:if>
										<c:if test="${celebriteForm.nationalite !=null}">
										<option value="${celebriteForm.nationalite }"> ${celebriteForm.nationalite }</option>
										 </c:if>
										<c:forEach  items="${nationalites}" var="nat">
											<option value="${nat }"> ${nat}</option> 
										</c:forEach>
									</f:select>
								</div>
								
								<div class="col-sm-2 col-sm-offset-1">
								 <f:select class="form-control" path="epoque">
										<c:if test="${celebriteForm.epoque ==null}">
										<option >Epoque</option>
										 </c:if>
										<c:if test="${celebriteForm.epoque !=null}">
										<option value="${celebriteForm.epoque }"> ${celebriteForm.epoque }</option>
										 </c:if>
										<c:forEach  items="${epoques}" var="e">
											<option value="${e}"> ${e}</option> 
										</c:forEach>
									</f:select>
								</div>
						</div>
							<br>
							
							
							
							
							<div class="row">
								<div class="col-sm-2 col-sm-offset-1">
									<button class="btn btn-primary" > <span class="glyphicon glyphicon-floppy-disk"></span> Sauvegarder</button>
										
									 
								</div>
							</div>
				</f:form>
				</div>
			</div>
		</div>
		<br>
		
		
		
		
		
		
		
		
		
		<!-- Liste des Celebrites -->
		<div class="panel-body">
			<table class="table table-striped table-bordered table-list" border="1" >
				<tr>
					<th> Num </th>
					<th> Nom</th>
					<th> Prénom </th>
					<th> Nationalité</th>
					<th> Epoque </th>
					<th> <span class="glyphicon glyphicon-cog"></span> </th>
					
					
				</tr>
				<c:forEach  items="${celebrites}" var="c">
					<tr>
						<td>${c.numCelebrite }</td>
						<td>${c.nom }</td>
						<td>${c.prenom }</td>
						<td>${c.nationalite }</td>
						<td>${c.epoque}</td>
						
						<td> 
							<a href="<c:url value = "/supprimerCelebrite/${c.numCelebrite}"/>" >
								<span class="glyphicon glyphicon-trash"> </span> 
							</a>
						 	<a href="<c:url value = "/miseAJourCelebrite/${c.numCelebrite }"/>">
						 		<span class="glyphicon glyphicon-pencil"></span>  
						 	</a>
						 </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	
	
	
	<!-- Redirection -->
		<br>
			<a class="btn btn-info" href="<c:url value ="/GestionDesDonnees"/>"> 
			 Retour
		</a>
		<br>
		
	</body>
</html>