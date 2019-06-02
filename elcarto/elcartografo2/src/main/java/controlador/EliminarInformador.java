/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;
import modelo.UsuarioDAO;
import org.primefaces.PrimeFaces;
/**
 *
 * @author francisco
 */
@ManagedBean
public class EliminarInformador {
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
    
    public void eliminaInformador(List<Usuario> usuarios){
        UsuarioDAO udb = new UsuarioDAO();
        Usuario u = obtenUsuario(usuarios);
        PrimeFaces context = PrimeFaces.current();
        if(u!=null){
            if("Informador".equals(u.getRol())){
                udb.delete(u);
                context.executeScript("PF('dlg1').show();");
            }
        }else{
            context.executeScript("PF('dlg2').show();");
        } 
    }
}
