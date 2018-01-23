<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>HomeRechercheInformation</title>
		<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	</head>
	
	<body>
		<h1> Que souhaitez vous rechercher : </h1>
		<br><br>
		 
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<f:form action="RechercheMonument">
						<input class="btn btn-primary btn-lg btn-block " type="submit" value="Rechercher un Monument" />	
					</f:form>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6">
					<f:form action="RechercheCelebrite">
						<input class="btn btn-primary btn-lg btn-block " type="submit" value="Rechercher une Célébrité" />	
					</f:form>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6">
					<f:form action="RechercheLieu">
						<input class="btn btn-primary btn-lg btn-block " type="submit" value="Rechercher un Lieu" />	
					</f:form>
				</div>
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