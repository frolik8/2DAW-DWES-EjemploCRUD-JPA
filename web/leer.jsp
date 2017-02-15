<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.persistence.*"%>
<%@page import="crudjpa.modelo.beans.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de prueba de operaciones CRUD con JPA - Leer (Read)</title>
</head>
<body>
Página de prueba de operaciones CRUD con JPA - Leer (Read)<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");
Genero genero = null;
String id = "Accion";

if ((genero = beanDao.getGenero(id))!=null) {
	out.println("Se ha leído el género: "+genero.getGenero());
} else {
	out.println("No se ha encontrado o ha habido un error al consultar el género: "+id);
}

%>
</body>
</html>