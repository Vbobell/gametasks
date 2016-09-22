/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lhries
 */
@WebFilter(filterName = "FiltroAcesso", urlPatterns = {"/faces/usuario.xhtml"})
public class FiltroAcesso implements Filter {

    //Obtendo o objeto UsuarioMB da sess�o
    @Inject 
    private UsuarioMb usuarioMB;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        //Obtem o request e response para utilizacao Web
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //Se o usu�rio estiver logado 
        if (usuarioMB != null && usuarioMB.isLogado()) {            
            //deixa acessar o recurso
            chain.doFilter(request, response);
        } else {
            //redireciona para a p�gina de login
            //getContextPath -> Caminho da aplica��o
            resp.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
