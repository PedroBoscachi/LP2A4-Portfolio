<%@page import="com.github3.dao.FilmeDao"%>
<jsp:useBean id="f" class="com.github3.beans.Filme"></jsp:useBean>
<jsp:setProperty property="*" name="f"/>

<%
	int i = FilmeDao.salvarFilme(f);

	if(i > 0) {
		response.sendRedirect("addfilme-success.jsp");
	} else {
		response.sendRedirect("addfilme-error.jsp");
	}
%>