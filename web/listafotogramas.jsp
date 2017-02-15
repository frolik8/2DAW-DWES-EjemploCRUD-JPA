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
Página de prueba de operaciones CRUD con JPA - Listado Fotogramas<br>
<%

DAO beanDao = new DAOImpl("EjemploCRUDJPA");

List<Fotograma> listaFotogramas = null;

if ((listaFotogramas = beanDao.getFotogramas())!=null) {

	out.println("Listado de los fotogramas<br>");

	for (Fotograma fotograma: listaFotogramas) {

		out.println("idFotograma: "+fotograma.getIdFotograma()+" - "+fotograma.getArchivo()+" - "+fotograma.getTitPelicula()+"<br>");

	}
} else {
	out.println("No se ha encontrado o ha habido un error al listar los fotogramas.<br>");
}
%>
</body>
</html>