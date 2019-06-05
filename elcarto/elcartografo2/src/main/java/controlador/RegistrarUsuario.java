/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.mail.MessagingException;
import org.primefaces.PrimeFaces;
/**
 *
 * @author francisco
 */
@ManagedBean
public class RegistrarUsuario {
    
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String correo;
    private String contrasenia;
    private String rol;

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public static String conc(String nombre, String correo, String apellido){
        String nuevaCadena = "@";
        nuevaCadena += nombre + apellido + apellido.substring(0, 3);
        return nuevaCadena;
    }
    
    public void agregaUsuario()throws Exception{
        PrimeFaces context = PrimeFaces.current();
        Usuario u = new Usuario();
        u.setIdusuario(conc(nombre,correo,apaterno));
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setApaterno(apaterno);
        u.setContrasenia(contrasenia);
        u.setCif(Contrasenia.encripta(contrasenia));
        u.setRol("Comentarista");    
        //EmailSender ems = new EmailSender("Comentarista");
        //ems.enviaCorreo(correo);
        context.executeScript("PF('dlg1').show();");
        UsuarioDAO udb = new UsuarioDAO();
        
        udb.save(u);
        
    }
}
