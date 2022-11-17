<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/alteraEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<title>FORMULARIO</title>
</head>

<body>
	<h5><a href="listaEmpresasServlet">VOLTAR A LISTA</a></h5>
	<form action="${linkServletNovaEmpresa}" method="POST"> 
		<h4>ALTERAR DADOS DA EMPRESA:</h4>
		Nome: <input type="text" name="nome" value="${empresa.nome}"> </input>
		Data Abertura: <input type="text" name="data"value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
		 <input type="hidden" name="id" value="${empresa.id }">
		<input type="submit"> </input>
	</form>

</body>

</html>