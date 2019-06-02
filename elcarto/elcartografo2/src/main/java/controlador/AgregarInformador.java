/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import static controlador.RegistrarUsuario.conc;
import modelo.Usuario;
import modelo.UsuarioDAO;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.security.SecureRandom;
import java.math.BigInteger;
import javax.mail.MessagingException;

/**
 *
 * @author francisco
 */
@ManagedBean
@RequestScoped
public class AgregarInformador {
 private String correo;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String contrasenia;
    private String rol;
    private String apellido;
    private Set temas = new HashSet(0);
    private Set marcadors = new HashSet(0);
    private Set comentarios = new HashSet(0);

    
    public String getApellido() {
        return apellido;
    }
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getApaterno() {
        return apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Set getTemas() {
        return temas;
    }

    public void setTemas(Set temas) {
        this.temas = temas;
    }

    public Set getMarcadors() {
        return marcadors;
    }

    public void setMarcadors(Set marcadors) {
        this.marcadors = marcadors;
    }

    public Set getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
   
    
    public void separaApellido(String apellido){
       String[] apellidos = apellido.split(" ");
       if(apellidos[0]== null){
           setApaterno(" ");
       }
       else{
           setApaterno(apellidos[0]);
       }
       if(apellidos[1]== null){
           setApaterno(" ");
       }
       else{       
       setAmaterno(apellidos[1]);
       }
    }
    
    public static String conc(String nombre, String correo, String apellido){
        String nuevaCadena = "@";
        nuevaCadena += nombre + apellido + apellido.substring(0, 3);
        return nuevaCadena;
    }
    
    public void agregarInformador()throws MessagingException{
        separaApellido(apellido);
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setIdusuario(conc(nombre,correo,apaterno));
        u.setCorreo(correo);
        u.setApaterno(apaterno);
        u.setAmaterno(amaterno);
        u.setContrasenia(generaContrasenia(10));  
        u.setRol("Informador");
        EmailSender ems = new EmailSender();
        ems.enviaCorreo(correo);
        UsuarioDAO udb = new UsuarioDAO();
        udb.save(u);
        
    }

    private String generaContrasenia(int i) {
      SecureRandom srand = new SecureRandom();
      String contrasenia = new BigInteger(130, srand).toString(32);
      return contrasenia.substring(0,i);
    }

    
    
}