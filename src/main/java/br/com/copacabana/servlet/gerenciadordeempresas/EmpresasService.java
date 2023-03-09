package br.com.copacabana.servlet.gerenciadordeempresas;

import br.com.copacabana.servlet.model.Banco;
import br.com.copacabana.servlet.model.Empresa;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

@WebServlet(name = "EmpresasService", value = "/empresas")
public class EmpresasService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empresa> empresas = new Banco().getEmpresas();

      /*  Gson gson = new Gson();
        String json = gson.toJson(empresas);
        response.setContentType("application/json");
        response.getWriter().print(json);
        */

        XStream xstream = new XStream();
        xstream.alias("empresa", Empresa.class);
        String xml = xstream.toXML(empresas);
        response.setContentType("application/xml");
        response.getWriter().print(xml);
    }

}
