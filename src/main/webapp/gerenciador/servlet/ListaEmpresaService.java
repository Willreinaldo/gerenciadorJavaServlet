package gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

/**
 * Servlet implementation class ListaEmpresaService
 */
@WebServlet("/empresas")
public class ListaEmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();

		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String xml = xstream.toXML(empresas);
		response.setContentType("application/xml");
		response.getWriter().print(xml);

		//JSON :
		//	Gson gson = new Gson();
		// String json = gson.toJson(empresas);
		// response.setContentType("application/json");
		// response.getWriter().print(json);
	}

}
