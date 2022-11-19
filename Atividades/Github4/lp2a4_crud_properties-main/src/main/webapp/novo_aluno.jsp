<%@page import="lp2a4.controller.CommandEnum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aluno CRUD</title>
</head>
<body>

<form id="create_form" action="./controller">
	<input type="hidden" name="acao" id="acao" value="<%=CommandEnum.CREATE%>"/>
	<div style="display: flex; flex-flow: column; width: 50%">
		<label>Matrícula</label>
		<input class="edicao" type="text" id="matricula" name="matricula" />
		<label>Nome</label>
		<input class="edicao" type="text" id="nome" name="nome" />
		<label>Endereço</label>
		<input class="edicao" type="text" id="endereco" name="endereco"/>
		<label>Data de Ingresso</label>
		<input class="edicao" type="text" id="dataIngresso" name="dataIngresso"/>
		<label>Data de Conclusão</label>
		<input class="edicao" type="text" id="dataConclusao" name="dataConclusao"/>
	
	</div>
	
	
	<input type="submit" value="Confirmar criação!"/>
</form>
</body>
