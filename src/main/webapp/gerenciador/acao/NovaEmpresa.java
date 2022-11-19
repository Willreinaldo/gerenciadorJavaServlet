package gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

public class NovaEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cadastrando nova empresa");
        String nomeEmpresa = request.getParameter("nome");
        String paramDataEmpresa = request.getParameter("data");
        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
        	throw new ServletException(e);
        }
    	Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
	}
}