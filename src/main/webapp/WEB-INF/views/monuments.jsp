<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html">
<meta charset="UTF-8">
<title>Gestion des Monuments</title>
<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
</head>

<body>
	<h1 style="text-align:center; color:blue"> Gestion des Monuments</h1>
	<br>
		<a href="<c:url value ="/"/>"> 
			<span class="glyphicon glyphicon-home"></span> 
			Accueil 
		</a>
		
	<!-- Formulaire Saisi Monument -->
	<div>
		<div class="row">
			<div class="col-sm-12">
				
					<f:form modelAttribute="monumentForm" 
							action="enregistrerMonument" method="post">
						<div class="row">
							<div class="col-sm-4 col-sm-offset-1">
								<h3> Formulaire de Saisie </h3>
							</div>
						</div>
						<div class="row">
								<c:if test="${monumentForm.codeM!=0}">
									<div class="col-sm-2 col-sm-offset-1">
										<f:input class="form-control" placeholder="Code Monument"  path="codeM" value="${monumentForm.codeM}"/>
									</div> 
								</c:if>
								<div class="col-sm-2 col-sm-offset-1">
									<f:input class="form-control" placeholder="Nom Monument" type="text" path="nomM"/>
								</div>
						</div>
						
						<br>
						
						<div class="row">
							<div class="col-sm-2 col-sm-offset-1">
								 <f:select class="form-control" path="type">
								 	<c:if test="${monumentForm.type ==null}">
										<option>Type </option>
									</c:if>
										<c:if test="${monumentForm.type !=null}">
										<option value="${monumentForm.type }"> ${monumentForm.type}</option>
										 </c:if>
										<c:forEach  items="${types}" var="type">
											<option value="${type }"> ${type}</option> 
										</c:forEach>
									</f:select>
								</div>
								<div class="col-sm-2 col-sm-offset-1">
									<f:input class="form-control" placeholder="Proprietaire" type="text" path="nomProp"/>
								</div>
							</div>
							
							<br>
							
							<div class="row">
								<div class="col-sm-2 col-sm-offset-1"> 
									<f:select class="form-control" path="codeInsee">
										<c:if test="${lieu == null }">
										<option> Lieu </option>
										</c:if>
										<c:if test="${lieu != null }">
										<option value="${lieu.codeInsee }"> ${lieu.nomCom }</option>
										 </c:if>
										<c:forEach  items="${lieux}" var="l">
											<option value="${l.codeInsee }"> ${l.nomCom }</option> 
										</c:forEach>
									</f:select>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-2 col-sm-offset-1">
									<label> Latitude </label>
									<f:input class="form-control"  type="text" path="latitude"/>
								</div>
								<div class="col-sm-2 col-sm-offset-1">
									<label> Longitude </label>
									<f:input class="form-control"  type="text" path="longitude"/>
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
	
		
		<!-- Liste des Monuments -->
		<div class="panel-body">
			<table class="table table-striped table-bordered table-list" border="1" >
				<tr>
					<th> Code </th>
					<th> Nom</th>
					<th> Propriétaire </th>
					<th> Type</th>
					<th> Lieu </th>
					<th> Latitude</th>
					<th> Longitude </th>
					<th> <span class="glyphicon glyphicon-cog"></span> </th>
					
					
				</tr>
				<c:forEach  items="${monuments}" var="m">
					<tr>
						<td>${m.codeM }</td>
						<td>${m.nomM }</td>
						<td>${m.proprietaire }</td>
						<td>${m.typeMonument }</td>
						<td>${m.localite.nomCom }</td>
						<td>${m.latitude }</td>
						<td>${m.longitude }</td>
						
						<td> 
							<a href="<c:url value = "/supprimerMonument/${m.codeM }"/>" >
								<span class="glyphicon glyphicon-trash"> </span> 
							</a>
						 	<a href="<c:url value = "/miseAJourMonument/${m.codeM }"/>">
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