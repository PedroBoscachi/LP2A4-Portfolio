<%@page import="com.github3.dao.FilmeDao"%>
<jsp:useBean id="f" class="com.github3.beans.Filme"></jsp:useBean>
<jsp:setProperty property="*" name="f"/>

<%
int i = FilmeDao.updateFilme(f);
response.sendRedirect("viewfilmes.jsp");
%>