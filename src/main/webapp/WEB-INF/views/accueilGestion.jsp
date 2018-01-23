<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Accueil Gestion </title>
		<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	</head>
	
	<body>
		<h1 style="text-align:center; color:blue"> Accueil Gestion des Donn�es  </h1>
		<br><br>
		 
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<f:form action="GestionMonuments">
						<input class="btn btn-primary btn-lg btn-block " type="submit" value="G�rer les Monuments" />	
					</f:form>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6">
					<f:form action="GestionCelebrites">
						<input class="btn btn-primary btn-lg btn-block " type="submit" value="G�rer les C�l�brit�s" />	
					</f:form>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6">
					<f:form action="GestionAssociations">
						<input class="btn btn-primary btn-lg btn-block " type="submit" value="G�rer les Relations" />	
					</f:form>
				</div>
			</div>
			
		
		<br><br>
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<f:form action="/projet">
						<input class="btn btn-info" type="submit" value="Retour" />	
					</f:form>
				</div>
			</div>
		</div>
	
	</body>
	
</html>