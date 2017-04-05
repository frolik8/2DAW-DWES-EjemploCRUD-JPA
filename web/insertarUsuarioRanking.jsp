<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.persistence.*"%>
<%@page import="crudjpa.modelo.beans.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de prueba de operaciones CRUD con JPA - Insertar un Usuario inicializando el ranking a 0 puntos (Create)</title>
</head>
<body>
Página de prueba de operaciones CRUD con JPA - Insertar (Create)<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");
Usuario usuario = new Usuario();
usuario.setLogin("bubu2001");
usuario.setClave("secreta");
usuario.setNombre("Super Bubu");
usuario.setEmail("bubu@superbubu");

Ranking ranking = new Ranking();
ranking.setLogin(usuario.getLogin());
ranking.setPuntos(0);

usuario.setRanking(ranking);


if (beanDao.insert(usuario)) {
	out.println("Se ha insertado el usuario: "+usuario.getNombre()+", inicializando el ranking a "+usuario.getRanking().getPuntos());
} else {
	out.println("Hubo un problema en la inserción. Consultar consola servidor.");
}

%>
</body>
</html>