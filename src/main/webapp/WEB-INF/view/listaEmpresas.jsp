<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de E</title>
</head>
		<c:import url="logout-parcial.jsp"/>
		  Usuario Logado: <strong>${usuarioLogado.login } <strong/>

    <br>
    <br>
        <c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
        </c:if>
        		<h5><a href="entrada?acao=NovaEmpresaForm">VOLTAR AO FORMUL�RIO</a></h5>
        		    <hr>

    Lista de empresas:
     <br />
    <ul>
        <c:forEach items="${empresas}" var="empresa">
            <li>${empresa.nome} <fmt:formatDate value="${empresa.dataAbertura}"  pattern="dd/MM/yyyy"/>
              <a href="/gerenciador1/entrada?acao=RemoveEmpresa&id=${empresa.id }">remover</a>
              <a href="/gerenciador1/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
            </li>
        </c:forEach>
    </ul>