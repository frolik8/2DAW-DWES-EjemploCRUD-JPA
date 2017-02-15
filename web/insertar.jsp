<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.persistence.*"%>
<%@page import="crudjpa.modelo.beans.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de prueba de operaciones CRUD con JPA - Insertar (Create)</title>
</head>
<body>
Página de prueba de operaciones CRUD con JPA - Insertar (Create)<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");
Genero genero = new Genero();
genero.setGenero("Terrorifica");

if (beanDao.insert(genero)) {
	out.println("Se ha insertado el género: "+genero.getGenero());
} else {
	out.println("Hubo un problema en la inserción. Consultar consola servidor.");
}

%>
</body>
</html>