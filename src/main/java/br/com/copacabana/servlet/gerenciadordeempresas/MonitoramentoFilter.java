package br.com.copacabana.servlet.gerenciadordeempresas;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
       long antes = System.currentTimeMillis();

       String acao = request.getParameter("acao");
       chain.doFilter(request, response);

       long depois = System.currentTimeMillis();
       System.out.println("Tempo de execução " + acao + " -> " + (depois - antes));
    }
}
