<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.persistence.*"%>
<%@page import="crudjpa.modelo.beans.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de prueba de operaciones CRUD con JPA - Eliminar (Delete)</title>
</head>
<body>
Página de prueba de operaciones CRUD con JPA - Eliminar (Delete)<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");

String login = "bubu5";

if (beanDao.removeUsuario(login)) {
	out.println("Se ha eliminado el usuario: "+login);
} else {
	out.println("No se ha encontrado o ha habido un error al eliminar el usuario: "+login);
}

%>
</body>
</html>