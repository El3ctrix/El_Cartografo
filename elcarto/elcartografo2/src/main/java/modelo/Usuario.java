package modelo;
// Generated 21/05/2019 04:22:37 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String idusuario;
     private String nombre;
     private String apaterno;
     private String amaterno;
     private String contrasenia;
     private String correo;
     private String rol;
     private String cif;
     private Set comentarios = new HashSet(0);
     private Set marcadors = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String idusuario, String nombre, String apaterno, String contrasenia, String correo, String rol) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.rol = rol;
    }
    public Usuario(String idusuario, String nombre, String apaterno, String amaterno, String contrasenia, 
            String correo, String rol, String cif, Set comentarios, Set marcadors) {
       this.idusuario = idusuario;
       this.nombre = nombre;
       this.apaterno = apaterno;
       this.amaterno = amaterno;
       this.contrasenia = contrasenia;
       this.correo = correo;
       this.rol = rol;
       this.cif = cif;
       this.comentarios = comentarios;
       this.marcadors = marcadors;
    }
   
    public String getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApaterno() {
        return this.apaterno;
    }
    
    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }
    public String getAmaterno() {
        return this.amaterno;
    }
    
    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getCif() {
        return this.cif;
    }
    
    public void setCif(String cif) {
        this.cif = cif;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
    public Set getMarcadors() {
        return this.marcadors;
    }
    
    public void setMarcadors(Set marcadors) {
        this.marcadors = marcadors;
    }
}

