/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.UsuarioDAO;
import modelo.Usuario;
import org.primefaces.PrimeFaces;

/**
 *
 * @author francisco
 */
@ManagedBean(name="editaD")
@ViewScoped
public class EditaDatos implements Serializable{
 
    private String nombre;  
    private String correo;
    private String contrasenia;
    private String apaterno;
    private String amaterno;
    private ControladorSesion cs = new ControladorSesion();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public void setApaterno(String apaterno){
        this.apaterno = apaterno;
    }
    
    public void setAmaterno(String amaterno){
        this.amaterno = amaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getApaterno() {
        return apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public ControladorSesion getCs() {
        return cs;
    }
    
    
     public Usuario obtenUsuario(List<Usuario> usuarios){
        Usuario u1 = null;
        for(Usuario u:usuarios){
            if(u.getIdusuario().equals(this.nombre))
                u1 = u;
        }
        return u1;
    }
     
    public void editaDatos(Usuario usuario){
        UsuarioDAO udb = new UsuarioDAO();
        PrimeFaces context = PrimeFaces.current();
        usuario.setNombre(nombre);
        usuario.setApaterno(apaterno);
        usuario.setAmaterno(amaterno);
        usuario.setCorreo(correo);
        usuario.setContrasenia(contrasenia);
        Usuario u = usuario;
        udb.update(u);
        context.executeScript("PF('dlg1').show();");
        
    }
}
