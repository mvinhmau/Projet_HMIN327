<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html >
<!-- src theme = https://bootsnipp.com/snippets/featured/register-page -->
<head>
    <meta charset="utf-8">
    <link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Website CSS style -->
	<link rel="stylesheet" type="text/css" href="assets/css/main.css">

	<!-- Website Font style -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
   <title>Connexion</title>
   
</head>

<body>
	<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Connexion Administrateur</h1>
	               		<hr />
	               	</div>
	            </div> 
	          
				<c:if test="${param.error != null}"> 
					<p>Utilisateur ou mot de passe incorrect(s)</p>
				</c:if>
				<c:url var="loginUrl" value="/login"/> 
				
				<div class="main-login main-center">
				
					<form class="form-horizontal" action="${loginUrl}" method="post">
					
						<div class="form-group">
							<p><label for="username" class="cols-sm-2 control-label">Utilisateur</label></p>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" id="username" name="identifiant" class="form-control" required/> 
								</div>
							</div>
						</div>
					
						<div class="form-group">
							<p><label for="password" class="cols-sm-2 control-label">Mot de passe:</label></p>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg"  aria-hidden="true"></i></span>
									<input type="password" id="password" name="motdepasse" class="form-control" required> 
								</div>
							</div>
						</div>
						
						<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
							
						<div class="form-group ">
						
							<input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="Connexion" />
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<br><br>
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<form action="/projet">
						<input class="btn btn-info" type="submit" value="Retour" />	
					</form>
				</div>
			</div>
		</div>	
	
</body>
</html>