<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD PEDRO</title>
</head>
<body>
<jsp:useBean id="aluno" class="lp2a4.AlunoPOJO" scope="request"></jsp:useBean>
	<table border="1">
		<tr>
			<td>
				<b>Matrícula: </b>
			</td>
			<td><%= aluno.getMatricula() %></td>
		</tr>
		<tr>
			<td>
				<b>Nome: </b>
			</td>
			<td><%= aluno.getNome() %></td>
		</tr>
	</table>
</body>
</html>