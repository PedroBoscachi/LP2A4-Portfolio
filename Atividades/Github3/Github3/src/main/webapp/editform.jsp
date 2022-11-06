<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição do Filme</title>
</head>
<body>

	<%@page import="com.github3.beans.*, com.github3.dao.*" %>
	
	<%
		String id = request.getParameter("id");
		Filme filme = FilmeDao.getRegistroById(Integer.parseInt(id));
	%>
	
	<h1>Edição do Filme</h1>
	
	<form action="editfilme.jsp" method="post">
		<input type="hidden" name="id" value="<%=filme.getId()%>"/>
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" value="<%=filme.getNome()%>"/></td>
			</tr>
			<tr>
				<td>Diretor: </td>
				<td><input type="text" name="diretor" value="<%=filme.getDiretor()%>"/></td>
			</tr>
			<tr>
				<td>Gênero: </td>
				<td><input type="text" name="genero" value="<%=filme.getGenero()%>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Editar Filme"></td>
			</tr>
		</table>
	</form>

</body>
</html>