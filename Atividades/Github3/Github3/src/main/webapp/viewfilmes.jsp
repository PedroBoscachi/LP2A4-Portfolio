<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Filmes</title>
</head>
<body>
<%@ page import="com.github3.dao.*, com.github3.beans.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1>Listagem de Filmes</h1>
	
	<%
		List<Filme> list = FilmeDao.getAllFilmes();
		request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Diretor</th>
			<th>Gênero</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${list}" var="filme">
			<tr>
				<td>${filme.getId()}</td>
				<td>${filme.getNome()}</td>
				<td>${filme.getDiretor()}</td>
				<td>${filme.getGenero()}</td>
				<td><a href="editform.jsp?id=${filme.getId() }">Editar</a></td>
				<td><a href="deletefilme.jsp?id=${ filme.getId() }">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	
	<a href="addfilmeform.jsp">Adicionar novo Filme</a>
	
</body>
</html>