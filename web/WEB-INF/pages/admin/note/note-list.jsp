<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des appréciations</title>
</head>
<body>
	<h2>Liste des apereciations :</h2>
	<table border="1" width="80%">
		<tr>
			<th>id</th>
			<th>description</th>
		</tr>
		<c:forEach items="${notes}" var="note">
			<tr>
				<td>${note.id}</td>
				
				<td><a href="edit.html?id=${note.id}">éditer</a> <a
					href="delete.html?id=${note.id}">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<a href="new.html">Nouvelle appreciation</a>
	<br />
	<br />
	<a href="/PetitDejeuner/admin/note/list.html">List
		</a>


</body>
</html>