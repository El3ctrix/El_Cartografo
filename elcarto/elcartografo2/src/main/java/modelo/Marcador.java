package modelo;
// Generated 21/05/2019 04:22:37 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Marcador generated by hbm2java
 */
public class Marcador  implements java.io.Serializable {


     private int idMarcador;
     private Tema tema;
     private Usuario usuario;
     private String nombre;
     private String correo;
     private Double latitud;
     private Double longitud;
     private String descripcion;
     private String datos;
     private Set comentarios = new HashSet(0);

    public Marcador() {
    }

	
    public Marcador(int idMarcador, Tema tema, Usuario usuario, String nombre, String correo) {
        this.idMarcador = idMarcador;
        this.tema = tema;
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
    }
    public Marcador(int idMarcador, Tema tema, Usuario usuario, String nombre, 
            String correo, Double latitud, Double longitud, String descripcion, String datos, Set comentarios) {
       this.idMarcador = idMarcador;
       this.tema = tema;
       this.usuario = usuario;
       this.nombre = nombre;
       this.correo = correo;
       this.latitud = latitud;
       this.longitud = longitud;
       this.descripcion = descripcion;
       this.datos = datos;
       this.comentarios = comentarios;
    }
    
    public Marcador(int idMarcador, Tema tema, Usuario usuario, String nombre, 
            String correo, Double latitud, Double longitud, String descripcion, String datos) {
       this.idMarcador = idMarcador;
       this.tema = tema;
       this.usuario = usuario;
       this.nombre = nombre;
       this.correo = correo;
       this.latitud = latitud;
       this.longitud = longitud;
       this.descripcion = descripcion;
       this.datos = datos;
    }
   
    @Override
    public String toString(){
        return nombre + descripcion + datos;
    }
    
    public int getIdMarcador() {
        return this.idMarcador;
    }
    
    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
    }
    public Tema getTema() {
        return this.tema;
    }
    
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Double getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDatos() {
        return this.datos;
    }
    
    public void setDatos(String datos) {
        this.datos = datos;
    }
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }
}        