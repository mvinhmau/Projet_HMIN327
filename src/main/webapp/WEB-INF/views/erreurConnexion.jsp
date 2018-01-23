<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
 <link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>Erreur de Connexion</title>
</head>
<body>
	<h1 style="text-align:center; color:blue;"> Erreur de Connexion</h1>
	<br>
	<a href="<c:url value ="/"/>"> 
		<span class="glyphicon glyphicon-home"></span> 
		Accueil </a>
	<br>
	<br>
	<div class="row">
			<div class="col-sm-8">
				<div class="col-sm-10 col-sm-offset-2">
				<h5 style="color:red;"> L'identifiant ou le mot de passe saisi est incorrect</h5>
				</div>
			</div>
	</div>
	<br>
	<br>
	<br>
	<div class="row">
		<div class="col-sm-2 col-sm-offset-0 ">
			<a class="btn btn-info" href="<c:url  value="/connexion"/>"> 
			Retour à la Connexion 
			</a>
	
		</div>
	</div>
	
	
</body>