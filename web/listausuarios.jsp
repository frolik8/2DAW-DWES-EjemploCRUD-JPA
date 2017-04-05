<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.persistence.*"%>
<%@page import="crudjpa.modelo.beans.dao.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de prueba de operaciones CRUD con JPA - Listado Fotogramas</title>
</head>
<body>
Página de prueba de operaciones CRUD con JPA - Listado Usuarios<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");

List<Usuario> listaUsuarios = null;

if ((listaUsuarios = beanDao.getUsuarios())!=null) {

	out.println("Listado de los usuarios<br>");

	for (Usuario usuario: listaUsuarios) {

		out.println("Nombre usuario: "+usuario.getNombre()+" - Login usuario: "+usuario.getLogin()+" - "+usuario.getRanking().getPuntos());
		out.println("<br>");

	}
} else {
	out.println("No se ha encontrado o ha habido un error al listar los usuarios.<br>");
}
%>
</body>
</html>