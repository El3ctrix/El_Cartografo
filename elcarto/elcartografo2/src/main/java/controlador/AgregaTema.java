/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.Tema;
import modelo.TemaDAO;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;

/**
 *
 * @author francisco
 */
@ManagedBean
public class AgregaTema {
    private String nombre;
  
    private Usuario usuario;
    
    private String color;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getColor() {
       return this.color;
    }
    
    public void setColor(String color) {
       this.color = color;
    }
    
    public void agregaTema(Usuario u){
        Tema t = new Tema();

        TemaDAO tdao = new TemaDAO();
        t.setNombre(nombre);
        t.setUsuario(u);
        t.setColor(color);
        if(tdao.find(nombre) == null){
            tdao.save(t);
        }
    }
}