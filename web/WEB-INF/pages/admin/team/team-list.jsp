<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des equipes</title>
</head>
<body>
	<h2>Liste des equipes :</h2>
	<table border="1" width="80%">
		<tr>
			<th>id</th>
			<th>description</th>
		</tr>
		<c:forEach items="${teams}" var="team">
			<tr>
				<td>${team.id}</td>
				
				<td><a href="edit.html?id=${team.id}">éditer</a> <a
					href="delete.html?id=${team.id}">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<a href="new.html">Nouveau</a>
	<br />
	<br />
	<a href="/PetitDejeuner/admin/team/list.html">List
	</a>


</body>
</html>