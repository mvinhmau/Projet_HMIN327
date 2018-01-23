<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<title>Calcul de distance</title>
<meta charset="utf-8">
<link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet"> 


   <script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDq6s_xfhiOT71adzOkO91DBiQJbhKzHh8">

</script> 
    
    
</head>
<body>
	<h2 style="text-align:center; color:blue;"> Calcul de distance </h2>
	<br>
		<a href="<c:url value ="/"/>"> 
		<span class="glyphicon glyphicon-home"></span> 
		Accueil </a>
		
	<div class="row">
		<div class="col-sm-12">
		
			<f:form modelAttribute="calculDistanceForm" method="post" action="CalculerDistanceEntreDeuxPoints">
				
				<!--  Monument 1 -->
				<div class="col-sm-2 col-sm-offset-1">
					
					<f:select class="form-control" path="codeM1">
						<option> Monument 1</option>
						<c:forEach  items="${monuments}" var="monument">
								<option value="${monument.codeM }">${monument.nomM} </option> 
								</c:forEach>
					</f:select>
					
				</div>
				<div class="col-sm-2 col-sm-offset-1">
					<f:select class="form-control" path="codeM2">
						<option> Monument 2</option>
						<c:forEach  items="${monuments}" var="monument">
								<option value="${monument.codeM }">${monument.nomM} </option> 
								</c:forEach>
					</f:select>
				</div>
				<div class="col-sm-2 col-sm-offset-1">
					<button class="btn btn-primary"> <span class="glyphicon glyphicon-time"></span> Calculer</button>
				</div>
			</f:form>
		</div>
	</div>
	<br>
	<br>
	<div class="col-sm-14 col-sm-offset-1">
	<c:if test="${distance!=null}"> 
		<h4> La distance entre ${nom1} et ${nom2} est de ${distance} kilomètres. </h4>
	</c:if>
	</div>
	
	<br><br>
	<div id="map"></div>
	
	
	<br><br>
		
		<f:form action="/projet">
			<input class="btn btn-info" type="submit" value="Retour" />	
		</f:form>
</body>
</html>