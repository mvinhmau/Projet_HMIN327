<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html">
<meta charset="UTF-8">
<title>Gestion des Relations </title>
<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
</head>

<body>
	<h1 style="text-align:center; color:blue;"> Gestion des Relations entre les Célébrités et les Monuments</h1>
	<br>
		<a href="<c:url value ="/"/>"> 
			<span class="glyphicon glyphicon-home"></span> 
			Accueil 
		</a>
		
	<!-- Formulaire Choix Relations -->
	<div>
		<div class="row">
			<div class="col-sm-12">
				
					<f:form modelAttribute="AssociationForm" 
							action="enregistrerAssociation" method="post">
						<div class="row">
							<div class="col-sm-4 col-sm-offset-1">
								<h3> Formulaire Gestion des Associations </h3>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-2 col-sm-offset-1">
									<f:select class="form-control" path="numM">
										<c:if test="${AssociationForm.numM ==null}">
										<option >Monument</option>
										 </c:if>
										<c:if test="${AssociationForm.numM !=null}">
										<option value="${AssociationForm.numM}"> ${AssociationForm.nomM }</option>
										 </c:if>
										<c:forEach  items="${monuments}" var="m">
											<option value="${m.codeM }"> ${m.nomM}</option> 
										</c:forEach>
									</f:select>
							</div>
							<div class="col-sm-2 col-sm-offset-1">
									<f:select class="form-control" path="numC">
										<c:if test="${AssociationForm.numC ==null}">
										<option >Celebrite</option>
										 </c:if>
										<c:if test="${AssociationForm.numC !=null}">
										<option value="${AssociationForm.numC}"> ${AssociationForm.nomC }</option>
										 </c:if>
										<c:forEach  items="${celebrites}" var="c">
											<option value="${c.numCelebrite }"> ${c.nom} ${c.prenom}</option> 
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
		
	
		
		<!-- Liste des Associations -->
		<div class="panel-body">
			<table class="table table-striped table-bordered table-list" border="1" >
				<tr>
					<th> Code Monument </th>
					<th> Monument</th>
					<th> Num Célébrité </th>
					<th> Célébrité</th>
					<th> <span class="glyphicon glyphicon-cog"></span> </th>
					
					
				</tr>
				<c:forEach  items="${associations}" var="a">
					<tr>
						<td>${a.numM }</td>
						<td>${a.nomM }</td>
						<td>${a.numC }</td>
						<td>${a.nomC}</td>
						
						<td> 
							<a href="<c:url value = "/supprimerAssociation/${a.numM}/${a.numC}"/>" >
								<span class="glyphicon glyphicon-trash"> </span> 
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