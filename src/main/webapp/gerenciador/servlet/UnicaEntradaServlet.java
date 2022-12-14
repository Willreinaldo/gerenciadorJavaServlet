package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		

	    String paramAcao = request.getParameter("acao"); 
			
			String nomeDaClasse = "gerenciador.acao." + paramAcao;
		    Acao acao;
			try {
				Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome 
				acao = (Acao) classe.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

				throw new ServletException(e);
			} 
			
			
	        String nome = acao.executa(request, response);
			
	        String[] tipoEEndereco = nome.split(":");
	        if(tipoEEndereco[0].equals("forward")) {
	            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
	            rd.forward(request, response);
	        } else {
	            response.sendRedirect(tipoEEndereco[1]);

	        }

	}

}
