package controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author francisco
 */
@WebFilter("/user/comentarista/*")
public class FilterSessionComentarista implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
         if (session.getAttribute("user") == null) {
            res.sendRedirect(req.getContextPath() + "/PaginaPrincipalIH.xhtml"); 
        }
        else {
            ControladorSesion.UserLogged u = (ControladorSesion.UserLogged) session.getAttribute("user");
            if(!"Comentarista".equals(u.getRol())){
                res.sendRedirect(req.getContextPath() + "/PaginaPrinciplaIH.xhtml");
            }else{
                chain.doFilter(req, res); 
            }
        }
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
