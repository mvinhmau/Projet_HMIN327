<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
	 	<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">
		<title>Accueil</title>
	</head>
	
	
<body>
	<div class="row">
			<div class="col-sm-8">
			
				<div class="col-sm-2 col-sm-offset-0 ">
					<c:if test="${pageContext.request.userPrincipal.name == null}">
					 	<!-- Bouton Connexion -->
					 	<a class="btn btn-secondary btn-lg" href="<c:url  value="/connexion"/>"> 
							<span class="glyphicon glyphicon-lock"></span> 
								Connexion 
						</a>
					</c:if>
				</div>
						
				<div class="col-sm-1 col-sm-offset-0 ">
					 <c:if test="${pageContext.request.userPrincipal.name != null}">
					 	<!-- Bouton Deconnexion -->
							 <c:url var="logoutUrl" value="/deconnexion"/>
								<form action="${logoutUrl}" method="post">
									<button class="btn btn-secondary btn-lg" style="color:#428bca;" > <span class="glyphicon glyphicon-lock"></span> Deconnexion</button>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</form>					 
				      </c:if>
			  	</div>
			  	
        	</div>
        </div>
        
        <br>
        
		<h1 style="font-weight: bold; text-align:center;"> BIENVENUE </h1>
	
	
	
	<br>
	<br>	
	<br>
	
	<div class="container">
		
	
	
	<br>
	
		<div class="row">
			<div class="col-sm-6">
				<f:form action="RechercheInformation">
					<input class="btn btn-primary btn-lg btn-block" type="submit" value="Recherche d'information" />
					
				</f:form>
			</div>
		</div>
		<br>
		
		<div class="row">
			<div class="col-sm-6">
				<f:form action="CalculeDeDistance">
					<input class="btn btn-primary btn-lg btn-block" type="submit" value="Calcul de distance" />
					
				</f:form>
			</div>
		</div>
		<br>
		
		<div class="row">
			<div class="col-sm-6">
				<f:form action="GestionDesDonnees">
					<input class="btn btn-primary btn-lg btn-block" type="submit" value="Gestion" />
					
				</f:form>
			</div>
		</div>
	</div>
	<br>
	

   


	
</body>
</html>
