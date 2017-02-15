<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.persistence.*"%>
<%@page import="crudjpa.modelo.beans.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de prueba de operaciones CRUD con JPA - Actualizar (Update)</title>
</head>
<body>
Página de prueba de operaciones CRUD con JPA - Actualizar (Update)<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");
Usuario usuario = new Usuario();
usuario.setLogin("bubu5");
usuario.setClave("NuevaClave");
usuario.setEmail("NuevoEmail@bubu5.com");
usuario.setNombre("Nuevo Nombre Bubu5");

if (beanDao.updateUsuario(usuario)) {
	out.println("Se ha actualizado el usuario: "+usuario.getLogin());
} else {
	out.println("No se ha encontrado o ha habido un error al actualizar el usuario: "+usuario.getLogin());
}

%>
</body>
</html>