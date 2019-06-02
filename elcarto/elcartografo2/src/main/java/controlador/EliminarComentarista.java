/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Usuario;
import modelo.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import org.primefaces.PrimeFaces;

/**
 *
 * @author francisco
 */
@ManagedBean
public class EliminarComentarista {
    
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Usuario obtenUsuario(List<Usuario> usuarios){
        Usuario u1 = null;
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(this.correo))
                u1 = u;
        }
        return u1;
    }
    public void eliminaComentarista(List<Usuario> usuarios){
    
        UsuarioDAO udao = new UsuarioDAO();
        Usuario u = obtenUsuario(usuarios);
        PrimeFaces context = PrimeFaces.current();
        if(u!=null){
            udao.delete(u);
            context.executeScript("PF('dlg1').show();");
        }else{
            context.executeScript("PF('dlg2').show();");
        }
    }
}
