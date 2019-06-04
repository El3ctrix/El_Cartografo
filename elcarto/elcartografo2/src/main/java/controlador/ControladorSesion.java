/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author francisco
 */
@ManagedBean
@SessionScoped
public class ControladorSesion implements Serializable{

    private String correo;
    private String contrasenia;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private Usuario usuario;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getUsrNombre(){
        return this.nombre;
    }
    
    public String getUsrAPaterno(){
        return this.apaterno;
    }
    
    public String getUsrAMaterno(){
        return this.amaterno;
    }
    
    public String getUsrCorreo(){
        return this.correo;
    }
    
    public String getUsrContrasena(){
        return this.contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }
    
    
    public String login(){
        UsuarioDAO udb = new UsuarioDAO();
        Usuario user = udb.buscaPorCorreoContrasenia(correo, contrasenia);
        setUsuario(user);
        setNombre(user.getNombre());
        setAmaterno(user.getAmaterno());
        setApaterno(user.getApaterno());
        setCorreo(user.getCorreo());
        setContrasenia(user.getContrasenia());
        FacesContext context = FacesContext.getCurrentInstance();
         if(user !=null){
            UserLogged u = new UserLogged(user.getNombre(),user.getCorreo(),user.getRol());
            if(null == user.getRol()){
                return "/PaginaPrincipalIH?faces-redirect=true";
            }else switch (user.getRol()) {
                case "Comentarista":
                    context.getExternalContext().getSessionMap().put("Comentarista", u);
                    return "/Comen/PaginaComenIH?faces-redirect=true";
                case "Administrador":
                    context.getExternalContext().getSessionMap().put("Administrador", u);
                    return "/Admin/PaginaAdminIH?faces-redirect=true";
                case "Informador":
                    context.getExternalContext().getSessionMap().put("Informador", u);
                    return "/Info/PaginaInfoIH?faces-redirect=true";
                default:
                    return "/PaginaPrincipalIH?faces-redirect=true";
            }
            
        }
        Mensajes.error("No existe ese usuario");

        return "";
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "../PaginaPrincipalIH.xhtml";
    }
    
    public String redirect(){
        String cadena = "";
        switch (usuario.getRol()) {
            case "Comentarista":
                cadena = "/Comen/PaginaComenIH?faces-redirect=true";
                break;
            case "Administrador":
                cadena = "/Admin/PaginaAdminIH?faces-redirect=true";
                break;
            case "Informador":
                cadena = "/Info/PaginaInfoIH?faces-redirect=true";
                break;
        }
        return cadena;
    }
    
     public class UserLogged implements Serializable{
        private String nombre;
        private String correo;
        private String rol;

        public UserLogged(String nombre, String correo, String rol) {
            this.nombre = nombre;
            this.correo = correo;
            this.rol = rol;
        }

        
        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }
        
        
}

}