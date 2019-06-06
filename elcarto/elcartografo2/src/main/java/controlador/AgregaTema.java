/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.io.Serializable;
import modelo.Tema;
import modelo.TemaDAO;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;

/**
 *
 * @author francisco
 */
@ManagedBean
public class AgregaTema implements Serializable{
    private String nombre;
  
    private Usuario usuario;

    private String correo;

    private TemaDAO temaDAO;
    
    private Tema tema;
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
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
    
    
    public void agregraTema(Usuario usuario){
        /**Tema u = new Tema();

        TemaDAO udao = new TemaDAO();
        
        u.setNombre(nombre);
        
        u.setCorreo(usuario.getCorreo());
        
        if(udao.find(nombre) == null){
            udao.save(u);
        }*/
        System.out.println(usuario.getCorreo());
        //Tema tema = new Tema(nombre, usuario.getCorreo());
        
        
        temaDAO = new TemaDAO();
        tema = temaDAO.encuentraNombre(nombre);
        
        if(tema == null){
//            tema.setNombre(nombre);
  //          tema.setCorreo(usuario.getCorreo());
            tema = new Tema(nombre, usuario.getCorreo());
            temaDAO.save(tema);
            
            System.out.println(tema);
        }
        
    }
}
