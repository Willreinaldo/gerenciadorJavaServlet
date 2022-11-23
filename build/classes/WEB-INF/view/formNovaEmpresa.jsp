<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>FORMULARIO</title>
</head>

<body>
		<c:import url="logout-parcial.jsp"/>

		  Usuario Logado: <strong>${usuarioLogado.login } <strong/>

    <br>
    <hr>
	<h5><a href="entrada?acao=ListaEmpresas">IR PARA LISTA DE EMPRESAS</a></h5>
	

    <form action="entrada?acao=NovaEmpresa" method="post">

        Nome: <input type="text" name="nome"  />
        Data Abertura: <input type="text" name="data"  />

        <input type="submit" />
    </form>


</body>

</html>