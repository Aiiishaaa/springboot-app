<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1
		style="text-align: center; background: linear-gradient(blue, pink); padding-top: 50px; height: 120px;">
		HOME</h1>
	<p>Hey ${ perso.nom }</p>
	<h1>Liste de personnes</h1>
	<c:forEach items="${ personnes }" var="personne">
		<table style ="">
			<tr>
				<td> Nom : <c:out value="${ personne.nom }">
					</c:out></td>
				<td>Prénom :<c:out value="${ personne.prenom }"></c:out></td>
				<td>Age :<c:out value=" ${ personne.age }"></c:out> ans.</td>
			<tr>
		</table>
	</c:forEach>


	<h1>Paramétres de la requête</h1>
	<p>Bonjour ${ nom } !</p>


	<h1>Variable de chemin</h1>
	<p>Coucou ${ nom } !</p>



</body>
</html>