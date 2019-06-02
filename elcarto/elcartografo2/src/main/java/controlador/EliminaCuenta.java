/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Usuario;
import modelo.UsuarioDAO;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.PrimeFaces;
/**
 *
 * @author francisco
 */
@ManagedBean
public class EliminaCuenta{
    private String idusuario;

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    
    public Usuario obtenUsuario(List<Usuario> usuarios){
        Usuario u1 = null;
        for(Usuario u:usuarios){
            if(u.getIdusuario().equals(this.idusuario))
                u1 = u;
        }
        return u1;
    }
    
    public void eliminaCuenta(List<Usuario> usuarios){     
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
