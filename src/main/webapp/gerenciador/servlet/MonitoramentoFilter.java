package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MonitoramentoFilter implements Filter{
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
		 
	        String acao = request.getParameter("acao");

	      long antes = System.currentTimeMillis();

	      chain.doFilter(request, response);

	      long depois = System.currentTimeMillis();

	        System.out.println("Tempo de execução da ação "+ acao + " -> " +  (depois - antes));
	    }

}
